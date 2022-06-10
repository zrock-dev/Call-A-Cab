package Controller;

import View.*;

import java.util.Random;
import java.util.Scanner;

import static Controller.ModelClassConnections.*;

public class TravelDetailsManager {
    private Scanner input;
    private CheckInputUser checkInputUser;

    // View
    private InformationUser informationUser;
    private OptionInformation optionInformation;
    private InformationTrip informationTrip;

    public TravelDetailsManager() {
        ModelClassConnections.initClasses();

        checkInputUser = new CheckInputUser();
        informationUser = new InformationUser();
        input = new Scanner(System.in);
        optionInformation = new OptionInformation();
        informationTrip = new InformationTrip();
    }

    public void inputTravelDetails(){
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
        travelDetails.setNoPassengers(input.nextInt());
    }

    public double generateDistance() {
        Random random = new Random();
        return random.nextInt(51)+1;
    }

    public double totalBuy() {
        return generateDistance() * travelDetails.getNoPassengers();
    }

    private String askUserConfirmation(){
        showUserTravelDetails();
        return checkInputUser.askUserDecision();
    }

    private void showUserTravelDetails() {
        informationUser.showTripDetails(
                travelDetails.getCustomerLocation(),
                travelDetails.getArriveDestination(),
                travelDetails.getNoPassengers(),
                totalBuy());
    }

    private int inputUserChoice(){
        optionInformation.informationToChange();
        int userChoice = input.nextInt();
        return checkInputUser.validateChoiceInRange(userChoice,1,3);
    }

    private void processUserChoice() {
        optionInformation.newInformation();
        switch (inputUserChoice()) {
            case 1 -> inputCustomerLocation();
            case 2 -> inputArriveDestination();
            case 3 -> inputNoPassengers();
        }
    }

    public void run(TripsManager tripsManager){
        inputTravelDetails();
        while (askUserConfirmation().equalsIgnoreCase("N")){
            processUserChoice();
        }
        tripsManager.run();
    }

    //Review

    private String askIfWantsAnotherCab(){
//        informationTrip.earlyArrivalNotification(driver.getFirstName(), car);
        return checkInputUser.askUserDecision();
    }

    public void validateAskAnotherCab(){
        if(askIfWantsAnotherCab().equalsIgnoreCase("Y")){
            //start
        }
        else{
            DuringTravel.showSimulationTravel();

        }
    }


}