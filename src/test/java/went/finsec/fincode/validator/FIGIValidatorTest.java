package went.finsec.fincode.validator;

import org.junit.jupiter.api.Test;
import went.finsec.fincode.validator.checkdigit.FIGICheckDigit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Went.Lin
 * @since 3/18/2025
 */
class FIGIValidatorTest {

    FIGIValidator validator = FIGIValidator.getInstance();

    @Test
    void isValid() {
        assertTrue(validator.isValid("BBG000BLNNH6"));
        assertTrue(validator.isValid("BBG000BLNNH6", null));
    }
}