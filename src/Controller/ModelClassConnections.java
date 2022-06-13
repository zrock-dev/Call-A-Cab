package Controller;

import Model.*;

/**
 * This class has re utilizable code and universal values.
 */
public class ModelClassConnections {
    protected static DataBase dataBase;
    protected static TaxiTrip taxiTrip;
    protected static TravelDetails travelDetails;

    /**
     * This method instantiates DataBase, TaxiTrip and TravelDetails.
     */
    public static void initClasses(){
        dataBase = new DataBase();
        taxiTrip = new TaxiTrip();
        travelDetails = new TravelDetails();
    }
}
