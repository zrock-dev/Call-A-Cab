package View;

import View.Utils.*;
import static View.Utils.Decoration.decorationForMessage;

/**
 * This class shows trip details and message to introduce.
 */
public class InformationUser {

    Decoration decoration=new Decoration();

    /**
     * This method shows customer's trip details.
     * @param location first customer location.
     * @param arriveDestination final customer location.
     * @param passengers N° passenger.
     * @param cost trip's cost.
     */
    public void showTripDetails(String location, String arriveDestination, int passengers, double cost){
        System.out.print(Colors.GREEN +
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
     * This method shows the menu to introduce the trip's information.
     */
    public void messageToEnterUserData(){
        System.out.println(decorationForMessage(">•",62)+"\n"+
                decorationForMessage(" ",35)+
                " To call a cab, please enter the following information \n"+
                decorationForMessage("<•",62));
    }

    /**
     * This method shows the message to introduce Location
     */
    public void enterLocation(){
        System.out.print(Colors.PURPLE + ">> Location: ");
    }

    /**
     * This method shows the message to introduce Destination
     */
    public void enterDestination(){
        System.out.print(Colors.PURPLE+ ">> Destination: ");
    }

    /**
     * This method shows the message to introduce N° passenger
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
     * This method shows the menu "of give a tip".
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
     * This method shows the menu "What do you think about the Travel".
     */
    public void showReceiveCritique() {
        System.out.print(Colors.RESET+ "\n"+
                decorationForMessage("▓")+
                decorationForMessage("=")+
                decorationForMessage("○•",22)+
                " What do you think about the Travel " +
                decorationForMessage("○•",22)+"\n"+
                decorationForMessage("=")+
                decorationForMessage("▓")+
                ">> "
        );
    }

    /**
     * This method shows how much the customer gave.
     * @param tip customer's tip.
     */
    public void showTip(int tip){
        System.out.println(Colors.RESET + "The tip he gave is: " + tip);
    }

    /**
     * This method shows the reviews that the customer wrote.
     * @param critique customer's review.
     */
    public void showCritique(String critique){
        System.out.println(Colors.RESET + "His criticism is: " + critique);
    }
}