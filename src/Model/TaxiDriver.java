package Model;

import java.sql.*;

import static Model.Utils.grabDataFromDB;

public class TaxiDriver {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String gender;
    private boolean tripStatus;

   public TaxiDriver(){this.tripStatus = false;}

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

    public void assignTrip() {
        tripStatus = true;
    }
    public void makeAvailable() {
        tripStatus = false;
    }

    public void populateDriverInfo (String vehiclePlate){
        try{
            String query = "SELECT driver.first_name, driver.last_name, driver.phone, driver.gender " +
                    "FROM Taxi " +
                    "INNER JOIN Driver driver on Taxi.Driver_Id = driver.CI "+
                    "WHERE Taxi.Plate = ?";

            try (ResultSet resultSet = grabDataFromDB(vehiclePlate, query)) {

                firstName = resultSet.getString("first_name");
                lastName = resultSet.getString("last_name");
                phoneNumber = resultSet.getInt("phone");
                gender = resultSet.getString("gender");
            }

        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }
}
