
import java.util.SplittableRandom;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
public class EmailSend extends Mail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SplittableRandom otp = new SplittableRandom();
        boolean otpSuccess = false;
        String s = "jay";

       Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                System.out.println("expired");
                System.exit(0);
            }
        };

        timer.schedule(task,5000);
while(!(otpSuccess)){
    System.out.println("Enter the String: ");
    String j = sc.nextLine();
    if(s.equals(j)){
        System.out.println("Success");
        timer.cancel();
        break;
    }

}


      













    }
}
