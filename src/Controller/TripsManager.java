package Controller;
import Model.Car;
import Model.DataBase;
import Model.TaxiDriver;
import Model.TaxiTrip;

public class TripsManager {
    private int tripsLimit;
    private final DataBase dataBase;
    private final TaxiTrip taxiTrip;
    private final Car car;
    private final TaxiDriver driver;

    public TripsManager() {
        dataBase = new DataBase();
        this.car = new Car();
        this.taxiTrip = new TaxiTrip();
        this.driver = new TaxiDriver();
        calculateTripsLimit();
    }

    public TaxiTrip getTaxiTrip() {
        return taxiTrip;
    }

    private void calculateTripsLimit(){
        tripsLimit = dataBase.getDriversAmount();
    }

    public void attemptTrip(){
        if (tripsLimit > 0){
            manualTrip();
            tripsLimit--;

        } else {
            // show "we don't have any cars"
        }
    }

    public void manualTrip(){
        int carIdentifier = taxiTrip.appointCar();
        int driverIdentifier = taxiTrip.appointDriver();

        car.populateCar(carIdentifier);
        driver.populateDriver(driverIdentifier);

        taxiTrip.saveTripTicket();
    }
}
