package View;

import View.Utils.Colors;
import View.Utils.Decoration;

public class InformationMethodPayment {

    Decoration decoration=new Decoration();

    public void paymentMethod(){
        System.out.print(Colors.PURPLE + "\n"+ decoration.decorationForMessage("░")+
                decoration.decorationForMessage("»",50) +
                "| Choose payment method |"+decoration.decorationForMessage("«",49) +"\n"+
                decoration.decorationForMessage("░")+
                decoration.decorationForMessage(" ",30)+
                "|option 1:|"+decoration.decorationForMessage(" ",43)+"|option 2:|\n" +
                decoration.decorationForMessage(" ",32)+
                "|Cash|"+decoration.decorationForMessage(" ",48)+"|Card|"+"\n" +
                decoration.decorationForMessage("░")+
                decoration.decorationForMessage("=",124)+
                "\n>>");
    }

    public void tipping(){
        System.out.println(Colors.YELLOW_BOLD+ "\n"+decoration.decorationForMessage("=")+
                decoration.decorationForMessage(" ",48)+
                "How much do you want to tip?" +"\n"+
                decoration.decorationForMessage("=")+
                ">> ");
    }



}
