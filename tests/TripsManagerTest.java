import Controller.TripsManager;
import Model.TaxiTrip;
import Model.TravelDetails;
import org.junit.jupiter.api.Test;

class TripsManagerTest {
    TripsManager tripsManager = new TripsManager();
    TaxiTrip trip = tripsManager.getTaxiTrip();
    TravelDetails tDetails = tripsManager.getTravelDetails();

    public void fixInitialData(){
        tDetails.setCustomerLocation("Eguino");
        tDetails.setArriveDestination("PLaza Murillo");
        tDetails.setNoPassengers(10);
        trip.setTotalPrice(10);
    }

    @Test
    void everythingWorking(){
        fixInitialData();
        tripsManager.requestTrip();
    }
}
