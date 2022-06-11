package Model;
import java.sql.*;

public class DataBase {

    private Connection dataBaseConnection;

    public DataBase(){
        dataBaseConnection = null;
        establishConnection();
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

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    private void connectUtils(){
        Utils.dataBaseConnection = dataBaseConnection;
    }

    public int getDriversAmount(){
        int driversAmount = 0;
        try(CallableStatement statement = dataBaseConnection.prepareCall("{CALL getDriversQuantity (?)}")){
            statement.registerOutParameter(1, Types.INTEGER);
            statement.execute();
            driversAmount = statement.getInt(1);

        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return driversAmount;
    }

    public ResultSet enableHistoryMode(){
        ResultSet resultSet = null;
        String query =
                "SELECT car.id, driver.first_name, driver.last_name,Ti.customer_location," +
                      " Ti.arrive_destination, Ti.total_price " +
                "FROM Trips " +
                "INNER JOIN Car car on Trips.car_id = car.id " +
                "INNER JOIN Driver driver on Trips.driver_id = driver.id " +
                "INNER JOIN Travel_details Ti on Trips.travel_information_id = Ti.id;";
        try {
            resultSet = dataBaseConnection.createStatement().executeQuery(query);
        } catch (SQLException exception){
            exception.printStackTrace();
        }

        return resultSet;
    }
}
