package Model;

import java.sql.*;

/**
 * This class contains re utilizable code.
 *
 * Also it provides the only connection we have to the database
 *
 * @author AfricanRiot
 */
public class Utils {
    protected static Connection dataBaseConnection;

    /**
     * This method provides a random PK from a table.
     *
     * Pk: primary key.
     *
     * @param tableName the name of the table to get the PK
     * @return random identifier as integer.
     */
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

    /**
     * Links the FK of the secondary tables to the main table (Trips)
     * 
     * @param foreignKeyName name of the attributed FK in the table.
     * @param foreignIdentifier PK from the secondary table.
     * @param ticketIdentifier PK of the current row in the Trips table being used.
     */
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
