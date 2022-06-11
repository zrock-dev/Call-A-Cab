package Model;

import java.sql.*;

/**
 *
 */
public class Utils {
    protected static Connection dataBaseConnection;
    protected static int travelDetailsIdentifier;

    protected static int obtainRandomAppointment(String identificationType){
        int identifier = 0;
        String query = "SELECT id FROM "+ identificationType +" ORDER BY rand() LIMIT 1";

        try(ResultSet queryResult = dataBaseConnection.createStatement().executeQuery(query) ){
            queryResult.next();
            identifier = queryResult.getInt("id");

        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return identifier;
    }
}
