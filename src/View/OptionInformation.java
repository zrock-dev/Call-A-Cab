package View;

import View.Utils.Decoration;

import java.util.Scanner;

public class OptionInformation {

    Decoration decoration=new Decoration();
    Scanner input = new Scanner(System.in);

    public void informationCorrect(){
        System.out.print(decoration.decorationForMessage("▓",124)+"\n"+
                decoration.decorationForMessage("=",124)+
                "\n"+ decoration.decorationForMessage(" ",40)+
                "Is that information correct? Y/N\n"+
                decoration.decorationForMessage("=",124)+"\n"+
                decoration.decorationForMessage("▓",124)+
                "\n>> ");
    }

    public void informationChange(){
        System.out.print("\n╔"+decoration.decorationForMessage("═",122)+"╗"+
                "\n"+"║ "+ decoration.decorationForMessage(">", 38)+
                " Which information would you like to change? " +
                decoration.decorationForMessage("<", 37)+" ║\n"+
                "╚"+ decoration.decorationForMessage("═",122)+"╝"+
                "\n>> 1. Location\n" +
                ">> 2. Arrive Place\n" +
                ">> 3. Number of Passengers\n>>");
    }

    public void newInformation(){
        System.out.print("\n"+decoration.decorationForMessage("≡",124)+"\n"+"╞ "+
                decoration.decorationForMessage("‡",41)+
                " Please, reinsert your new information " +
                decoration.decorationForMessage("‡",40)+
                " ╡"+ "\n"+decoration.decorationForMessage("≡",124)+"\n"+
                ">> " );
    }

    public void selectACab(){
        System.out.print(decoration.decorationForMessage("♦•",62)+
                "\n│"+decoration.decorationForMessage(" ",45)+
                " Do you want to select a cab? Y/N"+
                decoration.decorationForMessage(" ",45)+"│\n"+
                decoration.decorationForMessage("♦•",62)+"\n>>");
    }

    public void cadUnavailable(){
        System.out.println("\n"+decoration.decorationForMessage("≡",124)+
                "\n"+decoration.decorationForMessage(":○",27)+
                " We're sorry :( " +decoration.decorationForMessage(":○",27)+"\n"+
                decoration.decorationForMessage(":○",21)+
                " Right now, we don't have an available cab"+
                decoration.decorationForMessage(":○",20)+"\n"+
                decoration.decorationForMessage("≡",124));
    }
    public void tryAgain(){
        System.out.print("\n"+decoration.decorationForMessage("≡",124)+
                "\n"+decoration.decorationForMessage(":○",23)+
                " Would you like to try again: Y/N "+
                decoration.decorationForMessage(":○",22)+"\n"+
                decoration.decorationForMessage("≡",124)+
                "\n>>");
    }
    public void showCorrectOption(){
        System.out.print(decoration.decorationForMessage("=•",61) +
                "\n>> Please enter a Y or N <<\n"+
                decoration.decorationForMessage("=•",61));
    }

    public void showIncorrectSelect(){
        System.out.print(decoration.decorationForMessage("=•",61) +
                "\n>> Please enter correct option <<\n"+
                decoration.decorationForMessage("=•",61));

    }
}
