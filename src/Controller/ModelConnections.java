package Controller;

import Model.*;

public class ModelConnections {
    protected static DataBase dataBase;
    protected static TaxiTrip taxiTrip;
    protected static TravelDetails travelDetails;
    protected static TaxiDriver driver;
    protected static Car car;

    protected static void initClasses(){
        dataBase = new DataBase();
        taxiTrip = new TaxiTrip();
        travelDetails = new TravelDetails();
        driver = new TaxiDriver();
        car = new Car();
    }
}
