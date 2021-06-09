import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Mail {
   public void sendEmail(String recipient, int rand){
       Properties props = new Properties();
       props.put("mail.smtp.auth","true");
       props.put("mail.smtp.starttls.enable","true");
       props.put("mail.smtp.host","smtp.gmail.com");
       props.put("mail.smtp.port","587");

       final String  EmailID ="XXX Email ID";
       final String Pass = "XXX Pass XXx";
       final String Subject = "Mail Test";
       final String Text="<h4>This is Mail Test send through javax.MailAPI</h4><br/><h4> your OTP is:"+rand+" <h4> imp note: Don't share with anyone";
     Session s = Session.getInstance(props, new Authenticator() {
         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(EmailID,Pass);
         }
     });

    try{
        Message msg = new MimeMessage(s);
        msg.setFrom(new InternetAddress(EmailID));
        msg.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
        msg.setSubject(Subject);
       msg.setContent(Text,"text/html");
        Transport.send(msg);
    }catch (Exception e){
       e.printStackTrace();
    }







   }
}
