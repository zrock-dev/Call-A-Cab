package View;

import View.Utils.*;
import static View.Utils.Decoration.decorationForMessage;

/**
 * This class shows the information that the user will put.
 */
public class InformationUser {

    /**
     * This method shows if the data is correct.
     *
     *It shows the information that the user enters to
     * verify if it is correct or not.
     * @param location shows the locality that the user puts.
     * @param arriveDestination shows the destination that the user puts.
     * @param passengers shows the number of passengers making the trip.
     * @param cost shows the cost of the trip.
     */
    public void showTripDetails(String location, String arriveDestination, int passengers, double cost){
        System.out.print(Colors.GREEN +
                "\n" +
                decorationForMessage("▓")+
                decorationForMessage(" ", 49)+
                "Are these details correct?" + "\n"+
                decorationForMessage("=") +
                "| Location:\t\t\t    " + location
                + "\n| Destination: \t\t\t" + arriveDestination
                + "\n| Number of Passengers: " + passengers + "\n"+
                decorationForMessage("=")+
                "| Total cost($): \t\t" + cost+"\n"+
                decorationForMessage("▓"));
    }

    /**
     * This method shows the message to introduce the trip's information.
     *
     * This is the header of the information that the user must enter
     */
    public void messageToEnterUserData(){
        System.out.println( "\n" +
                decorationForMessage(">•",62)+"\n"+
                decorationForMessage(" ",35)+
                " To call a cab, please enter the following information \n"+
                decorationForMessage("<•",62));
    }

    /**
     * This method shows the message to introduce Location.
     */
    public void enterLocation(){
        System.out.print(Colors.PURPLE + ">> Location: ");
    }

    /**
     * This method shows the message to introduce Destination.
     */
    public void enterDestination(){
        System.out.print(Colors.PURPLE+ ">> Destination: ");
    }

    /**
     * This method displays the message for the number of passengers.
     */
    public void enterNumberPassengers(){
        System.out.print(Colors.PURPLE+">> Number of passengers: ");
    }

    /**
     *This method shows the message Y or N.
     */
    public void askUserDecision(){
        System.out.print("Y/N: ");
    }

    /**
     * This method displays a message to "give a tip".
     */
    public void showReceiveTip() {
        System.out.print(Colors.RESET+ "\n"+
                decorationForMessage("▓")+
                decorationForMessage("=")+
                decorationForMessage("○•",24)+
                " How much do you want to tip? " +
                decorationForMessage("○•",23)+"\n"+
                decorationForMessage("=")+
                decorationForMessage("▓")+
                ">> ");
    }

    /**
     * This method makes one receive a critic.
     *
     * what it shows is a message so that the user
     * can give his opinion about the trip
     */
    public void showReceiveCritique() {
        System.out.print(Colors.RESET+ "\n"+
                decorationForMessage("▓")+
                decorationForMessage("=")+
                decorationForMessage("○•",22)+
                " What do you think about the Travel? " +
                decorationForMessage("○•",22)+"\n"+
                decorationForMessage("=")+
                decorationForMessage("▓")+
                ">> "
        );
    }

    /**
     * This method shows how much the customer tips.
     *
     * @param tip shows the number that the user tips.
     */
    public void showTip(int tip){
        System.out.println(Colors.RESET + "The tip he gave is: " + tip);
    }

    /**
     * This method shows the reviews that the customer wrote.
     *
     * @param critique receives what the user wrote as criticism.
     */
    public void showCritique(String critique){
        System.out.println(Colors.RESET + "His criticism is: " + critique);
    }
}