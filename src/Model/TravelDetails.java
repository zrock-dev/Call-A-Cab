package Model;

import java.sql.*;

import static Model.Utils.*;

/**
 * This class contains methods that help us get the driver information.
 *
 * Contains attributes such as model, color, car type and
 * also obtains the information from the driver database.
 */
public class TravelDetails implements Linkable {
    private String customerLocation, arriveDestination;
    private int noPassengers;
    private double totalPrice;
    private int identifier;

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
     * This method returns N° of passengers.
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

    /**
     * This method obtains the identifier of the current in the Travel_details row in use.
     *
     */
    protected void obtainIdentifier(){
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
    }

    /**
     * Uploads the inputted details to the table Travel_details.
     *
     * The filled fields in the class are uploaded to the mentioned table
     * by a INSERT INTO statement.
     */
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

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void makeAppointment(int tripTicket) {
        obtainIdentifier();
        updateTicket("travel_details_id", identifier, tripTicket);
    }
}
