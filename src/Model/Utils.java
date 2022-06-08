package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {
    protected static Connection dataBaseConnection;

    protected static ResultSet grabDataFromDB(String vehiclePlate, String query) throws SQLException{
        ResultSet resultSet = null;
        PreparedStatement statement = dataBaseConnection.prepareStatement(query);
        statement.setString(1, vehiclePlate);

        resultSet = statement.executeQuery();
        resultSet.next();

        return resultSet;
    }
}
