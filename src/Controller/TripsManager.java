package Controller;

import View.*;
import Model.*;
import java.util.Scanner;
import java.util.ArrayList;
import static Controller.ModelClassConnections.*;

class TripsLimitReachedException extends Exception{
}

public class TripsManager {
    private boolean stageReadyToContinue;
    private int tripsLimit;
    // View
    private final OptionInformation optionInformation;
    private final MenuPayment menuPayment;
    private final InformationTrip informationTrip;
    private final InputUser inputUser;
    private final Scanner input;
    //Model
    TaxiDriver driver;
    Car car;

    public TripsManager() {
        optionInformation = new OptionInformation();
        menuPayment = new MenuPayment();
        stageReadyToContinue = false;
        informationTrip = new InformationTrip();
        inputUser = new InputUser();
        input = new Scanner(System.in);
        driver = new TaxiDriver();
        car = new Car();
        calculateTripsLimit();
    }

    public void run(){
        scheduleTrip();
        printTripTicket();
        selectPaymentMethod();

        informationTrip.showCabArrivalNotification(
                driver.getFirstName(), driver.getLastName(), car.getModel(),
                car.getLicencePlate(), car.getColor()
        );

        askForAnotherCabInteraction();
    }

    private void noMoreTripsAvailable(){
        optionInformation.cabUnavailable();
        optionInformation.tryAgain();

        if (inputUser.getUserDecision().equalsIgnoreCase("Y")) {
            forceOneMoreTrip();
        } else {
            stageReadyToContinue = true;
        }
    }

    private void forceOneMoreTrip(){
        tripsLimit++;
    }

    private void requestTrip() throws TripsLimitReachedException {
        if (!(tripsLimit > 0)){
            throw new TripsLimitReachedException();
        }
    }

    public boolean isStageReadyToMoveOn(){
        return stageReadyToContinue;
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

    private void calculateTripsLimit(){
        try {
            tripsLimit = dataBase.getDriversAmount();
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }

    private void scheduleTrip(){
        ArrayList<ObjectAppointable> listItems = new ArrayList<>();
        listItems.add(car);
        listItems.add(driver);
        listItems.add(travelDetails);
        taxiTrip.appointTaxi(listItems);
        tripsLimit--;
    }

    private void printTripTicket() {
        informationTrip.showInformationDriver(
                driver.getFirstName(), driver.getLastName(), driver.getPhone(),
                driver.getGender(), car.getIdentifier()
        );

        informationTrip.showInformationCar(
                car.getModel(), car.getLicencePlate(), car.getCarType(), car.getColor()
        );
    }

    private void selectPaymentMethod(){
        menuPayment.showMenu();
        String paymentMethod = input.next();
        inputUser.userInputInteger(paymentMethod, 1, 2);
    }

}
