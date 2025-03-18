package went.finsec.fincode.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.validator.routines.CodeValidator;
import went.finsec.fincode.constraint.FIGI;
import went.finsec.fincode.validator.checkdigit.FIGICheckDigit;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Went.Lin
 * @since 3/14/2025
 */
public class FIGIValidator implements ConstraintValidator<FIGI, String> {

    private static final FIGIValidator INSTANCE = new FIGIValidator();

    public static FIGIValidator getInstance() {
        return INSTANCE;
    }

    private FIGIValidator() {
    }

    private static final int FIGI_LENGTH = 12;
    private static final Set<String> PREFIX_EXCEPTION= Stream.of("BS", "BM", "GG", "GB", "GH", "KY", "VG")
            .collect(Collectors.toSet());
    private static final String FIGI_REGEX = "^([BCDFGHJKLMNPQRSTVWXYZ]{2}G[BCDFGHJKLMNPQRSTVWXYZ0-9]{8}[0-9])$";
    private static final CodeValidator CODE_VALIDATOR = new CodeValidator(FIGI_REGEX,FIGI_LENGTH,FIGI_LENGTH, FIGICheckDigit.FIGI_CHECK_DIGIT);

    /**
     * FIGI Structure: 2 consonants(except BS,BM,GG,GB,GH,KY,VG) + 'G' + 8 consonants or digit + 1 check digit
     * @param s FIGI to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if (s == null) {
            return false;
        }
        if (s.length() != FIGI_LENGTH){
            return false;
        }
        if (PREFIX_EXCEPTION.contains(s.substring(0, 2))){
            return false;
        }
        return CODE_VALIDATOR.isValid(s);
    }

    public boolean isValid(String s) {
        return isValid(s,null);
    }
}
