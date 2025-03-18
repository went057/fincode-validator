package went.finsec.fincode.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import went.finsec.fincode.validator.ISINValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Went.Lin
 * @since 3/7/2025
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ISINValidator.class)
public @interface ISIN {
    String message() default "Invalid ISIN";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
