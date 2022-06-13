package Controller;

import View.Greeting;

/**
 * This class shows the Welcome message and Farewell message from Greeting.
 *
 * @see View.Greeting for more information.
 */
public class GreetingsManager {
    private final Greeting greeting;

    /**
     * This constructor instantiates Greeting class.
     */
    public GreetingsManager() {
        greeting = new Greeting();
    }

    /**
     * This method shows the Welcome message from Greeting.
     */
    public void showWelcomeMessage(){
        greeting.showWelcome();
    }

    /**
     * This method shows the Program ending message from Greeting.
     */
    public void showFareWellMessage(){
        greeting.showFarewell();
    }
}
