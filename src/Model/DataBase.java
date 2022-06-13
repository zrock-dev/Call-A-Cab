package Model;
import java.sql.*;

/**
 * This class provides a connection to the DBMS mySQL server.
 *
 * @author AfricanRiot
 */

public class DataBase {
    private Connection dataBaseConnection;
    private String password;
    private String user;


    /**
     * This constructor loads the database and the respective connection.
     */
    public DataBase(){
        loginUser();
        establishConnection();
        connectUtils();
    }

    /**
     * From here we set the user login information to login in the mySQL server.
     *
     */
    private void loginUser(){
// ----- mySQL user login -------------
        user = "root";
        password = "123";
// -------------------------------------
    }

    /**
     * This method establishes the formal login to the mySQL server.
     */
    private void establishConnection(){
        try {
            dataBaseConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Call-a-Cab", user, password
            );

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Assigns the database connection that will be used universally.
     */
    private void connectUtils(){
        Utils.dataBaseConnection = dataBaseConnection;
    }

    /**
     * Calls a procedure to get the amount of drivers in the Driver table.
     *
     * It's simple made by using the COUNT operator.
     *
     * @return the amount of drivers in the table Driver as integer.
     */
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
