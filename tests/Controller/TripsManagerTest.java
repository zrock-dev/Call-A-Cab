package Controller;

import org.junit.jupiter.api.Test;

import static Controller.ModelConnections.taxiTrip;
import static Controller.ModelConnections.travelDetails;

class TripsManagerTest {

    public void fixInitialData(){
        ModelConnections.initClasses();
        travelDetails.setCustomerLocation("Calle Homero");
        travelDetails.setArriveDestination("PLaza Alcanzar");
        travelDetails.setNoPassengers(10);
        taxiTrip.setTotalPrice(10);
    }

    @Test
    void everythingWorking(){
        fixInitialData();
        TripsManager tripsManager = new TripsManager();
        for (int i = 0; i < 4; i++) {
            tripsManager.requestTrip();
        }
    }
}
