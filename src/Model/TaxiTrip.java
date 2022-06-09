package Model;

import java.sql.*;

import static Model.Utils.*;

public class TaxiTrip {

    private int carIdentifier, driverIdentifier, travelIdentifier, totalPrice;
    private int taxiIdentification;

    public int appointCar(){
        carIdentifier = obtainRandomAppointment("Car");
        return carIdentifier;
    }
    public int appointDriver(){
        driverIdentifier = obtainRandomAppointment("Driver");
        return driverIdentifier;
    }

    public int getTaxiIdentification() {
        return taxiIdentification;
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

            travelIdentifier = obtainIdentifier("Trips");

        } catch (SQLException exception) {
           exception.printStackTrace();
        }
    }
}
