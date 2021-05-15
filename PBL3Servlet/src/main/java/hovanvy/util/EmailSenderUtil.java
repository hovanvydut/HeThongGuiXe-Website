package hovanvy.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author hovanvydut
 *
 */

public class EmailSenderUtil {
	
	public String sendEmail(String from, String to) {
		final String SMTP = "smtp.gmail.com";
		final String PORT = "587";
		
		final String username = "hovanvydut.test@gmail.com";
		final String password = "abcdef123A!";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", SMTP);
        prop.put("mail.smtp.port", PORT);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject("Your transportation has been checkout");
            message.setContent("<b style='color: red;'>Your transportation has been checkout</b>"
                    + "\n\n Please do not spam my email!", "text/html");
            
            Transport.send(message);

            return "DONE";

        } catch (MessagingException e) {
            e.printStackTrace();
            return "ERROR";
        }
	}
	
	
}
