package Controller;

import java.util.Random;
import static Controller.ModelConnections.travelDetails;

public class BuyInformation {
    private double distanceRandom;

    public double GenerateDistance() {
        Random random = new Random();
        distanceRandom = random.nextInt(100)+1;
        return distanceRandom;
    }

    public double totalBuy() {
        return distanceRandom * travelDetails.getNoPassengers() * 10;
    }
}
