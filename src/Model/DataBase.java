package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class DataBase {
    private Connection dataBaseConnection;
    private ResultSet  resultSet;
    private Statement statement;


    TaxiTrip taxiTrip;
    Car car;

    public DataBase(){
        dataBaseConnection = null;
        statement = null;
        resultSet = null;
        establishConnection();
        instanceTaxiTrip();
        connectUtils();
    }

    private void establishConnection(){
        // mysql login
        String user = "root";
        String password = "123";
        try {
            dataBaseConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Call-a-Cab", user, password
            );

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

    public int getDriversAmount(){
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


    public TaxiTrip getTaxiTrip(){
        return taxiTrip;
    }

}
