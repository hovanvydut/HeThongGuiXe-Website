package common.validator;

import hovanvy.common.validator.CustomerValidator;
import hovanvy.common.validator.CustomerValidator.CustomerValidationResult;
import static hovanvy.common.validator.CustomerValidator.CustomerValidationResult.*;
import static hovanvy.common.validator.CustomerValidator.*;
import hovanvy.entity.Customer;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 *
 * @author hovanvydut
 */

@DisplayName("Test CustomerValidator")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class CustomerValidatorTest {

	@BeforeEach
	public void init() {

	}

	@Test
	@DisplayName("Test invalid email")
	public void testInvalidEmail() {
		String[] emailCollection = new String[] { ".hovanvy@gmail.com", "abc@gmail.com", "ab.c@gmail.com", };

		Customer customer = new Customer();

		for (String email : emailCollection) {
			customer.setEmail(email);

			CustomerValidationResult result = CustomerValidator.isEmailValid().apply(customer);

			assertEquals(EMAIL_NOT_VALID, result);
		}
	}

	@Test
	@DisplayName("Test valid email")
	public void testValidEmail() {
		String[] emailCollection = new String[] { "hovanvydut@gmail.com", "102190200@sv1.dut.udn.vn",
				"hovanvy@outlook.com", "ho_van_vy@yahoo.com" };

		Customer customer = new Customer();

		for (String email : emailCollection) {
			customer.setEmail(email);

			CustomerValidationResult result = isEmailValid().apply(customer);

			assertEquals(SUCCESS, result);
		}
	}

	@Test
	@DisplayName("Test valid mobile phone number")
	public void testValidPhone() {
		String[] phoneNumbers = new String[] { "0972026726", "+84972026726", "0906090749" };

		Customer customer = new Customer();

		for (String phone : phoneNumbers) {
			customer.setPhone(phone);
			CustomerValidationResult result = isPhoneValid().apply(customer);

			assertEquals(SUCCESS, result);
		}
	}

	@Test
	@DisplayName("Test invalid phone number")
	public void testInvalidPhone() {
		String[] phoneNumbers = new String[] { 
				"0123456789",
				"+849720267261" ,
				"02369012011"
		};

		Customer customer = new Customer();

		for (String phone : phoneNumbers) {
			customer.setPhone(phone);
			CustomerValidationResult result = isPhoneValid().apply(customer);

			assertEquals(PHONE_NOT_VALID, result);
		}
	}
	
	@Test
	@DisplayName("Compose validate both email and phone")
	public void testEmailAndPhone() {
		Customer customer = new Customer();
		
		customer.setEmail("hovanvydut@gmail.com");
		customer.setPhone("0938537212");
		CustomerValidationResult result = isEmailValid().and(isPhoneValid()).apply(customer);
		assertEquals(SUCCESS, result);
		
		customer.setEmail("hovanvydut@gmail.com");
		customer.setPhone("0123456789");
		result = isEmailValid().and(isPhoneValid()).apply(customer);
		assertEquals(PHONE_NOT_VALID, result);
	}
	
	@AfterEach
	public void tearDown() {

	}

}
