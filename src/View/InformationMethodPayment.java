package View;

import View.Utils.Decoration;

public class InformationMethodPayment {

    Decoration decoration=new Decoration();

    public void paymentMethod(){
        System.out.print("\n"+
                decoration.decorationForMessage("░",124)+"\n"+
                decoration.decorationForMessage("☼",124)+"\n"+
                decoration.decorationForMessage("░",124)+"\n"+
                decoration.decorationForMessage("»",50) +
                "| Choose payment method |"+decoration.decorationForMessage("«",49) +"\n"+
                decoration.decorationForMessage("░",124)+"\n"+
                decoration.decorationForMessage(" ",30)+
                "|option 1:|"+decoration.decorationForMessage(" ",43)+"|option 2:|\n" +
                decoration.decorationForMessage(" ",32)+
                "|Cash|"+decoration.decorationForMessage(" ",48)+"|Card|"+"\n" +
                decoration.decorationForMessage("░",124)+"\n" +
                decoration.decorationForMessage("=",124)+
                "\n>>");
    }

    public void tipping(){
        System.out.println(decoration.decorationForMessage("=",124)+"\n"+
                decoration.decorationForMessage(" ",48)+
                "How much do you want to tip?" +"\n"+
                decoration.decorationForMessage("=",124)+"\n"+
                ">> ");
    }
}
