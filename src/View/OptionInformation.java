package View;

import View.Utils.Colors;
import View.Utils.Decoration;

public class OptionInformation {

    Decoration decoration=new Decoration();

    public void informationCorrect(){
        System.out.print(Colors.YELLOW_BOLD+ decoration.decorationForMessage("▓")+
                decoration.decorationForMessage("=")+
                decoration.decorationForMessage(" ",40)+
                "Is that information correct? Y/N\n"+
                decoration.decorationForMessage("=")+
                decoration.decorationForMessage("▓")+
                ">> ");
    }

    public void informationChange(){
        System.out.print(Colors.RESET+ "\n╔"+
                decoration.decorationForMessage("═",122)+"╗"+
                "\n"+"║ "+ decoration.decorationForMessage(">", 38)+
                " Which information would you like to change? " +
                decoration.decorationForMessage("<", 37)+" ║\n"+
                "╚"+ decoration.decorationForMessage("═",122)+"╝"+
                "\n>> 1. Location\n" +
                ">> 2. Arrive Place\n" +
                ">> 3. Number of Passengers\n>>");
    }

    public void newInformation(){
        System.out.print(Colors.RESET+ "\n"+decoration.decorationForMessage("♦•",62)+
                "\n│"+decoration.decorationForMessage(" ",42)+
                " Please, reinsert your new information "+
                decoration.decorationForMessage(" ",41)+"│\n"+
                decoration.decorationForMessage("♦•",62)+"\n>>");

    }

    public void cadUnavailable(){
        System.out.println(Colors.RED+ "\n"+decoration.decorationForMessage("≡")+
                decoration.decorationForMessage(":○",27)+
                " We're sorry :( " +decoration.decorationForMessage(":○",27)+"\n"+
                decoration.decorationForMessage(":○",21)+
                " Right now, we don't have an available cab"+
                decoration.decorationForMessage(":○",20)+"\n"+
                decoration.decorationForMessage("≡",124));
    }
    public void tryAgain(){
        System.out.print(Colors.YELLOW_BOLD+ "\n"+decoration.decorationForMessage("≡")
                +decoration.decorationForMessage(":○",23)+
                " Would you like to try again: Y/N "+
                decoration.decorationForMessage(":○",22)+"\n"+
                decoration.decorationForMessage("≡")+
                ">>");
    }
    public void showCorrectOption(){
        System.out.print("\n"+Colors.RED+decoration.decorationForMessage("=•",61) +
                "\n>> Please enter a Y or N <<\n"+
                decoration.decorationForMessage("=•",61));
    }

    public void showIncorrectSelect(){
        System.out.print("\n"+Colors.RED+decoration.decorationForMessage("=•",61) +
                "\n>> Please enter correct option <<\n"+
                decoration.decorationForMessage("=•",61));
    }
}
