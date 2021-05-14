package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import hovanvy.util.EmailSenderUtil;

@DisplayName("Test send email")
@TestInstance(Lifecycle.PER_METHOD)
public class EmailSenderUtilTest {

	@Test
	@DisplayName("send email to 102190200@sv1.dut.udn.vn")
	public void testSendEmail() {
		EmailSenderUtil emailSender = new EmailSenderUtil();
		
		String result = emailSender.sendEmail("no-reply@gmail.com", "102190200@sv1.dut.udn.vn");
		
		Assertions.assertEquals("DONE", result);
	}
	
}
