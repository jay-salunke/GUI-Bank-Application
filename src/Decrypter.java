
import java.security.SecureRandom;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Decrypter {

    public static final String Algorithm = "PBKDF2WithHmacSHA1";
    public static final int SALT_BYTES = 24;
    public static final int HASH_BYTES = 24;
    public static final int PBKDF_ITERATIONS = 1000;
    public static final int ITERATION_INDEX = 0;
    public static final int SALT_INDEX = 1;
    public static final int PBKDF2_INDEX = 2;

    /**
     * Returns a salted PBKDF2 hash of the password.
     *
     * @param   password    the password to hash
     * @return              a salted PBKDF2 hash of the password
     */
    public static String createHash(String password) throws InvalidKeySpecException {
            return createHash(password.toCharArray());
    }
    /**
     * Returns a salted PBKDF2 hash of the password.
     *
     * @param   password    the password to hash
     * @return              a salted PBKDF2 hash of the password
     */
    public static String createHash(char[] password) throws InvalidKeySpecException {

           SecureRandom random = new SecureRandom();
           byte[] salt = new byte[SALT_BYTES];
           random.nextBytes(salt);
           byte[] hash = pbkdf2(password,salt,PBKDF_ITERATIONS,HASH_BYTES);


        return PBKDF_ITERATIONS+":"+toHex(salt)+":"+toHex(hash);
    }
    /**
     *  Computes the PBKDF2 hash of a password.
     *
     * @param   password    the password to hash.
     * @param   salt        the salt
     * @param   iterations  the iteration count (slowness factor)
     * @param   bytes       the length of the hash to compute in bytes
     * @return              the PBDKF2 hash of the password
     */
    private static byte[] pbkdf2(char[] password,byte[] salt,int iterations,int bytes) throws InvalidKeySpecException {

            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
            SecretKeyFactory skf = null;
            try {
                skf = SecretKeyFactory.getInstance(Algorithm);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return skf.generateSecret(spec).getEncoded();
    }
    /**
     * Converts a byte array into a hexadecimal string.
     *
     * @param   array       the byte array to convert
     * @return              a length*2 character string encoding the byte array
     */
    private static String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }
    /**
     * Validates a password using a hash.
     * @param   pass1   the password to check
     * @return          true if the password is correct, false if not
     */
    public static boolean ValidatePassword(String pass1,char[]password) throws InvalidKeySpecException {
        String[] pass  = pass1.split(":");
        int iterations = Integer.parseInt(pass[ITERATION_INDEX]);
        byte[] salt = fromHex(pass[SALT_INDEX]);
        byte[] Hash = fromHex(pass[PBKDF2_INDEX]);
        byte[]testhash = Decrypter.pbkdf2(password,salt,iterations,Hash.length);
        return slowEquals(Hash,testhash);

    }
    /**
     * Converts a string of hexadecimal characters into a byte array.
     *
     * @param   hex         the hex string
     * @return              the hex string decoded into a byte array
     */
    public static byte[] fromHex(String hex)
    {
        byte[] binary = new byte[hex.length() / 2];
        for(int i = 0; i < binary.length; i++)
        {
            binary[i] = (byte)Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }
        return binary;
    }

    /**
     * Compares two byte arrays in length-constant time. This comparison method
     * is used so that password hashes cannot be extracted from an on-line
     * system using a timing attack and then attacked off-line.
     *
     * @param   a       the first byte array
     * @param   b       the second byte array
     * @return          true if both byte arrays are the same, false if not
     */

    public static boolean slowEquals(byte[] a, byte[] b)
    {
        int diff = a.length ^ b.length;
        for(int i = 0; i < a.length && i < b.length; i++)
            diff |= a[i] ^ b[i];
        return diff == 0;
    }



}
