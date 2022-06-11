package Model;

import java.sql.*;

import static Model.Utils.*;

/**
 * This class assigns a Taxi to  a trip.
 * This class assigns a taxi driver and a car to a trip, gets a travel identifier,
 * Set the total Price and generates a ticket.
 */
public class TaxiTrip {

    private int carIdentifier, driverIdentifier;
    private int numberOfTripsRecorded;

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

//Pendent
    /**
     *
     */
    public void uploadTripTicket(){
        try {
            String query =
                    "INSERT INTO Trips " +
                    "(car_id, driver_id, travel_information_id) " +
                    "VALUES ("+
                            carIdentifier + "," +
                            driverIdentifier + "," +
                            travelDetailsIdentifier +
                            ");";
            PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
            preparedStatement.executeUpdate();
            numberOfTripsRecorded++;

        } catch (SQLException exception) {
           exception.printStackTrace();
        }
    }

    public ResultSet enableHistoryMode(){
        ResultSet resultSet = null;
        String query =
                "SELECT car.id, driver.first_name, driver.last_name,Ti.customer_location," +
                        " Ti.arrive_destination, Ti.total_price " +
                        "FROM Trips " +
                        "INNER JOIN Car car on Trips.car_id = car.id " +
                        "INNER JOIN Driver driver on Trips.driver_id = driver.id " +
                        "INNER JOIN Travel_details Ti on Trips.travel_information_id = Ti.id " +
                        "ORDER BY Trips.id DESC LIMIT " + numberOfTripsRecorded + " ;";
        try {
            resultSet = dataBaseConnection.createStatement().executeQuery(query);
        } catch (SQLException exception){
            exception.printStackTrace();
        }

        return resultSet;
    }
}
