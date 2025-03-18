package went.finsec.fincode.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.validator.routines.CodeValidator;
import org.apache.commons.validator.routines.checkdigit.SedolCheckDigit;
import went.finsec.fincode.constraint.SEDOL;

/**
 * @author Went.Lin
 * @since 3/17/2025
 */
public class SEDOLValidator implements ConstraintValidator<SEDOL, String> {
    private static final SEDOLValidator INSTANCE = new SEDOLValidator();
    public static SEDOLValidator getInstance() {
        return INSTANCE;
    }
    private SEDOLValidator() {
    }
    private static final int SEDOL_LENGTH = 7;
    private static final String SEDOL_REGEX = "^([BCDFGHJKLMNPQRSTVWXYZ0-9]{6}[0-9])$";

    private static final CodeValidator CODE_VALIDATOR = new CodeValidator(SEDOL_REGEX,SEDOL_LENGTH,SEDOL_LENGTH, SedolCheckDigit.SEDOL_CHECK_DIGIT);
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return  CODE_VALIDATOR.isValid(value);
    }

    public boolean isValid(String s) {
        return isValid(s, null);
    }
}
