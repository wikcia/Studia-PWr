public class StringValidator {

    public static boolean validateString(String input, String regex){
        return input.matches(regex); //matches method tells whether or not this string matches the given regular expression
    }
}