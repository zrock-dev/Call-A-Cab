package Model;

import java.sql.*;

import static Model.Utils.dataBaseConnection;
public class TaxiDriver {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String gender;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getPhone() {
        return phoneNumber;
    }
    public String getGender() {
        return gender;
    }


    public void populateDriver(int DriverIdentification){
        try{
            String query = "SELECT Driver.first_name, Driver.last_name, Driver.phone, Driver.gender " +
                    "FROM Driver " +
                    "WHERE Driver.id = " + DriverIdentification + ";";
            ResultSet resultSet = dataBaseConnection.createStatement().executeQuery(query);
            resultSet.next();

            firstName = resultSet.getString("first_name");
            lastName = resultSet.getString("last_name");
            phoneNumber = resultSet.getInt("phone");
            gender = resultSet.getString("gender");
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
