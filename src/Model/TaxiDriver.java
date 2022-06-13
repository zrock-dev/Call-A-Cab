package Model;

import java.sql.*;

import static Model.Utils.*;

/**
 *  This is the taxi driver class.
 *
 *  This class contains methods that help us get the taxi driver information.
 *  also gets the data from a Driver row in database.
 */
public class TaxiDriver implements Linkable, Populable {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String gender;
    private int identifier;

    /**
     * This is the method gets the first name of the taxi driver.
     *
     * @return taxi driver's firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This is the method gets the last name of the taxi driver.
     *
     * @return taxi driver's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This is the method gets the phone number of the taxi driver.
     *
     * @return taxi driver's phoneNumber.
     */
    public int getPhone() {
        return phoneNumber;
    }

    /**
     * This is the method gets the gender of the taxi driver.
     *
     * @return taxi driver's gender.
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
