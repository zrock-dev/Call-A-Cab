import Controller.Controller;
import View.Greeting;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Greeting greeting = new Greeting();
        greeting.welcome();
        controller.start();
    }
}
