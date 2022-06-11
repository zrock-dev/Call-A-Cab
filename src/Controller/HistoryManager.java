package Controller;

import View.Greeting;
import View.InformationTrip;

import java.sql.*;
import static Controller.ModelClassConnections.dataBase;

public class HistoryManager {

    public void run(){
        InformationTrip informationTrip = new InformationTrip();
        int carID;
        String driverFirstName;
        String driverLastName;
        String customerLocation;
        String arriveDestination;
        double totalCost;

        try (ResultSet resultSet = dataBase.enableHistoryMode()) {
            while (resultSet.next()){
                carID = resultSet.getInt(1);
                driverFirstName = resultSet.getString(2);
                driverLastName = resultSet.getString(3);
                customerLocation = resultSet.getString(4);
                arriveDestination = resultSet.getString(5);
                totalCost = resultSet.getDouble(6);

                informationTrip.showScheduledTripsHistory(
                        carID, driverFirstName, driverLastName,
                        customerLocation, arriveDestination, totalCost
                );
            }

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
