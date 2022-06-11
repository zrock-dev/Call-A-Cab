package Controller;

import View.InformationTrip;
import View.MenuPayment;
import View.OptionInformation;

import static Controller.ModelClassConnections.*;

class TripsLimitReachedException extends Exception{
}

public class TripsManager {
    private boolean stageReadyToContinue;

    int tripsLimit;
    // View
    private final OptionInformation optionInformation;
    private final MenuPayment menuPayment;
    private final InformationTrip informationTrip;
    private final InputUser inputUser;

    public TripsManager() {
        optionInformation = new OptionInformation();
        menuPayment = new MenuPayment();
        stageReadyToContinue = false;
        informationTrip = new InformationTrip();
        inputUser = new InputUser();
        calculateTripsLimit();
    }

    public void run(){
        scheduleTrip();
        printTripTicket();
        selectPaymentMethod();

        informationTrip.showCabArrivalNotification(
                driver.getFirstName(), driver.getLastName(), car.getCarType(),
                car.getLicencePlate(), car.getColor()
        );

        askForAnotherCabInteraction();
    }

    private void noMoreTripsAvailable(){
        optionInformation.cabUnavailable();
        optionInformation.tryAgain();
        if (inputUser.getUserDecision().equalsIgnoreCase("Y")) {
            tripsLimit++; // force one more trip
        } else {
            stageReadyToContinue = true;
        }
    }


    private void askForAnotherCabInteraction() {
        String userDecision = inputUser.getUserDecision();
        if (userDecision.equalsIgnoreCase("N")) {
            stageReadyToContinue = true;
        } else {
            try {
                requestTrip();
            } catch (TripsLimitReachedException exception) {
                noMoreTripsAvailable();
            }
        }
    }

    private void requestTrip() throws TripsLimitReachedException {
        if (!(tripsLimit > 0)){
            throw new TripsLimitReachedException();
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

    private void scheduleTrip(){
        tripsLimit--;
        int carIdentifier = taxiTrip.appointCar();
        int driverIdentifier = taxiTrip.appointDriver();

        car.populateCar(carIdentifier);
        driver.populateDriver(driverIdentifier);
        taxiTrip.uploadTripTicket();
    }

    private void printTripTicket() {
        informationTrip.showInformationDriver(
                driver.getFirstName(), driver.getLastName(), driver.getPhone(),
                driver.getGender(), car.getCarIdentification());

        informationTrip.showInformationCar(
                car.getModel(), car.getLicencePlate(), car.getCarType(), car.getColor());
    }

    private void selectPaymentMethod(){
        menuPayment.showMenu();
    }

}
