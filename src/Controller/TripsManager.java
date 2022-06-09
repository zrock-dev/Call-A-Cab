package Controller;

import View.OptionInformation;
import static Controller.ModelConnections.*;

public class TripsManager {
    int tripsLimit;
    // View
    OptionInformation message;

    public TripsManager() {
        message = new OptionInformation();
        calculateTripsLimit();
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
