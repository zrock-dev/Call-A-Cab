import Controller.TripsManager;
import Model.TaxiTrip;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripsManagerTest {


    public TaxiTrip fixInitialData(){
        TaxiTrip trip = new TaxiTrip();
        trip.setCustomerLocation("Eguino");
        trip.setArriveDestination("PLaza Murillo");
        trip.setNoPassengers(10);
        trip.setTotalPrice(10);
        return trip;
    }

    @Test
    void everythingWorking(){
        TaxiTrip trip = fixInitialData();
        TripsManager tripsManager = new TripsManager(trip);
        fixInitialData();
        tripsManager.attemptTrip();
    }

}