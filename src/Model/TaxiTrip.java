package Model;

import java.sql.*;
import java.util.ArrayList;

import static Model.Utils.*;

/**
 * This class assigns a Taxi to  a trip.
 * This class assigns a taxi driver and a car to a trip, gets a travel identifier,
 * Set the total Price and generates a ticket.
 */
public class TaxiTrip {
    private int tripsRecorded;

    public void appointTaxi(ArrayList<ObjectAppointable> taxiComponents){
        int taxiTicket = generateTicket();
        if (taxiTicket == 0){
            System.out.println("\n\n Error not working \n\n");
        }
        for (ObjectAppointable item:
             taxiComponents) {
            item.makeAppointment(taxiTicket);
        }
//        taxiComponents.iterator()
//                .next()
//                .makeAppointment(taxiTicket);
    }

//Pendent
    /**
     *
     */
    public int generateTicket(){
        int ticket = 0;
        try {
            CallableStatement statement = dataBaseConnection.prepareCall("{CALL generateTicket (?)}");
            statement.registerOutParameter(1, Types.INTEGER);
            statement.execute();
            ticket = statement.getInt(1);
            tripsRecorded++;

        } catch (SQLException exception) {
           exception.printStackTrace();
        }
        return ticket;
    }

    public ResultSet enableHistoryMode(){
        ResultSet resultSet = null;
        String query =
                "SELECT Trips.id, driver.first_name, driver.last_name,Ti.customer_location," +
                        " Ti.arrive_destination, Ti.total_price " +
                        "FROM Trips " +
                        "INNER JOIN Car car on Trips.car_id = car.id " +
                        "INNER JOIN Driver driver on Trips.driver_id = driver.id " +
                        "INNER JOIN Travel_details Ti on Trips.travel_details_id = Ti.id " +
                        "ORDER BY Trips.id DESC LIMIT " + tripsRecorded + " ;";
        try {
            resultSet = dataBaseConnection.createStatement().executeQuery(query);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return resultSet;
    }
}
