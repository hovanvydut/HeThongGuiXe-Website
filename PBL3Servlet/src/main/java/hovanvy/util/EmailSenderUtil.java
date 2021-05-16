package hovanvy.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * 
 * @author hovanvydut
 *
 */

public class EmailSenderUtil {
	private final static String SMTP = "smtp.gmail.com";
	private final static String PORT = "587";
	private final static String username = "hovanvydut.test@gmail.com";
	private final static String password = "abcdef123A!";

	private Session session;
	private Properties prop;

	public static EmailSenderUtil _instance;
	
	public static EmailSenderUtil getInstance() {
		if (_instance == null) {
			_instance = new EmailSenderUtil();
		}
		return _instance;
	}

	private EmailSenderUtil() {
		prop = new Properties();
		prop.put("mail.smtp.host", SMTP);
		prop.put("mail.smtp.port", PORT);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

	public String sendEmail(String from, String to) {

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Your transportation has been checkout");

			// Free marker Template
			Configuration cfg = new Configuration();
			// Assume that the template is available under /src/main/resources/templates
			cfg.setClassForTemplateLoading(EmailSenderUtil.class, "/templates/email");
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			Template template = cfg.getTemplate("checkout_email.ftl");

			// Pass custom param values
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("plate_number", "123123123");
			paramMap.put("checkin_at", "01/01/2001");
			paramMap.put("checkout_at", "01/01/2002");
			Writer out = new StringWriter();

			template.process(paramMap, out);
			BodyPart body = new MimeBodyPart();
			body.setContent(out.toString(), "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(body);

			message.setContent(multipart);

			Transport.send(message);

			return "DONE";

		} catch (MessagingException | IOException | TemplateException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

	public String sendEmailCheckout(String from, String to, String plateNumber, String checkinAt,
			String checkoutAt) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Your transportation has been checkout");

			// Free marker Template
			Configuration cfg = new Configuration();
			// Assume that the template is available under /src/main/resources/templates
			cfg.setClassForTemplateLoading(EmailSenderUtil.class, "/templates/email");
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			Template template = cfg.getTemplate("checkout_email.ftl");

			// Pass custom param values
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("plate_number", plateNumber);
			paramMap.put("checkin_at", checkinAt);
			paramMap.put("checkout_at", checkoutAt);
			Writer out = new StringWriter();

			template.process(paramMap, out);
			BodyPart body = new MimeBodyPart();
			body.setContent(out.toString(), "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(body);

			message.setContent(multipart);

			Transport.send(message);

			return "DONE";

		} catch (MessagingException | IOException | TemplateException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

}
