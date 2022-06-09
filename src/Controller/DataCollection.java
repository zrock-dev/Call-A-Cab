package Controller;

import Controller.util.CheckInputUser;
import Model.TravelDetails;
import View.*;
import java.util.Scanner;

public class DataCollection {
    private Scanner input;
    private CheckInputUser checkInputUser;

    // Model
    private TravelDetails travelDetails;
    private TripsManager tripsManager;

    // View
    private InformationUser informationUser;
    private OptionInformation optionInformation;
    private Greeting greeting;

    public DataCollection() {
        tripsManager = new TripsManager();
        checkInputUser = new CheckInputUser();
        informationUser = new InformationUser();
        input = new Scanner(System.in);
        optionInformation = new OptionInformation();
        greeting = new Greeting();
        
        travelDetails = tripsManager.getTravelDetails();
    }

    private void askCustomerLocation() {
        informationUser.enterLocation();
        travelDetails.setCustomerLocation(input.next());
    }

    private void askArriveDestination() {
        informationUser.enterDestination();
        travelDetails.setArriveDestination(input.next());
    }

    private void askNoPassengers() {
        informationUser.enterNumberPassengers();
        travelDetails.setNoPassengers(input.nextInt());
    }

    public void askAllData(){
        askCustomerLocation();
        askArriveDestination();
        askNoPassengers();
    }

    public void showInformation() {
        informationUser.tripInformation(
                travelDetails.getCustomerLocation(),
                travelDetails.getArriveDestination(),
                travelDetails.getNoPassengers(),
                10);
    }

    public void start(){
        greeting.welcome();
        askAllData();
        receiveInformation();
    }

    private int selectInformationToChange(){
        optionInformation.informationChange();
        return input.nextInt();
    }

    private void changeUserInformation(){
        switch(selectInformationToChange()){
            case 1:
                askCustomerLocation();
                break;
            case 2:
                askArriveDestination();
                break;
            case 3:
                askNoPassengers();
                break;
            default:
                optionInformation.showIncorrectSelect();
                changeUserInformation();
        }
    }

    private String verifyInformation(){
        showInformation();
        return checkInputUser.receiveYOrN();
    }

    private void receiveInformation(){
        String optionSelected = verifyInformation();
        if (optionSelected.equalsIgnoreCase("Y")) {
            tripsManager.requestTrip();
        }
        else{
            changeUserInformation();
            receiveInformation();
        }
    }
}