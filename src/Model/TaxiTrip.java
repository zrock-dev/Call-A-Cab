package Model;

import java.sql.*;

import static Model.Utils.dataBaseConnection;
import static Model.Utils.obtainIdentification;

public class TaxiTrip {
    // Trip travel data
    private String customerLocation, arriveDestination;
    private int noPassengers, totalPrice;

    // Trip transport data
    private int carIdentifier, driverIdentifier, travelIdentifier;


    public String getCustomerLocation() {
        return customerLocation;
    }
    public String getArriveDestination() {
        return arriveDestination;
    }
    public int getNoPassengers() {
        return noPassengers;
    }
    public int getTotalPrice() {
        return totalPrice;
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
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int appointCar(){
        carIdentifier = obtainIdentification("Car");
        return carIdentifier;
    }
    public int appointDriver(){
        driverIdentifier = obtainIdentification("Driver");
        return driverIdentifier;
    }

    /*
        Saves the values of the attributes into the DB
     */

    private void saveTravelInformation(){
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

            Statement statement = dataBaseConnection.createStatement();
            String travelIdentifierQuery =
                    "SELECT Travel_information.id FROM Travel_information " +
                    "ORDER BY id DESC";
            ResultSet resultSet = statement.executeQuery(travelIdentifierQuery);
            resultSet.next();
            travelIdentifier = resultSet.getInt("id");

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
    
    public void saveTripTicket(){
        try {
            saveTravelInformation();

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

        } catch (SQLException exception) {
           exception.printStackTrace();
        }
    }
}
