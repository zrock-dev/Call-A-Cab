package Controller;

import Model.DataBase;
import Model.TaxiTrip;
import View.InformationUser;
import java.util.Scanner;

public class DataCollection {
    private final InformationUser message;
    private final Scanner input;
    private final TaxiTrip taxiTrip;
    private final DataBase dataBase;

    public DataCollection() {
        message  = new InformationUser();
        input    = new Scanner(System.in);
        dataBase = new DataBase();
        taxiTrip = dataBase.getTaxiTrip();
    }

    public void askCustomerLocation() {
        message.enterLocation();
        taxiTrip.setCustomerLocation(input.nextLine());
    }

    public void askArriveDestination() {
        message.enterDestination();
        taxiTrip.setArriveDestination(input.nextLine());
    }

    public void askNoPassengers() {
        message.enterNumberPassengers();
        taxiTrip.setPassengers(input.nextInt());
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
                10
        );
    }
}
