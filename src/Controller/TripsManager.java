package Controller;

import View.*;
import Model.*;
import java.util.Scanner;
import java.util.ArrayList;
import static Controller.ModelClassConnections.*;

/**
 * This exception is thrown whenever the limit of available trips is reached.
 *
 * @author AfricanRiot
 */
class TripsLimitReachedException extends Exception{
}

/**
 * This class manages the trip details
 *
 * @author AfricanRiot
 */
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

    /**
     * This constructor instantiates the necessary classes.
     * The calculateTripsLimit method is here because it needs to be run only one time.
     */
    public TripsManager() {
        stageReadyToContinue = false;
        optionInformation = new OptionInformation();
        informationTrip = new InformationTrip();
        menuPayment = new MenuPayment();
        inputUser = new InputUser();
        driver = new TaxiDriver();
        input = new Scanner(System.in);
        car = new Car();
        calculateTripsLimit();
    }

    /**
     * This method runs the other methods.
     * executes scheduleTrip, printTripTicket, selectPaymentMethod,
     * executes showCabArrivalNotification with driver and car values,
     * and executes askForAnotherCabInteraction.
     *
     * @see InformationUser
     */
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

    /**
     * This method executes cabUnavailable, tryAgain from OptionInformation when there
     * is no taxis, if the user put "Y" , will execute forceOneMoreTrip, or if the user put other letter,
     * stageReadyToContinue will change to true.
     *
     * @see OptionInformation
     */
    private void noMoreTripsAvailable(){
        optionInformation.cabUnavailable();
        optionInformation.tryAgain();

        if (inputUser.getUserDecision().equalsIgnoreCase("Y")) {
            forceOneMoreTrip();
        } else {
            stageReadyToContinue = true;
        }
    }

    /**
     * This method forces the program to accept another cab petition by
     * increasing the limit of trips available in one.
     */
    private void forceOneMoreTrip(){
        tripsLimit++;
    }

    /**
     * This method throws an exception if the tripsLimit is less to 1.
     *
     * @throws TripsLimitReachedException
     */
    private void requestTrip() throws TripsLimitReachedException {
        if (!(tripsLimit > 0)){
            throw new TripsLimitReachedException();
        }
    }

    /**
     * This method returns the current state of the stage as boolean
     *
     * @return the state of the stage as boolean.
     */
    public boolean isStageReadyToMoveOn(){
        return stageReadyToContinue;
    }

    /**
     * This method controls if the user decision is equals to N,
     * and tries to request trip.
     *
     * @see InputUser
     */
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

    /**
     * This method calculates the limit of available trips by the formula:
     * N° of available trips = N° of drivers at the start of the program.
     * we obtain the amount of drivers from the database.
     *
     * @see DataBase
     */
    private void calculateTripsLimit(){
        try {
            tripsLimit = dataBase.getDriversAmount();
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }


    /**
     * This method schedules a trip by linking secondary tables (Driver, Car, Travel_details)
     * with the primary table (Trips) resulting in the appointment of a taxi.
     */
    private void scheduleTrip(){
        ArrayList<Linkable> taxiComponents = new ArrayList<>();
        taxiComponents.add(car);
        taxiComponents.add(driver);
        taxiComponents.add(travelDetails);
        taxiTrip.appointTaxi(taxiComponents);
        tripsLimit--;
    }

    /**
     * This methods shows the overall information about the Taxi.
     * @see InformationTrip
     */
    private void printTripTicket() {
        informationTrip.showInformationDriver(
                driver.getFirstName(), driver.getLastName(), driver.getPhone(),
                driver.getGender(), car.getIdentifier()
        );

        informationTrip.showInformationCar(
                car.getModel(), car.getLicencePlate(), car.getCarType(), car.getColor()
        );
    }

    /**
     * This method just gets which method does the user uses to pay.
     *
     * @see MenuPayment
     */
    private void selectPaymentMethod(){
        menuPayment.showMenu();
        String paymentMethod = input.next();
        inputUser.userInputInteger(paymentMethod, 1, 2);
    }

}
