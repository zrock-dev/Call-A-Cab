package Controller;

import Controller.util.CheckInputUser;
import Model.DataBase;
import Model.TaxiTrip;
import View.*;
import java.util.Scanner;

public class DataCollection {
    private Scanner input;
    private CheckInputUser checkInputUser;

    // Model
    private TaxiTrip taxiTrip;
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
        taxiTrip = tripsManager.getTaxiTrip();
        optionInformation = new OptionInformation();
        greeting = new Greeting();
    }

    private void askCustomerLocation() {
        informationUser.enterLocation();
        taxiTrip.setCustomerLocation(input.next());
    }

    private void askArriveDestination() {
        informationUser.enterDestination();
        taxiTrip.setArriveDestination(input.next());
    }

    private void askNoPassengers() {
        informationUser.enterNumberPassengers();
        taxiTrip.setNoPassengers(input.nextInt());
    }

    public void askAllData(){
        askCustomerLocation();
        askArriveDestination();
        askNoPassengers();
    }

    public void showInformation() {
        informationUser.tripInformation(
                taxiTrip.getCustomerLocation(),
                taxiTrip.getArriveDestination(),
                taxiTrip.getNoPassengers(),
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
            tripsManager.attemptTrip();
        }
        else{
            changeUserInformation();
            receiveInformation();
        }
    }
}