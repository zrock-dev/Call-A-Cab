package Model;

import java.sql.*;
import static Model.Utils.*;

/**
 *  This class contains methods that help us get the car information.
 *
 *  Contains attributes such as model, color, car type and license plate,
 *  also obtains the information from the Car table in the database.
 *
 * @author
 */
public class Car implements Linkable, Populable {
    private int identifier;
    private String model, color, carType, licencePlate;

    /**
     * This method gets the model of the car.
     *
     * @return model.
     */
    public String getModel() {
        return model;
    }

    /**
     * This is the method get the color of the car
     *
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * This is the method get the license plate of the car
     *
     * @return licensePlate
     */
    public String getLicencePlate() {
        return licencePlate;
    }

    /**
     * This is the method get the car type of the car
     *
     * @return carType
     */
    public String getCarType() {
        return carType;
    }

    /**
     * This is the method get the car identification.
     *
     * @return carIdentification
     */
    public int getIdentifier() {
        return identifier;
    }


    @Override
    public void makeAppointment(int tripTicket){
        identifier = obtainRandomIdentifier("Car");
        updateTicket("car_id", identifier, tripTicket);
        populate();
    }

    @Override
    public void populate() {
        try {
            String query = "SELECT model, color, type, licence_plate " +
                    "FROM Car " +
                    "WHERE Car.id = " + identifier + ";";
            ResultSet resultSet = dataBaseConnection.createStatement().executeQuery(query);
            resultSet.next();

            model = resultSet.getString("model");
            color = resultSet.getString("color");
            carType = resultSet.getString("type");
            licencePlate = resultSet.getString("licence_plate");

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
