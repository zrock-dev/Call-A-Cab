package Controller;

import Model.DataBase;
import Model.TaxiTrip;
import View.InformationUser;
import View.OptionInformation;

import java.util.Random;
import java.util.Scanner;

public class DataCollection {
    private InformationUser message;
    private Scanner input;
    private final DataBase dataBase;
    private TaxiTrip taxiTrip;
    private double distanceRandom;

    public DataCollection() {
        message = new InformationUser();
        input = new Scanner(System.in);
        dataBase = new DataBase();
        taxiTrip = new TaxiTrip();
    }

    private void askCustomerLocation() {
        message.enterLocation();
        String userAnswer = input.next();
        taxiTrip.setCustomerLocation(userAnswer);
    }

    private void askArriveDestination() {
        message.enterDestination();
        taxiTrip.setArriveDestination(input.next());
    }

    private void askNoPassengers() {
        message.enterNumberPassengers();

        taxiTrip.setNoPassengers(input.nextInt());
    }

    public void askAllData(){
        askCustomerLocation();
        askArriveDestination();
        askNoPassengers();
    }

    public void showInformation() {
        message.tripInformation(
                taxiTrip.getCustomerLocation(),
                taxiTrip.getArriveDestination(),
                taxiTrip.getNoPassengers(),
                10);
    }

    public double GenerateDistance() {
        Random random = new Random();
        distanceRandom = random.nextInt(100)+1;
        return distanceRandom;
    }

    public double totalBuy() {
        double total = distanceRandom * taxiTrip.getNoPassengers() * 10;
        return total;
    }



    public void start(){
        askAllData();
        showInformation();
    }

//borrar

    private OptionInformation messages=new OptionInformation();
    private int selectInformationToChange(){
        messages.informationChange();
        return input.nextInt();
    }

    //fixear
    public void changeUserInformation(){
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
                messages.showIncorrectSelect();
                changeUserInformation();
        }
        showInformation();
    }
}
