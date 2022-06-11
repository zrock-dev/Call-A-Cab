import Controller.*;
import View.Greeting;

/**
 * This class instances the principal classes.
 * This class instances TravelDetailsManager, TripManager,
 * Instances HistoryManager and Greeting.
 */
public class Application {
    /**
     *This method initiates the program.
     */
    public void start(){
        TravelDetailsManager travelDetailsManager = new TravelDetailsManager();
        TripsManager tripsManager = new TripsManager();
        HistoryManager historyManager = new HistoryManager();
        DuringTravel duringTravel = new DuringTravel();
        GreetingsManager greetingsManager = new GreetingsManager();

        greetingsManager.showWelcomeMessage();

        do {
            travelDetailsManager.run();
            tripsManager.run();
        }while (!tripsManager.isStageReadyToMoveOn());

        duringTravel.terminateTravel();
        // to print the history
        historyManager.run();

        greetingsManager.showFareWellMessage();
    }
}
