package Controller;

import View.Greeting;

public class GreetingsManager {
    private final Greeting greeting;

    public GreetingsManager() {
        greeting = new Greeting();
    }

    public void showWelcomeMessage(){
        greeting.showWelcome();
    }

    public void showFareWellMessage(){
        greeting.showFarewell();
    }
}
