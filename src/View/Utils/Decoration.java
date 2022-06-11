package View.Utils;

/**
 * This class gives decorative borders.
 */
public class Decoration {
    /**
     * This method gives decorative borders depending on how long is required and which character will be made.
     * @param decorativeElement The character with borders are made.
     * @param numberRepetitions Repeat the character with which the borders will be made.
     * @return decorativeElement.
     */
    public static String decorationForMessage(String decorativeElement, int numberRepetitions){
        return decorativeElement.repeat(numberRepetitions);
    }

    /**
     *This method gives decorative borders depending only on the decorative element.
     * @param decorativeElement The character with borders are made.
     * @return decorativeElement.
     */
    public static String decorationForMessage(String decorativeElement){
        int numberOfRepetitions = 124;
        return decorativeElement.repeat(numberOfRepetitions) + "\n";
    }
}
