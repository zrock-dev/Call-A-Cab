package View;

import View.Utils.*;
import static View.Utils.Decoration.decorationForMessage;
/**
 *This class shows the change menu.
 *
 *This class shows the change menu, reinsert information,
 * enough cars message, and extras.
 */
public class OptionInformation {

    /**
     * This method shows what information the user wants to change.
     *
     * This method displays the available options that
     * you can change before sending the data to the program.
     */
    public void informationToChange() {
        System.out.print(Colors.RESET + "\n╔" +
                decorationForMessage("═", 122) + "╗" +
                "\n" + "║ " + decorationForMessage(">", 38) +
                " Which information would you like to change? " +
                decorationForMessage("<", 37) + " ║\n" +
                "╚" + decorationForMessage("═", 122) + "╝\n" +
                ">> 1. Location\n" +
                ">> 2. Arrive Place\n" +
                ">> 3. Number of Passengers\n>>");
    }

    /**
     * This method is for entering new information.
     *
     * This method displays the message so we
     * can insert new information, which the user
     * wants to re-enter
     */
    public void askForNewInformation() {
        System.out.print(Colors.RESET + "\n" +
                decorationForMessage("♦•", 62) +
                "\n│" + decorationForMessage(" ", 42) +
                " Please, reinsert your new information " +
                decorationForMessage(" ", 41) + "│\n" +
                decorationForMessage("♦•", 62));

    }

    /**
     * This method is for cars not available.
     *
     * displays the message to inform the user that there are
     * no cars available.
     */
    public void cabUnavailable() {
        System.out.println(Colors.RED + "\n" +
                decorationForMessage("≡") +
                decorationForMessage(":○", 27) +
                " We're sorry :( " + decorationForMessage(":○", 27) + "\n" +
                decorationForMessage(":○", 21) +
                " Right now, we don't have an available cab" +
                decorationForMessage(":○", 20) + "\n" +
                decorationForMessage("≡", 124));
    }

    /**
     * This method is to display a message to try again.
     *
     * This method displays the message to ask if you want
     * to try ordering a car again,
     */
    public void tryAgain(){
        System.out.print(Colors.YELLOW_BOLD+ "\n" +
                decorationForMessage("≡")+
                decorationForMessage(":○",24)+
                " Would you like to try again: "+
                decorationForMessage(":○",23)+"\n"+
                decorationForMessage("≡"));
    }

    /**
     * This method shows if it is out of range.
     * This method displays the message when a correct
     * option is not entered.
     */
    public void numberOutOfRange() {
        System.out.print("\n" + Colors.RED +
                decorationForMessage("=•", 61) +
                "\n>> Please enter correct option <<\n" +
                decorationForMessage("=•", 61)+"\n>> ");
    }

    /**
     *This method is the option to give advice or criticism.
     *
     * This method returns an option that the user can
     * enter as advice or criticism, it also has an option
     * to exit.
     */
    public void tipsAndCritiques() {
        System.out.print(Colors.BLUE + "\n" +
                decorationForMessage("▓") +
                decorationForMessage("=") +
                decorationForMessage("•~•", 18) + " Tips & Critiques " +
                decorationForMessage("•~•", 17) + "\n" +
                decorationForMessage("=") +
                decorationForMessage("▓") +
                "1. Give the driver a tip.\n" +
                "2. Write your opinion about the travel.\n" +
                "3. Exit.\n" +
                decorationForMessage("=") + ">> ");
    }
}
