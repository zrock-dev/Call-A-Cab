package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static Model.Utils.dataBaseConnection;
import static Model.Utils.obtainIdentifier;
import static Model.Utils.travelDetailsIdentifier;

/**
 * This class sets and returns all the travel's details.
 * Returns Customer Location, Arrive Destination and N° passengers.
 * Sets Customer locations, Arrive Destination and N° passengers.
 */
public class TravelDetails {
    private String customerLocation, arriveDestination;
    private int noPassengers;

    public String getCustomerLocation() {
        return customerLocation;
    }
    public String getArriveDestination() {
        return arriveDestination;
    }
    public int getNoPassengers() {
        return noPassengers;
    }

    public void setCustomerLocation(String customerLocation) {
        this.customerLocation = customerLocation;
    }
    public void setArriveDestination(String arriveDestination) {
        this.arriveDestination = arriveDestination;
    }
    public void setNoPassengers(int noPassengers) {
        this.noPassengers = noPassengers;
    }

    public void uploadTravelDetails(){

        try {
            String query =
                    "INSERT INTO Travel_information " +
                            "(customer_location, arrive_destination, no_passengers) " +
                            "VALUES (?, ?, ?)";
            PreparedStatement queryValues = dataBaseConnection.prepareStatement(query);
            queryValues.setString(1, customerLocation);
            queryValues.setString(2, arriveDestination);
            queryValues.setInt(3, noPassengers);
            queryValues.executeUpdate();

            travelDetailsIdentifier = obtainIdentifier("Travel_information");

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
