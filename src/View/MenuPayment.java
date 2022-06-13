package View;

import View.Utils.*;
import static View.Utils.Decoration.decorationForMessage;

/**
 *This class shows the menu of payment method.
 */
public class MenuPayment {


    /**
     * This method shows the menu of payment method, and its options.
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
