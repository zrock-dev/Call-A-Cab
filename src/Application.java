import Controller.*;

/**
 * This class starts the application.
 * This class instances TravelDetailsManager, TripManager,
 * HistoryManager, and Greeting.
 *
 * @author AfricanRiot
 */
public class Application {

    /**
     * This method starts the program.
     * With this method we can start the application
     * instantiating the necessary classes.
     *
     */
    public void start(){
        GreetingsManager greetingsManager = new GreetingsManager();

        greetingsManager.showWelcomeMessage();
        userTripReservationsStage();
        afterReservationStage();
        greetingsManager.showFareWellMessage();
    }

    /**
     * This is where the core of the system, runs the trips reservation features.
     *
     * @see TravelDetailsManager
     * @see TripsManager
     */
    private void userTripReservationsStage(){
        TravelDetailsManager travelDetailsManager = new TravelDetailsManager();
        TripsManager tripsManager = new TripsManager();

        do {
            travelDetailsManager.run();
            tripsManager.run();
        }while (!tripsManager.isStageReadyToMoveOn());
    }

    /**
     * This method runs the final part of the system.
     * Prints the history of the recorded trips.
     */
    private void afterReservationStage(){
        HistoryManager historyManager = new HistoryManager();
        DuringTravel duringTravel = new DuringTravel();

        duringTravel.run();
        historyManager.run();
    }
}
