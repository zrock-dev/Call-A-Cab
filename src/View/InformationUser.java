package View;

import View.Utils.Colors;
import View.Utils.Decoration;

import java.util.Scanner;

public class InformationUser {

    Scanner input= new Scanner(System.in);
    Decoration decoration=new Decoration();

    public void showTripDetails(String location, String arriveDestination, int passengers, double cost){
        System.out.print(Colors.GREEN+decoration.decorationForMessage("▓")+
                "Are these details correct?" + "\n"+
                decoration.decorationForMessage("=") +
                "| Location:\t\t\t   " + location
                + "\n| Destination:  " + arriveDestination
                + "\n| Number of Passengers:      " + passengers + "\n"+
                decoration.decorationForMessage("=")+
                "| Total cost($):       " + cost+"\n"+
                decoration.decorationForMessage("▓"));
    }
    public void messageToEnterUserData(){
        System.out.println(decoration.decorationForMessage(">•",62)+"\n"+
                decoration.decorationForMessage(" ",35)+
                " To call a cab, please enter the following information \n"+
                decoration.decorationForMessage("<•",62));
    }

    public void enterLocation(){
        System.out.print(Colors.PURPLE + ">> Location: ");
    }

    public void enterDestination(){
        System.out.print(Colors.PURPLE+ ">> Destination: ");
    }

    public void enterNumberPassengers(){
        System.out.print(Colors.PURPLE+">> Number of passengers: ");
    }

    public void yesOrNo(){
        System.out.print("Y/N: ");
    }




    public void aboutTheTrip() {
        System.out.print(Colors.RESET+ "\n"+decoration.decorationForMessage("▓")+
                decoration.decorationForMessage("=")+
                decoration.decorationForMessage("○•",22)+
                    " What do you think about the Travel " +
                decoration.decorationForMessage("○•",22)+"\n"+
                decoration.decorationForMessage("=")+
                decoration.decorationForMessage("▓")+
                ">> ");
    }
}