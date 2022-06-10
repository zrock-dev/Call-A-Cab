package Controller;

import View.*;
import static Controller.ModelClassConnections.*;

class LimitReachedException extends Exception{
}

public class TripsManager {
    private boolean stageReadyToContinue;

    int tripsLimit;
    // View
    private OptionInformation optionInformation;
    private MenuPayment menuPayment;
    private InformationTrip informationTrip;
    private CheckInputUser checkInputUser;

     public TripsManager() {
        optionInformation = new OptionInformation();
        menuPayment = new MenuPayment();
        informationTrip = new InformationTrip();
        checkInputUser = new CheckInputUser();
         calculateTripsLimit();
     }


    public void run(){
        try {
            requestTrip();
        }catch (LimitReachedException exception){
            if(checkInputUser.askUserDecision().equalsIgnoreCase("Y")){
                scheduleTrip();
            }
        }
        
        printTripTicket();
        // choose payment method
        informationTrip.earlyArrivalNotification(driver, car);

        if (checkInputUser.askUserDecision().equalsIgnoreCase("N")){
            stageReadyToContinue = true;
        }else {
            stageReadyToContinue = false;
        }
    }

    public boolean isStageReadyToMoveOn(){
         return stageReadyToContinue;
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

        car.populateCar(carIdentifier);
        driver.populateDriver(driverIdentifier);
        taxiTrip.uploadTripTicket();
    }

    protected void printTripTicket(){
        informationTrip.showTripTicket(driver,car);
    }

    protected void selectPaymentMethod(){
        menuPayment.showMenu();
    }


}
