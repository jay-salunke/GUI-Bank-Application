import java.util.SplittableRandom;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
public class EmailSend extends Mail {

    public static void OTPDestroy(){
        System.out.println("OTP is fully destroyed");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SplittableRandom otp = new SplittableRandom();
        System.out.println(otp.nextInt());
         int otpget;
        otpget = sc.nextInt();

//        StringBuilder sb = new StringBuilder();
//        for(int i =0;i<5;i++){
//             sb.append(otp.nextInt(0,10));
//        }
       Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
               System.out.println("Otp get destroys");
            }
        };
        timer.schedule(task,5000);





    }
}
