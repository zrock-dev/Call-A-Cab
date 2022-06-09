package Controller;

import Model.TaxiTrip;

import java.util.Random;


public class BuyInformation {

    private double distanceRandom;
    TaxiTrip taxiTrip;


    public double GenerateDistance() {
        Random random = new Random();
        distanceRandom = random.nextInt(100)+1;
        return distanceRandom;
    }


    public double totalBuy() {
        return distanceRandom * taxiTrip.getNoPassengers() * 10;
    }
}
