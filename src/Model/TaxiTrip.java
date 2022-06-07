package Model;

import java.sql.*;

class InvalidException extends Exception{

    public InvalidException(String str) {
        // calling the constructor of parent Exception
        super(str);
    }
}

public class TaxiTrip {
    private String taxiPlate;
    private String customerLocation;
    private String arriveDestination;
    private int passengers;
    private int totalCost;

    private final Connection dataBaseConnection;

    public TaxiTrip(Connection dataBaseConnection) {
        taxiPlate = null;
        this.dataBaseConnection = dataBaseConnection;
    }

    public String getTaxiPlate() {
        return taxiPlate;
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public String getArriveDestination() {
        return arriveDestination;
    }

    public int getNoPassengers() {
        return passengers;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTaxiPlate(String taxiPlate) throws InvalidException {
        try(CallableStatement statement = dataBaseConnection.prepareCall("{CALL checkTaxiPlate (?, ?)}")) {
            statement.registerOutParameter(2, Types.BOOLEAN);
            statement.setString(1, taxiPlate);
            statement.execute();

            boolean taxiPlateValidity = statement.getBoolean(2);
            if(taxiPlateValidity){
                this.taxiPlate = taxiPlate;
            }else{
                throw new InvalidException("The plate " + taxiPlate + " can't be found in the database");
            }

        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void setCustomerLocation(String customerLocation) {
        this.customerLocation = customerLocation;
    }

    public void setArriveDestination(String arriveDestination) {
        this.arriveDestination = arriveDestination;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    /*
        Saves the values of the attributes into the DB
     */
    public void saveData() throws InvalidException {

        validateSavingData();

        try {
            String query = "INSERT INTO Taxi_trips " +
                    "(taxi_plate, Customer_location, arrive_destination, no_passengers, total_price)" +
                    " VALUES (?, ?, ?, ?, ?)";
            //   Taxi_Plate varchar(50),
            //   Customer_location varchar(255) NOT NULL,
            //   arrive_destination varchar(255) NOT NULL,
            //   no_passengers integer NOT NULL,
            //   total_price integer NOT NULL,
            PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);

            preparedStatement.setString(1, taxiPlate);
            preparedStatement.setString(2, customerLocation);
            preparedStatement.setString(3, arriveDestination);
            preparedStatement.setInt(4, passengers);
            preparedStatement.setInt(5, totalCost);

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void validateSavingData() throws InvalidException {
        if (taxiPlate == null){
            throw new InvalidException("Taxi plate can't be null");
        }
    }
}
