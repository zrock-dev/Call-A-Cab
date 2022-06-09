package Model;

import java.sql.*;

public class DataBase {
    Connection dataBaseConnection;
    PreparedStatement prepareStatement;
    ResultSet  resultSet;
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

    public TaxiTrip getTaxiTrip(){
        return taxiTrip;
    }
}
