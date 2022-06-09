import Controller.TripsManager;
import Model.TaxiTrip;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripsManagerTest {
    TripsManager tripsManager = new TripsManager();
    TaxiTrip trip = tripsManager.getTaxiTrip();

    public void fixInitialData(){
        trip.setCustomerLocation("Eguino");
        trip.setArriveDestination("PLaza Murillo");
        trip.setNoPassengers(10);
        trip.setTotalPrice(10);
    }

    @Test
    void everythingWorking(){
        fixInitialData();
        tripsManager.attemptTrip();
    }


}