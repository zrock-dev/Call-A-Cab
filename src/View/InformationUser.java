package View;
import static View.Utils.Decoration.decorationForMessage;

public class InformationUser {
    
    public void tripInformation(String location, String arriveDestination, int passengers, int cost){
        System.out.print(
                "\n\n" + decorationForMessage("▓")+
                "\t\t\t TRIP  INFORMATION \n"+
                decorationForMessage("=") +
                "| Location:\t\t\t "+ location +
                "\n| Arrive destination:  " + arriveDestination +
                "\n| No. Passengers:      " + passengers + "\n"+
                decorationForMessage("=") +
                "| Total cost($):       " + cost + "\n"+
                decorationForMessage("▓") +
                "Is that information correct: [Y/N] "
        );
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
        System.out.print(decorationForMessage("▓") +
                decorationForMessage("=")  +
                decorationForMessage("•~•",18) +
                " Tips & Critiques " +
                decorationForMessage("•~•",17) +
                decorationForMessage("=")  +
                decorationForMessage("▓")  +
                "1. Give the driver a tip.\n" +
                "2. Write your opinion about the travel.\n"+
                decorationForMessage("=") +
                ">> "
        );
    }

    public void aboutTheTrip() {
        System.out.print(decorationForMessage("=", 54) +
                "\nWhat do you think about the Travel\n" +
                ">> "
        );
    }
}