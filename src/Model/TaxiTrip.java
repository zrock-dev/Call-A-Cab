package Model;

import java.sql.*;

import static Model.Utils.dataBaseConnection;
import static Model.Utils.obtainIdentification;

public class TaxiTrip {

    private int carIdentifier, driverIdentifier, travelIdentifier, totalPrice;


    public int appointCar(){
        carIdentifier = obtainIdentification("Car");
        return carIdentifier;
    }
    public int appointDriver(){
        driverIdentifier = obtainIdentification("Driver");
        return driverIdentifier;
    }

    public void linkTravelDetails(int travelIdentifier){
        this.travelIdentifier = travelIdentifier;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void uploadTripTicket(){
        try {
            String query =
                    "INSERT INTO Trips " +
                    "(car_id, driver_id, travel_information_id, total_price) " +
                    "VALUES ("+
                            carIdentifier + "," +
                            driverIdentifier + "," +
                            travelIdentifier + "," +
                            totalPrice + ");";
            PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
           exception.printStackTrace();
        }
    }
}
