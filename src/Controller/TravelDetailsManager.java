package Controller;

import View.*;
import java.util.*;
import static Controller.ModelClassConnections.*;

/**
 * This class manages the information about the travel the user provides.
 *
 * @see InputUser
 */

public class TravelDetailsManager {
    private final Scanner input;
    private final InputUser inputUser;

    // View
    private final InformationUser informationUser;
    private final OptionInformation optionInformation;

    /**
     * This constructor instantiates InputUser, InformationUser,
     * OptionInformation, and a Scanner as input.
     */
    public TravelDetailsManager() {
        ModelClassConnections.initClasses();

        inputUser = new InputUser();
        informationUser = new InformationUser();
        input = new Scanner(System.in);
        optionInformation = new OptionInformation();
    }

    /**
     * This method receives all the trip details information.
     * Executes messageToEnterUserData from InformationUser,
     * executes inputCustomerLocation, inputArriveDestination and inputNoPassengers.
     *
     * @see InformationUser
     */
    private void inputTravelDetails(){
        informationUser.messageToEnterUserData();
        inputCustomerLocation();
        inputArriveDestination();
        inputNoPassengers();
    }

    /**
     * This method asks for the location of the user.
     * and sets the information requested on customerLocation field in travelDetails.
     *
     * @see InformationUser
     * @see Model.TravelDetails
     */
    private void inputCustomerLocation() {
        informationUser.enterLocation();
        travelDetails.setCustomerLocation(input.next());
    }

    /**
     * This method asks for the user arrive destination, and obtains
     * the answer as String input.
     */
    private void inputArriveDestination() {
        informationUser.enterDestination();
        travelDetails.setArriveDestination(input.next());
    }

    /**
     * This method asks for the N° of passengers in the trip and obtains
     * the answer as Integer input.
     */
    private void inputNoPassengers() {
        informationUser.enterNumberPassengers();
        try {
            int amountPassengers = inputUser.userInputInteger(input.next());
            travelDetails.setNoPassengers(amountPassengers);

        }catch (InputMismatchException exception){
            exception.printStackTrace();
        }
    }

    /**
     * This method generates a random value for distance bounded on 51.
     *
     * @return Returns the random distance increased in 1.
     */
    private double generateDistance() {
        Random random = new Random();
        return random.nextInt(51)+1;
    }

    /**
     * This method calculates the total price.
     * Multiply the random distance with N° passengers and save the result on price,
     * if price is less than 10, price will be multiplied with 3, or if price is
     * greater than 100, price will be divided with 2.
     *
     * @return The result, price.
     */
    private double totalPrice() {
        double price = generateDistance() * travelDetails.getNoPassengers();
        if(price < 10) {
            price*=3;
        }
        else if(price > 100){
            price/=2;
        }
        return price;
    }

    /**
     * This method shows what the user inputted asking for a confirmation and obtains
     * the answer as String input.
     */
    private String askUserConfirmation(){
        showUserTravelDetails();
        return inputUser.getUserDecision();
    }

    /**
     * This method shows user's trip details.
     * This method sets TotalPrice from TravelDetails with the parameter (totalPrice),
     * and calls showTripDetails, to show what the user inputted.
     *
     * @see Model.TravelDetails
     * @see InformationUser
     */
    private void showUserTravelDetails() {
        travelDetails.setTotalPrice(totalPrice());
        informationUser.showTripDetails(
                travelDetails.getCustomerLocation(),
                travelDetails.getArriveDestination(),
                travelDetails.getNoPassengers(),
                travelDetails.getTotalPrice());
    }

    /**
     * This method obtains the user's information to change.
     * Shows the informationToChange menu from OptionInformation,
     * converts the choice in an int with userInputInteger from InputUser
     * and saves that information on userChoice
     *
     * @return Returns userChoice verified with validateChoiceInRange from InputUser.
     *
     * @see  OptionInformation
     * @see InputUser
     */
    private int inputUserChoice(){
        optionInformation.informationToChange();
        int userChoice = inputUser.userInputInteger(input.next());
        return inputUser.validateChoiceInRange(userChoice,1,3);
    }

    /**
     * This method process the user choice.
     * Calls askForNewInformation from OptionInformation and
     * executes the editor methods depending on user's choice.
     *
     * @see OptionInformation
     */
    private void processUserChoice() {
        optionInformation.askForNewInformation();
        switch (inputUserChoice()) {
            case 1: inputCustomerLocation(); break;
            case 2: inputArriveDestination(); break;
            case 3: inputNoPassengers(); break;
        }
    }

    /**
     * This method runs inputTravelDetails.
     * while askUserConfirmation return be equals to N,
     * runs processUserChoice, then executes uploadTravelDetails from TravelDetails.
     *
     * @see Model.TravelDetails
     */
    public void run(){
        inputTravelDetails();
        while (askUserConfirmation().equalsIgnoreCase("N")){
            processUserChoice();
        }
        travelDetails.uploadTravelDetails();
    }
}
