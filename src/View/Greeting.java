package View;

import View.Utils.*;

import static View.Utils.Decoration.decorationForMessage;

/**
 * This class shows the start and trip's information.
 * This class shows the welcome with its borders and show the trip's information with its borders too.
 */
public class Greeting {

    /**
     *This method shows the welcome message with its border.
     */
    public void showWelcome(){
        System.out.println(Colors.CYAN+ "\n" +
                decorationForMessage("▓")+
                decorationForMessage("♦")+
                decorationForMessage("❉",45)+
                " Welcome to our Call-A-Cab System " +
                decorationForMessage("❉",45)+"\n"
                + decorationForMessage("♦")+
                decorationForMessage("▓")
        );
    }

    /**
     * This method shows the ending of the program.
     */
    public void showFarewell(){
        System.out.println("\n" + Colors.CYAN +
                decorationForMessage("▓")+
                decorationForMessage("♦")+
                decorationForMessage("❉",40)+
                " Thanks for using the Call-a-Cab System ^_^ " +
                decorationForMessage("❉",40)+ "\n" +
                decorationForMessage("♦")+
                decorationForMessage("▓", 124)
        );
    }
}
