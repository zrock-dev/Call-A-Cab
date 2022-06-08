package Controller;

import Model.Car;
import Model.DataBase;
import Model.TaxiDriver;
import Model.TaxiTrip;

import java.sql.SQLException;

public class TripsManager {
    private int tripsLimit;
    private int actualRecord;
    private DataBase dataBase;
    private Car car;
    private TaxiDriver driver;
    private TaxiTrip taxiTrip;

    public TripsManager(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    private void calculateTripsLimit(){
        tripsLimit = dataBase.getDriversQuantity();
    }

    public void makeATrip(){
        if (tripsLimit >= 0){
            String taxiPlate = car.getVehiclePlate();
            car.assignTrip();
            driver.assignTrip();

            try {
                taxiTrip.setTaxiPlate(taxiPlate);
                taxiTrip.saveData();

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else {
            actualRecord = taxiTrip.getFirstRecordedTrip();
            car.makeAvailable();
            driver.makeAvailable();
        }

    }
}
