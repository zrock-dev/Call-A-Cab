package Model;

import java.sql.*;

import static Model.Utils.*;
import static Model.Utils.travelDetailsIdentifier;

/**
 * This class assigns a Taxi to  a trip.
 * This class assigns a taxi driver and a car to a trip, gets a travel identifier,
 * Set the total Price and generates a ticket.
 */
public class TaxiTrip {

    private int carIdentifier, driverIdentifier, totalPrice;

    /**
     * This method assigns a trip to a random car.
     * @return carIdentifier: all cars have different ones.
     */
    public int appointCar(){
        carIdentifier = obtainRandomAppointment("Car");
        return carIdentifier;
    }
    /**
     * This method assign a trip to a random driver.
     * @return driverIdentifier: all drivers have different ones.
     */
    public int appointDriver(){
        driverIdentifier = obtainRandomAppointment("Driver");
        return driverIdentifier;
    }

    /**
     * This class sets total price.
     * @param totalPrice
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
//Pendent
    /**
     *
     */
    public void uploadTripTicket(){
        try {
            String query =
                    "INSERT INTO Trips " +
                    "(car_id, driver_id, travel_information_id, total_price) " +
                    "VALUES ("+
                            carIdentifier + "," +
                            driverIdentifier + "," +
                            travelDetailsIdentifier + "," +
                            totalPrice + ");";
            PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
           exception.printStackTrace();
        }
    }
}
