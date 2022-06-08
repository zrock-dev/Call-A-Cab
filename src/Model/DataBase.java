package Model;

import java.sql.*;

public class DataBase {
    private Connection dataBaseConnection;
    private PreparedStatement prepareStatement;
    private ResultSet  resultSet;
    private Statement statement;

    TaxiTrip taxiTrip;
    Car car;

    public DataBase(){
        dataBaseConnection = null;
        prepareStatement = null;
        statement = null;
        resultSet = null;
        establishConnection();
        instanceTaxiTrip();
        connectUtils();
    }

    private void establishConnection(){
        try {
            dataBaseConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Call-a-Cab","root","123");

            statement = dataBaseConnection.createStatement();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void connectUtils(){
        Utils.dataBaseConnection = dataBaseConnection;
    }

    private void instanceTaxiTrip(){
        taxiTrip = new TaxiTrip(dataBaseConnection);
    }

    public int getDriversQuantity(){
        int driversAmount = 0;
        try(CallableStatement statement = dataBaseConnection.prepareCall("{CALL getDriversQuantity (?)}")){
            statement.registerOutParameter(1, Types.INTEGER);
            statement.execute();
            driversAmount = statement.getInt(1);

        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return driversAmount;
    }

    public String getTaxiPlate(){
        return "2G00D";
    }

    public TaxiTrip getTaxiTrip(){
        return taxiTrip;
    }

}
