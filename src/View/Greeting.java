package View;

import static View.Utils.Decoration.decorationForMessage;

public class Greeting {

    public void welcome() {
        System.out.println(
                decorationForMessage("▓") +
                decorationForMessage("=") +
                decorationForMessage("❉", 45) +
                " Welcome to our Call-A-Cab System\n " +
                decorationForMessage("❉", 45) +
                decorationForMessage("=") +
                decorationForMessage("▓")
        );
    }

    public void farewell() {
        System.out.println(
                decorationForMessage("▓") +
                decorationForMessage("✫") +
                decorationForMessage("▓") +
                decorationForMessage("=") +
                decorationForMessage("❉", 34) +
                " Thank you for choosing us, we hope you have a nice day " +
                decorationForMessage("❉", 34) +
                decorationForMessage("=") +
                decorationForMessage("▓") +
                decorationForMessage("✫") +
                decorationForMessage("▓")
        );
    }

}
