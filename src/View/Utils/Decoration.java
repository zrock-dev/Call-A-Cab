package View.Utils;

/**
 * This class will be decoration.
 *
 * It helps us put a decoration on the
 * messages that the other classes request.
 *
 * @author AfricanRiot
 */
public class Decoration {

    /**
     * This method gives the decoration of the message.
     *
     * It gives decorative borders
     * for the messages depending on the
     * parameters that are required.
     *
     * @param decorativeElement We can put what decoration you want to print.
     * @param numberRepetitions We can put how many times you want the decoration
     *                          to appear.
     * @return returns the type of decoration you need, plus how many times it
     * will repeat.
     */
    public static String decorationForMessage(String decorativeElement, int numberRepetitions){
        return decorativeElement.repeat(numberRepetitions);
    }

    /**
     * This is a decorationForMessage method override.
     *
     * It gives the necessary decorations but with
     * a static number of 124 since it is repeated
     * several times.
     *
     * @param decorativeElement We can put what decoration you want to be printed.
     * @return Returns the requested decoration, plus how many times you want it to be
     * repeated and a line break.
     */
    public static String decorationForMessage(String decorativeElement){
        int numberOfRepetitions = 124;
        return decorativeElement.repeat(numberOfRepetitions) + "\n";
    }
}
