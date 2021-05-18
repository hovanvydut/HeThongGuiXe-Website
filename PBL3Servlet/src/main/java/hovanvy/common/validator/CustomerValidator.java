package hovanvy.common.validator;

import hovanvy.common.validator.CustomerValidator.CustomerValidationResult;
import static hovanvy.common.validator.CustomerValidator.CustomerValidationResult.*;
import hovanvy.entity.Customer;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 *
 * @author hovanvydut
 */

public interface CustomerValidator extends Function<Customer, CustomerValidationResult> {

	static CustomerValidator isEmailValid() {
		return (customer) -> {
			if (customer == null || customer.getEmail() == null) return EMAIL_NOT_VALID;
			
			Pattern pattern = Pattern.compile("^[\\w][a-z0-9_\\.]{4,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,10}$");

			boolean ok = pattern.matcher(customer.getEmail()).matches();

			return ok ? SUCCESS : EMAIL_NOT_VALID;
		};
	}

	static CustomerValidator isFullnameValid() {
		return (customer) -> {
			if (customer == null || customer.getFullname() == null) return FULLNAME_NOT_VALID;
			
			String vietnamese = "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ";
			Pattern pattern = Pattern.compile("^[a-zA-Z" + vietnamese + "]+(\\s[a-zA-Z" + vietnamese + "]+)*$",
					Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

			boolean ok = pattern.matcher(customer.getFullname()).matches();

			return ok ? SUCCESS : FULLNAME_NOT_VALID;
		};
	}

	static CustomerValidator isPhoneValid() {
		return (customer) -> {
			if (customer == null || customer.getPhone() == null) return PHONE_NOT_VALID;
			
			Pattern pattern = Pattern.compile("^((\\+84|84|0)[35789])\\d{8}$");

			boolean ok = pattern.matcher(customer.getPhone()).matches();

			return ok ? SUCCESS : PHONE_NOT_VALID;
		};
	}

	static CustomerValidator isPasswordValid() {
		return (customer) -> {
			if (customer == null || customer.getPassword() == null) return PASSWORD_NOT_VALID;
			int size = customer.getPassword().length();
			boolean ok = (size >= 6 && size <= 20);

			return ok ? SUCCESS : PASSWORD_NOT_VALID;
		};
	}

	static CustomerValidator isUsernameValid() {
		return (customer) -> {
			if (customer == null || customer.getUsername() == null) return USERNAME_NOT_VALID;
			
			Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{3,20}$");

			boolean ok = pattern.matcher(customer.getUsername()).matches();

			return ok ? SUCCESS : USERNAME_NOT_VALID;
		};
	}

	default CustomerValidator and(CustomerValidator other) {
		return (customer) -> {
			CustomerValidationResult result = this.apply(customer);

			return result.equals(SUCCESS) ? other.apply(customer) : result;
		};
	}

	enum CustomerValidationResult {
		SUCCESS, PHONE_NOT_VALID, EMAIL_NOT_VALID, FULLNAME_NOT_VALID, PASSWORD_NOT_VALID, USERNAME_NOT_VALID
	}

}
