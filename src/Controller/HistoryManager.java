package Controller;
import View.InformationTrip;

import java.sql.*;

import static Controller.ModelClassConnections.taxiTrip;

/**
 * This class manages the history of the recorded trips.
 */
public class HistoryManager {
    /**
     * This method calls printHistoryHeader from InformationTrip class,
     * gets recorded values from the database and prints that through
     * showScheduledTripsHistory method in InformationTrip class.
     *
     * @see InformationTrip
     * @see Model.TaxiTrip
     */
    public void run(){
        InformationTrip informationTrip = new InformationTrip();
        int taxiIdentifier;
        String driverFirstName;
        String driverLastName;
        String customerLocation;
        String arriveDestination;
        double totalCost;

        informationTrip.printHistoryHeader();
        try (ResultSet resultSet = taxiTrip.enableHistoryMode()) {
            while (resultSet.next()){
                taxiIdentifier = resultSet.getInt(1);
                driverFirstName = resultSet.getString(2);
                driverLastName = resultSet.getString(3);
                customerLocation = resultSet.getString(4);
                arriveDestination = resultSet.getString(5);
                totalCost = resultSet.getDouble(6);

                informationTrip.showScheduledTripsHistory(
                        taxiIdentifier, driverFirstName, driverLastName,
                        customerLocation, arriveDestination, totalCost
                );
            }

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
