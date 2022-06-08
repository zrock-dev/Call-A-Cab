package View;

import View.Utils.Decoration;

public class InformationUser {

    Decoration decoration=new Decoration();

    public void tripInformation(String location, String arriveDestination, int passengers, int cost){
        System.out.print("\n\n"+decoration.decorationForMessage("▓",124)+"\n"+
                "Is that information correct?" + "\n"+
                decoration.decorationForMessage("=",124) +
                "\n| Location:\t\t\t   "+location
                + "\n| Arrive destination:  " + arriveDestination
                + "\n| Number of Passengers:      " + passengers + "\n"+
                decoration.decorationForMessage("=",124) + "\n" +
                "| Total cost($):       " +cost+"\n"+
                decoration.decorationForMessage("▓",124)
                +"\nY/N: ");
    }
    public void messageToEnterUserData(){
        System.out.println(decoration.decorationForMessage(">•",62)+"\n"+
                decoration.decorationForMessage(" ",35)+
                " To call a cab, please enter the following information \n"+
                decoration.decorationForMessage("<•",62));
    }

    public void enterLocation(){
        System.out.print(">> Location: ");
    }

    public void enterDestination(){
        System.out.print(">> Destination: ");
    }

    public void enterNumberPassengers(){
        System.out.print(">> Number of passengers: ");
    }

    public void tipsAndCritiques(){
        System.out.print(decoration.decorationForMessage("▓",124)+"\n"+
                decoration.decorationForMessage("=",124)+ "\n"+
                decoration.decorationForMessage("•~•",18)+ " Tips & Critiques "+
                decoration.decorationForMessage("•~•",17)+"\n"+
                decoration.decorationForMessage("=",124)+"\n"+
                decoration.decorationForMessage("▓",124)+"\n"+
                "1. Give the driver a tip.\n" +
                "2. Write your opinion about the travel.\n"+
                decoration.decorationForMessage("=",124)+"\n>>");
    }

    public void aboutTheTrip() {
        System.out.print(decoration.decorationForMessage("▓",124)+"\n"+
                decoration.decorationForMessage("=",124)+"\n"+
                decoration.decorationForMessage("○•",22)+
                " What do you think about the Travel " +
                decoration.decorationForMessage("○•",22)+"\n"+
                decoration.decorationForMessage("=",124)+"\n"+
                decoration.decorationForMessage("▓",124)+"\n"+
                ">> ");
    }
}