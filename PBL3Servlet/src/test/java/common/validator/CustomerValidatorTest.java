package common.validator;

import hovanvy.common.validator.CustomerValidator;
import hovanvy.common.validator.CustomerValidator.CustomerValidationResult;
import static hovanvy.common.validator.CustomerValidator.CustomerValidationResult.*;
import static hovanvy.common.validator.CustomerValidator.*;
import hovanvy.entity.Customer;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
	@DisplayName("Test invalid mobile phone number")
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
	
	@DisplayName("Test invalid username")
	@ParameterizedTest(name = "#{index} - Run test with username = {0}")
	@MethodSource("invalidUsernameProvider")
	public void testInvalidUsername(String username) {
		Customer customer = new Customer();
		customer.setUsername(username);
		
		CustomerValidationResult result = isUsernameValid().apply(customer);
		assertEquals(USERNAME_NOT_VALID, result);
	}
	
	@DisplayName("Test valid username")
	@ParameterizedTest(name = "#{index} - Run test with username = {0}")
	@MethodSource("validUsernameProvider")
	public void testValidUsername(String username) {
		Customer customer = new Customer();
		customer.setUsername(username);
		
		CustomerValidationResult result = isUsernameValid().apply(customer);
		assertEquals(SUCCESS, result);
	}
	
	@DisplayName("Test invalid fullname")
	@ParameterizedTest(name = "#{index} - Run test with username = {0}")
	@MethodSource("invalidFullnameProvider")
	public void testInvalidFullname(String fullname) {
		Customer customer = new Customer();
		customer.setFullname(fullname);
		
		CustomerValidationResult result = isFullnameValid().apply(customer);
		assertEquals(FULLNAME_NOT_VALID, result);
	}
	
	@DisplayName("Test valid fullname")
	@ParameterizedTest(name = "#{index} - Run test with username = {0}")
	@MethodSource("validFullnameProvider")
	public void testValidFullname(String fullname) {
		Customer customer = new Customer();
		customer.setFullname(fullname);
		
		CustomerValidationResult result = isFullnameValid().apply(customer);
		assertEquals(SUCCESS, result);
	}
	
	@DisplayName("Test invalid password")
	@ParameterizedTest(name = "#{index} - Run test with password = {0}")
	@MethodSource("invalidPasswordProvider")
	public void testInvalidPassword(String password) {
		Customer customer = new Customer();
		customer.setPassword(password);
		
		CustomerValidationResult result = isPasswordValid().apply(customer);
		assertEquals(PASSWORD_NOT_VALID, result);
	}
	
	@DisplayName("Test valid password")
	@ParameterizedTest(name = "#{index} - Run test with password = {0}")
	@MethodSource("validPasswordProvider")
	public void testValidPassword(String password) {
		Customer customer = new Customer();
		customer.setPassword(password);
		
		CustomerValidationResult result = isPasswordValid().apply(customer);
		assertEquals(SUCCESS, result);
	}
	
	
	@AfterEach
	public void tearDown() {

	}
	
	static Stream<String> invalidUsernameProvider() {
		return Stream.of(
				"a",
				"az",
				"       ",
				"abcdef123!",
				"123456789012345678901",
				null
				);
	}
	
	static Stream<String> validUsernameProvider() {
		return Stream.of(
				"abc",
				"abcd123",
				"123abc",
				"123",
				"12345678901234567890",
				"usernameusername1"
				);
	}
	
	static Stream<String> invalidFullnameProvider() {
		return Stream.of(
				"An 1",
				null
				);
	}
	
	static Stream<String> validFullnameProvider() {
		return Stream.of(
				"Ho Van Vy",
				"ho van vy ho van vy",
				"a",
				"a b" ,
				" aa bb ",
				"aa b    ",
				"   a      b   ",
				"Hồ Văn Vy"
				);
	}
	
	static Stream<String> invalidPasswordProvider() {
		return Stream.of(
				"123",
				"12345",
				"1234567890 12345678901",
				null,
				"   "
				);
	}
	
	static Stream<String> validPasswordProvider() {
		return Stream.of(
				"123456",
				"1234567890",
				"12345678901234567890",
				"      " ,
				"          ",
				"                    "
				);
	}
}
