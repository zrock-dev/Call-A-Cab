package View;

import View.Utils.Decoration;

public class InformationMethodPayment {

    Decoration decoration = new Decoration();

    public void paymentMethod(){
        System.out.print("\n"+
                Decoration.decorationForMessage("░",124)+"\n"+
                Decoration.decorationForMessage("☼",124)+"\n"+
                Decoration.decorationForMessage("░",124)+"\n"+
                Decoration.decorationForMessage("»",50) +
                "| Choose payment method |"+ Decoration.decorationForMessage("«",49) +"\n"+
                Decoration.decorationForMessage("░",124)+"\n"+
                Decoration.decorationForMessage(" ",30)+
                "|option 1:|"+ Decoration.decorationForMessage(" ",43)+"|option 2:|\n" +
                Decoration.decorationForMessage(" ",32)+
                "|Cash|"+ Decoration.decorationForMessage(" ",48)+"|Card|"+"\n" +
                Decoration.decorationForMessage("░",124)+"\n" +
                Decoration.decorationForMessage("=",124)+
                "\n>>");
    }

    public void tipping(){
        System.out.println(Decoration.decorationForMessage("=",124)+"\n"+
                Decoration.decorationForMessage(" ",48)+
                "How much do you want to tip?" +"\n"+
                Decoration.decorationForMessage("=",124)+"\n"+
                ">> ");
    }
}
