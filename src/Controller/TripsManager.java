package Controller;

import Model.DataBase;

public class TaxiTripController {
    private int tripsLimit;
    private DataBase dataBase;

    public TaxiTripController(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    private void calculateTripsLimit(){
        tripsLimit = dataBase.getDriversNumber();
    }

    public void makeATrip(){

    }
}
