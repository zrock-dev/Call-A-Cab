package Controller;

import Controller.util.CheckInputUser;
import Model.DataBase;
import Model.TaxiTrip;
import View.*;
import java.util.Scanner;

public class DataCollection {
    private InformationUser informationUser;
    private Scanner input;
    private final DataBase dataBase;
    private TaxiTrip taxiTrip;
    private OptionInformation optionInformation;
    private CheckInputUser checkInputUser;
    private Greeting greeting;

    public DataCollection() {
        informationUser = new InformationUser();
        input = new Scanner(System.in);
        dataBase = new DataBase();
        taxiTrip = dataBase.getTaxiTrip();
        optionInformation = new OptionInformation();
        checkInputUser=new CheckInputUser();
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
        taxiTrip.setPassengers(input.nextInt());
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
        String optionSelected=verifyInformation();
        if (optionSelected.equalsIgnoreCase("Y")) {
            System.out.println("Llamar método de Santiago y Emanuel");
        }
        else{
            changeUserInformation();
            receiveInformation();
        }
    }
}