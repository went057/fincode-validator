package went.finsec.fincode.validator.checkdigit;

import org.apache.commons.validator.routines.checkdigit.CheckDigit;
import org.apache.commons.validator.routines.checkdigit.CheckDigitException;

/**
 * @author Went.Lin
 * @since 3/17/2025
 */
public class FIGICheckDigit implements CheckDigit{
    public static final CheckDigit FIGI_CHECK_DIGIT = new FIGICheckDigit();
    @Override
    public String calculate(String code) throws CheckDigitException {
        if (code.length() != 11) {
            throw new CheckDigitException("Invalid FIGI code");
        }
        int sum = 0;
        for (int  i= 10; i >=0; i--) {
            char c = code.charAt(i);
            int weight = (i % 2 == 0 ? 1 : 2);
            int value = Character.getNumericValue(c)* weight;
            while (value>0){
                sum+=value%10;
                value/=10;
            }
        }
        if (sum % 10 == 0) {
            return "0";
        } else {
            return String.valueOf(10 - (sum % 10));
        }
    }

    @Override
    public boolean isValid(String code) {
        if (code.length() == 12) {
            try {
                String checkDigit = code.substring(11);
                String codeWithoutCheckDigit = code.substring(0, 11);
                String calculatedCheckDigit = calculate(codeWithoutCheckDigit);
                return checkDigit.equals(calculatedCheckDigit);
            } catch (CheckDigitException e) {
                return false;
            }
        }
        return false;
    }
}
