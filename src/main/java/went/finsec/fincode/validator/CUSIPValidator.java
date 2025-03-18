package went.finsec.fincode.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.validator.routines.CodeValidator;
import org.apache.commons.validator.routines.checkdigit.CUSIPCheckDigit;
import went.finsec.fincode.constraint.CUSIP;

/**
 * @author Went.Lin
 * @since 3/17/2025
 */
public class CUSIPValidator implements ConstraintValidator<CUSIP, String> {
    private static final CUSIPValidator INSTANCE = new CUSIPValidator();
    public static CUSIPValidator getInstance() {
        return INSTANCE;
    }
    private CUSIPValidator() {
    }

    private static final int CUSIP_LENGTH = 9;

    private static final String CUSIP_PREFIX = "^([0-9A-Z*@#]{8}[0-9])$";

    private static final CodeValidator CODE_VALIDATOR = new CodeValidator(CUSIP_PREFIX,CUSIP_LENGTH,CUSIP_LENGTH,CUSIPCheckDigit.CUSIP_CHECK_DIGIT);
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return CODE_VALIDATOR.isValid(value);
    }

    public boolean isValid(String s) {
        return isValid(s, null);
    }
}
