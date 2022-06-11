package Controller;

import View.*;

import java.util.*;

import static Controller.ModelClassConnections.*;

public class TravelDetailsManager {
    private Scanner input;
    private InputUser inputUser;

    // View
    private InformationUser informationUser;
    private OptionInformation optionInformation;

    public TravelDetailsManager() {
        ModelClassConnections.initClasses();

        inputUser = new InputUser();
        informationUser = new InformationUser();
        input = new Scanner(System.in);
        optionInformation = new OptionInformation();
    }

    private void inputTravelDetails(){
        informationUser.messageToEnterUserData();
        inputCustomerLocation();
        inputArriveDestination();
        inputNoPassengers();
    }

    private void inputCustomerLocation() {
        informationUser.enterLocation();
        travelDetails.setCustomerLocation(input.next());
    }

    private void inputArriveDestination() {
        informationUser.enterDestination();
        travelDetails.setArriveDestination(input.next());
    }

    private void inputNoPassengers() {
        informationUser.enterNumberPassengers();
        try {
            int amountPassengers = inputUser.userInputInteger(input.next());
            travelDetails.setNoPassengers(amountPassengers);

        }catch (InputMismatchException exception){
            System.out.println("no correct number");
        }
    }

    private double generateDistance() {
        Random random = new Random();
        return random.nextInt(51)+1;
    }

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

    private String askUserConfirmation(){
        showUserTravelDetails();
        return inputUser.askUserDecision();
    }

    private void showUserTravelDetails() {
        travelDetails.setTotalPrice(totalPrice());
        informationUser.showTripDetails(
                travelDetails.getCustomerLocation(),
                travelDetails.getArriveDestination(),
                travelDetails.getNoPassengers(),
                travelDetails.getTotalPrice());
    }

    private int inputUserChoice(){
        optionInformation.informationToChange();
        int userChoice = inputUser.userInputInteger(input.next());
        return inputUser.validateChoiceInRange(userChoice,1,3);
    }

    private void processUserChoice() {
        optionInformation.askForNewInformation();
        switch (inputUserChoice()) {
            case 1 -> inputCustomerLocation();
            case 2 -> inputArriveDestination();
            case 3 -> inputNoPassengers();
        }
    }

    public void run(){
        inputTravelDetails();
        while (askUserConfirmation().equalsIgnoreCase("N")){
            processUserChoice();
        }
        travelDetails.uploadTravelDetails();
    }

}