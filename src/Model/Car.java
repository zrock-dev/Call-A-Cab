package Model;

import java.sql.*;
import static Model.Utils.dataBaseConnection;

public class Car {
    private int carIdentification;
    private String model, color, carType , licencePlate;

    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public String getLicencePlate() {
        return licencePlate;
    }
    public String getCarType() {
        return carType;
    }
    public int getCarIdentification() {
        return carIdentification;
    }

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
