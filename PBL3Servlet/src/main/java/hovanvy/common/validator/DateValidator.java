package hovanvy.common.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.function.Function;
import hovanvy.common.validator.DateValidator.DateValidationResult;
import static hovanvy.common.validator.DateValidator.DateValidationResult.*;

public interface DateValidator extends Function<String, DateValidationResult> {
	
	static DateValidator isValid() {
		return (str) -> {
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-M-d")
						.withResolverStyle(ResolverStyle.STRICT);
				
				dtf.parse(str);
				
				return SUCCESS;
			} catch (DateTimeParseException ex) {
				return DATE_FORMAT_NOT_VALID;
			}
		};
	}
	
	default DateValidator and(DateValidator other) {
		return (str) -> {
			DateValidationResult result = this.apply(str);
			
			return (result.equals(SUCCESS)) ? other.apply(str) : result;
		};
	}
	
	default DateValidator or (DateValidator other) {
		return (str) -> {
			DateValidationResult result = this.apply(str);
			
			return (result.equals(DATE_FORMAT_NOT_VALID)) ? result : other.apply(str);
		};
	}
	
	enum DateValidationResult {
		SUCCESS,
		DATE_FORMAT_NOT_VALID
	}
}
