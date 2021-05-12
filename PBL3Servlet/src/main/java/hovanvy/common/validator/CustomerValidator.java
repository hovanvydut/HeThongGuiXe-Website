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
			Pattern pattern = Pattern.compile("^[\\w][a-z0-9_\\.]{4,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,10}$");

			boolean ok = pattern.matcher(customer.getEmail()).matches();

			return ok ? SUCCESS : EMAIL_NOT_VALID;
		};
	}

	static CustomerValidator isPhoneValid() {
		return (customer) -> {
			Pattern pattern = Pattern.compile("^((\\+84|84|0)[35789])\\d{8}$");

			boolean ok = pattern.matcher(customer.getPhone()).matches();

			return ok ? SUCCESS : PHONE_NOT_VALID;
		};
	}

	default CustomerValidator and(CustomerValidator other) {
		return (customer) -> {
			CustomerValidationResult result = this.apply(customer);

			return result.equals(SUCCESS) ? other.apply(customer) : result;
		};
	}

	enum CustomerValidationResult {
		SUCCESS, PHONE_NOT_VALID, EMAIL_NOT_VALID
	}

}
