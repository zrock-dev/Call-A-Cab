package Controller;
import Model.TaxiTrip;

public class TripsManager {
    private int tripsLimit;
    private int driversAmount;
    private TaxiTrip taxiTrip;

    public TripsManager(int driversAmount) {
        this.driversAmount = driversAmount;
    }

    private void calculateTripsLimit(){
        tripsLimit = driversAmount;
    }

    public void makeATrip(){
        if (tripsLimit >= 0){
            taxiTrip.appointCar();
            taxiTrip.appointDriver();
            taxiTrip.saveTripTicket();

        } else {
            // show "we don't have any cars"
        }

    }
}
