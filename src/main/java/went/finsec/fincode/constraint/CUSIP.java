package went.finsec.fincode.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import went.finsec.fincode.validator.CUSIPValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Went.Lin
 * @since 3/17/2025
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CUSIPValidator.class)
public @interface CUSIP {
    String message() default "Invalid CUSIP";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
