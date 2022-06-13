package View;

import View.Utils.*;

import static View.Utils.Decoration.decorationForMessage;

/**
 * This is the greeting class.
 * This class contains methods that display the startup message on program start
 * and also display the completion message on program completion.
 *
 * @author AfricanRiot
 */
public class Greeting {

    /**
     * This method displays the welcome message,
     * it has decorations for a more aesthetic visualization.
     *
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
     * This method displays the message that ends the program,
     * it has decorations for a more aesthetic visualization.
     *
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