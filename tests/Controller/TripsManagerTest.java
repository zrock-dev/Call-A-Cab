package Controller;

import org.junit.jupiter.api.Test;

import static Controller.ModelClassConnections.taxiTrip;
import static Controller.ModelClassConnections.travelDetails;

class TripsManagerTest {

    public void fixInitialData(){
        ModelClassConnections.initClasses();
        travelDetails.setCustomerLocation("street");
        travelDetails.setArriveDestination("MainStreet");
        travelDetails.setNoPassengers(100);
        travelDetails.setTotalPrice(10);
    }

    @Test
    void everythingWorking() throws NoMoreDrivers {
        fixInitialData();
//        TripsManager tripsManager = new TripsManager();
//        for (int i = 0; i < 4; i++) {
//            tripsManager.requestTrip();
//            System.out.println("\n\n");
//        }
    }
}
