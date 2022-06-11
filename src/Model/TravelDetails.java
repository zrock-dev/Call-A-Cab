package Model;

import java.sql.*;

import static Model.Utils.*;

/**
 * This class sets and returns all the travel's details.
 * Returns Customer Location, Arrive Destination and N° passengers.
 * Sets Customer locations, Arrive Destination and N° passengers.
 */
public class TravelDetails {
    private String customerLocation, arriveDestination;
    private int noPassengers;
    private double totalPrice;

    /**
     * This method returns the customer location.
     * @return customerLocation
     */
    public String getCustomerLocation() {
        return customerLocation;
    }

    /**
     * This method returns the customer arrive destination.
     * @return arriveDestination
     */
    public String getArriveDestination() {
        return arriveDestination;
    }

    /**
     * This method returns N° passengers.
     * @return noPassengers
     */
    public int getNoPassengers() {
        return noPassengers;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method sets the customer location.
     * @param customerLocation
     */
    public void setCustomerLocation(String customerLocation) {
        this.customerLocation = customerLocation;
    }

    /**
     * This method sets the customer arrive destination.
     * @param arriveDestination
     */
    public void setArriveDestination(String arriveDestination) {
        this.arriveDestination = arriveDestination;
    }

    /**
     * This method sets N° passengers.
     * @param noPassengers
     */
    public void setNoPassengers(int noPassengers) {
        this.noPassengers = noPassengers;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //Pendent
    /**
     *
     */

    protected int obtainIdentifier(){
        int identifier = 0;
        try{
            Statement statement = dataBaseConnection.createStatement();
            String IdentifierQuery =
                    "SELECT id FROM Travel_details ORDER BY id DESC";
            ResultSet resultSet = statement.executeQuery(IdentifierQuery);
            resultSet.next();
            identifier = resultSet.getInt("id");
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return identifier;
    }

    public void uploadTravelDetails(){
        String query =
                "INSERT INTO Travel_details " +
                        "(customer_location, arrive_destination, no_passengers, total_price) " +
                        "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement queryValues = dataBaseConnection.prepareStatement(query);
            queryValues.setString(1, customerLocation);
            queryValues.setString(2, arriveDestination);
            queryValues.setInt(3, noPassengers);
            queryValues.setDouble(4, totalPrice);
            queryValues.executeUpdate();

            travelDetailsIdentifier = obtainIdentifier();

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
