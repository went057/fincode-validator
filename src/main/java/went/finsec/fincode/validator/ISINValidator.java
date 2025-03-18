package went.finsec.fincode.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import went.finsec.fincode.constraint.ISIN;

/**
 * @author Went.Lin
 * @since 3/7/2025
 */
public class ISINValidator implements ConstraintValidator<ISIN, String> {

    private static final ISINValidator instance = new ISINValidator();
    public static ISINValidator getInstance() {
        return instance;
    }

    private ISINValidator() {
    }
    private final org.apache.commons.validator.routines.ISINValidator commonsIsinValidator = org.apache.commons.validator.routines.ISINValidator.getInstance(true);
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return commonsIsinValidator.isValid(s);
    }

    public boolean isValid(String s) {
        return isValid(s, null);
    }
}
