package went.finsec.fincode.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Went.Lin
 * @since 3/18/2025
 */
class CUSIPValidatorTest {

    CUSIPValidator validator = CUSIPValidator.getInstance();
    @Test
    void isValid() {
        assertTrue(validator.isValid("91282CCV1"));
        assertTrue(validator.isValid("91282CCV1", null));
    }
}