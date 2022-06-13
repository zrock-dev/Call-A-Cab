package Model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import static Model.Utils.dataBaseConnection;

/**
 *  This class contains methods that help us get the Trip information.
 *
 *  Contains attributes such as model, color, car type and license plate,
 *  also obtains the information from a specific Trip table row in the database.
 *
 * @author AfricanRiot
 */

public class TaxiTrip {
    private int tripsRecorded;

    /**
     * This method just calls the makeAppointment from the linkable classes to
     * establish the relation between tables.
     *
     * @see Linkable
     * @param taxiComponents An arrayList composed by: the details about the travel, driver and car.
     */
    public void appointTaxi(ArrayList<Linkable> taxiComponents){
        int taxiTicket = generateTicket();
        for (Linkable classTable:
             taxiComponents) {
            classTable.makeAppointment(taxiTicket);
        }
    }

    /**
     * Creates a Trip row to be filled with related tables identifiers.
     *
     * By calling the generateTicket procedure we create a row and then
     * get the identifier of that row.
     *
     * @return row identifier as integer.
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

    /**
     * The method makes a query with INNER JOINs to get records from the
     * scheduled trips.
     * 
     * @return The query result as ResultSet type.
     */
    public ResultSet enableHistoryMode(){
        ResultSet resultSet = null;
        String query =
                "SELECT car.id, driver.first_name, driver.last_name, Ti.customer_location, " +
                        "Ti.arrive_destination, Ti.total_price " +
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
