package Controller;
import Model.*;
import View.OptionInformation;

public class TripsManager {
    // Model
    private int tripsLimit;
    private final DataBase dataBase;
    private final TaxiTrip taxiTrip;
    private final TravelDetails travelDetails;
    private final Car car;
    private final TaxiDriver driver;

    // View
    OptionInformation message;

    public TripsManager() {
        dataBase = new DataBase();
        taxiTrip = new TaxiTrip();
        travelDetails = new TravelDetails();
        driver = new TaxiDriver();
        car = new Car();
        message = new OptionInformation();

        calculateTripsLimit();
    }

    public TaxiTrip getTaxiTrip() {
        return taxiTrip;
    }

    public TravelDetails getTravelDetails() {
        return travelDetails;
    }

    protected void setTotalPrice(int totalPrice){
        taxiTrip.setTotalPrice(totalPrice);
    }

    private void calculateTripsLimit(){
        tripsLimit = dataBase.getDriversAmount();
    }

    public void requestTrip(){
        if (tripsLimit > 0){
            bookTrip();
            tripsLimit--;

        } else {
           message.cabUnavailable();
           message.tryAgain();
        }
    }

    protected void bookTrip(){
        int carIdentifier = taxiTrip.appointCar();
        int driverIdentifier = taxiTrip.appointDriver();
        int travelDetailsId = travelDetails.uploadTravelDetails();

        car.populateCar(carIdentifier);
        driver.populateDriver(driverIdentifier);
        taxiTrip.linkTravelDetails(travelDetailsId);

        taxiTrip.uploadTripTicket();
    }
}
