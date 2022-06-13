package View;

import View.Utils.*;
import static View.Utils.Decoration.decorationForMessage;

/**
 * This is the menu payment class.
 * This class has a method that shows us the available payment options.
 *
 */
public class MenuPayment {


    /**
     * This method shows the menu of payment method.
     * Our payment method are: Cash and Card,
     * these have decorations for a more aesthetic visualization.
     */
    public void showMenu(){
        System.out.print(Colors.PURPLE + "\n"+
                decorationForMessage("░")+
                decorationForMessage("»",50) +
                "| Choose payment method |" +
                decorationForMessage("«",49) +"\n"+
                decorationForMessage("░")+
                decorationForMessage(" ",30)+
                "|option 1:|"+decorationForMessage(" ",43)+"|option 2:|\n" +
                decorationForMessage(" ",32)+
                "|Cash|"+decorationForMessage(" ",48)+"|Card|"+"\n" +
                decorationForMessage("░")+
                decorationForMessage("=",124)+
                "\n>> "
        );
    }
}
