package Model;

import java.sql.*;

import static Model.Utils.obtainIdentification;

class InvalidException extends Exception{

    public InvalidException(String str) {
        // calling the constructor of parent Exception
        super(str);
    }
}

public class TaxiTrip {
    // Trip travel data
    private String customerLocation, arriveDestination;
    private int noPassengers;
    private int totalPrice;

    // Trip transport data
    private int carIdentifier, driverIdentifier, travelIdentifier;

    // Database connection
    private final Connection dataBaseConnection;

    public TaxiTrip(Connection dataBaseConnection) {
        this.dataBaseConnection = dataBaseConnection;
    }

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

    public void appointCar(){
        carIdentifier = obtainIdentification("car");
    }

    public void appointDriver(){
        driverIdentifier = obtainIdentification("driver");
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

    /*
        Saves the values of the attributes into the DB
     */

    private void saveTravelInformation(){
        try {
            String query =
                    "INSERT INTO Travel_information " +
                    "(customer_location, arrive_destination, no_passengers) " +
                    "VALUES (?, ?, ?, ?)";
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
            System.out.println(exception.getMessage());
        }
    }
    
    public void saveTripTicket(){
        try {
            saveTravelInformation();

            String query =
                    "INSERT INTO Taxi_trips " +
                    "(Car_id, Driver_id, Travel_information_id, total_price) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
            preparedStatement.setInt(1, carIdentifier);
            preparedStatement.setInt(2, driverIdentifier);
            preparedStatement.setInt(3, travelIdentifier);
            preparedStatement.setInt(3, totalPrice);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
