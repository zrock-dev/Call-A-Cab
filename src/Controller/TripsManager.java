package Controller;

import View.*;
import static Controller.ModelClassConnections.*;

class LimitReachedException extends Exception{
}

public class TripsManager {
    int tripsLimit;
    // View
    private OptionInformation optionInformation;
    private InformationMethodPayment informationMethodPayment;
    private InformationTrip informationTrip;
    private CheckInputUser checkInputUser;
    private TravelDetailsManager travelDetailsManager;

     public TripsManager(TravelDetailsManager travelDetailsManager) {
         this.travelDetailsManager = travelDetailsManager;
        optionInformation = new OptionInformation();
        informationMethodPayment = new InformationMethodPayment();
        informationTrip = new InformationTrip();
    }


    public void run(){
        calculateTripsLimit();
        try {
            requestTrip();
        }catch (LimitReachedException exception){
            if(checkInputUser.askUserDecision().equalsIgnoreCase("Y")){
                scheduleTrip();
            }
        }
        
        // trip ticket
        // choose payment method
        // Do you need another cab?

        if (checkInputUser.askUserDecision().equalsIgnoreCase("Y")){
            travelDetailsManager.run(this);
        }
    }

    private void calculateTripsLimit(){
        try {
            tripsLimit = dataBase.getDriversAmount();
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }

    private void requestTrip() throws LimitReachedException {
        if (tripsLimit > 0){
            scheduleTrip();
            tripsLimit--;
        } else {
            optionInformation.cabUnavailable();
            optionInformation.tryAgain();
            throw new LimitReachedException();
        }
    }

    protected void scheduleTrip(){
        int carIdentifier = taxiTrip.appointCar();
        int driverIdentifier = taxiTrip.appointDriver();
        int travelDetailsId = travelDetails.uploadTravelDetails();

        car.populateCar(carIdentifier);
        driver.populateDriver(driverIdentifier);
        taxiTrip.linkTravelDetails(travelDetailsId);

        taxiTrip.uploadTripTicket();
    }

    protected void printTripTicket(){
        informationTrip.showTripTicket(driver,car);
    }

    protected void selectPaymentMethod(){
        informationMethodPayment.paymentMethod();
    }


}
