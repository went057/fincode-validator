package went.finsec.fincode.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Went.Lin
 * @since 3/18/2025
 */
class ISINValidatorTest {

    ISINValidator validator = ISINValidator.getInstance();
    @Test
    void isValid() {
        assertTrue(validator.isValid("US0378331005"));
        assertTrue(validator.isValid("US0378331005", null));
    }
}