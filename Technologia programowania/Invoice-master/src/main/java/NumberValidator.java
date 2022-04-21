/**
 * Satisfied for GRASP(Cohesion)
 * When we compare classes: StringValidator, EnumValidator and NumberValidator
 * we can notice that their methods' functionality and degree of generality are analogous
 */
public class NumberValidator {

    public static boolean validateDouble(String input, double min, double max) {
        if (input.matches(Constants.DOUBLE_REGEX)) {
            double value = Double.valueOf(input);
            if (value >= min && value <= max) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateInteger(String input, int min, int max) {
        if (input.matches(Constants.INTEGER_REGEX)) {
            double value = Integer.valueOf(input);
            if (value >= min && value <= max) {
                return true;
            }
        }
        return false;
    }
}