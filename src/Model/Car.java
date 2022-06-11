package Model;

import java.sql.*;
import static Model.Utils.dataBaseConnection;

/**
 *  This is the car class.
 *  This class returns the model ,color ,Licence Plate,Car type and car identification.
 *  And introduces information of the car.
 */
public class Car {
    private int carIdentification;
    private String model, color, carType , licencePlate;

    /**
     * This method returns the car's model.
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * This method return the car's color.
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * This method return the car's license plate.
     * @return licensePlate
     */
    public String getLicencePlate() {
        return licencePlate;
    }
    /**
     *This method return the car's type.
     * @return carType
     */
    public String getCarType() {
        return carType;
    }

    /**
     * This method return the car's Identification.
     * @return carIdentification
     */
    public int getCarIdentification() {
        return carIdentification;
    }
    // Falta llenar.
    /**
     * This method
     * @param identifier
     */

    public void populateCar(int identifier) {
        try {
            String query = "SELECT model, color, type, licence_plate " +
                    "FROM Car " +
                    "WHERE Car.id = " + identifier + ";";
            ResultSet resultSet = dataBaseConnection.createStatement().executeQuery(query);
            resultSet.next();

            carIdentification = identifier;
            model = resultSet.getString("model");
            color = resultSet.getString("color");
            carType = resultSet.getString("type");
            licencePlate = resultSet.getString("licence_plate");

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
