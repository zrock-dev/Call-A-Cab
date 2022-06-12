package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class Utils {
    protected static Connection dataBaseConnection;

    protected static int obtainRandomIdentifier(String tableName) {
        int identifier = 0;
        String query = "SELECT id FROM " + tableName + " ORDER BY rand() LIMIT 1";

        try (ResultSet queryResult = dataBaseConnection
                .createStatement()
                .executeQuery(query)) {

            queryResult.next();
            identifier = queryResult.getInt("id");

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return identifier;
    }

    protected static void updateTicket(String foreignKeyName, int foreignIdentifier,
                                       int ticketIdentifier) {
        String query = "UPDATE Trips " +
                "SET " + foreignKeyName + " = " + foreignIdentifier +
                " WHERE Trips.id = " + ticketIdentifier;

        try (Statement statement = dataBaseConnection.createStatement()) {
            statement.executeUpdate(query);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
