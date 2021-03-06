package Model;

import java.sql.*;

import static Model.Utils.*;

/**
 * This is the Taxi driver class.
 * This class returns the first name, last name, phone number and gender of taxi driver.
 * And introduces information of the taxi driver.
 */
public class TaxiDriver implements ObjectAppointable {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String gender;
    private int identifier;

    /**
     * This method return the driver's first name.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method return the driver's last name.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method return the driver's phone number.
     * @return phoneNumber
     */
    public int getPhone() {
        return phoneNumber;
    }

    /**
     * This method return the driver's gender.
     * @return gender
     */
    public String getGender() {
        return gender;
    }


    @Override
    public void populate(){
        try{
            String query = "SELECT Driver.first_name, Driver.last_name, Driver.phone, Driver.gender " +
                    "FROM Driver " +
                    "WHERE Driver.id = " + identifier + ";";
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

    @Override
    public void makeAppointment(int tripTicket) {
        identifier = obtainRandomIdentifier("Driver");
        updateTicket("driver_id", identifier, tripTicket);
        populate();
    }
}
