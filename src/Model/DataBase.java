package Model;
import java.sql.*;

public class DataBase {
    private Connection dataBaseConnection;
    private String password;
    private String user;

    public DataBase(){
        loginUser();
        establishConnection();
        connectUtils();
    }

    private void loginUser(){
// ----- mySQL user login -------------
        user = "root";
        password = "123";
// -------------------------------------
    }

    private void establishConnection(){
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
}
