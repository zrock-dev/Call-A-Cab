import Controller.TravelDetailsManager;
import Controller.TripsManager;

public class Application {
    private TravelDetailsManager travelDetailsManager;
    private TripsManager tripsManager;

    public void start(){
        travelDetailsManager = new TravelDetailsManager();
        tripsManager = new TripsManager();
        do {
            travelDetailsManager.run();
            tripsManager.run();
        }while (!tripsManager.isStageReadyToMoveOn());
    }

}
