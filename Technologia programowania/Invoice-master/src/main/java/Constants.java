/**
 * In this class are defined constants used within the program
 */

//Uwaga! W interfejsie wszystkie pola sa zadeklarowane jako stale
public interface Constants {
    String DOUBLE_REGEX = "([0-9]+)(\\.[0-9]+)?"; //do generowania regexow uzywamy strony regexr.com
    String INTEGER_REGEX = "[0-9]+"; //same cyfry bez czesci z kropka i dalsza czescia cyfry
    String NAME_REGEX = "[A-ZĄ-Ź][a-zą-ź]{2,9}";
    String LAST_NAME_REGEX = "([A-ZĄ-Ź][a-zaą-ź]+)([\\s-]([A-ZĄ-Ź][a-zaą-ź]+))?";
    double VAT = 1.23;
}
