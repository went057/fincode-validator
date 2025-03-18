package went.finsec.fincode.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Went.Lin
 * @since 3/18/2025
 */
class SEDOLValidatorTest {

    SEDOLValidator validator = SEDOLValidator.getInstance();
    @Test
    void isValid() {
        assertTrue(validator.isValid("BP4BWP2"));
        assertTrue(validator.isValid("BP4BWP2", null));
    }
}