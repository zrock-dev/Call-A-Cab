package View;

import View.Utils.Decoration;

public class OptionInformation {

    Decoration decoration=new Decoration();

    public void informationCorrect(){
        System.out.print(Decoration.decorationForMessage("▓",124)+"\n"+
                Decoration.decorationForMessage("=",124)+
                "\n"+ Decoration.decorationForMessage(" ",40)+
                "Is that information correct? Y/N\n"+
                Decoration.decorationForMessage("=",124)+"\n"+
                Decoration.decorationForMessage("▓",124)+
                "\n>> ");
    }

    public void informationChange(){
        System.out.print("\n"+ Decoration.decorationForMessage("-",54)+
                "\nWhich information would you like to change?\n" +
                "1. Location\n" +
                "2. Arrive Place\n" +
                "3. No. Passengers\n>>");
    }

    public void newInformation(){
        System.out.print("\n"+ Decoration.decorationForMessage("-",54)+
                "\nPlease, reinsert your new information\n" +
                ">> " );
    }

    public void selectACab(){
        System.out.print("\n"+ Decoration.decorationForMessage("-",54)+
                "\nDo you want to select a cab? Y/N\n>>");
    }

    public void cadUnavailable(){
        System.out.println("\n"+ Decoration.decorationForMessage("-",54)+
                "\nWe're sorry :(\n" +
                "Right now, we don't have an available cab.");
    }
    public void tryAgain(){
        System.out.print(Decoration.decorationForMessage("-",54)+
                "\nWould you like to try again: Y/N\n>>");
    }
    public void showCorrectOption(){
        System.out.println("Please enter a Y or N");
    }

    public void showIncorrectSelect(){
        System.out.println("Please enter correct option");
    }
}
