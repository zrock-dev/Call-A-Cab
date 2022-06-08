package Model;

import java.sql.*;

public class Car {
    private String model, color, vehiclePlate;
    private boolean tripStatus;

    public Car() {
        this.tripStatus = false;
    }


    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setVehiclePlate(DataBase dataBase){
        vehiclePlate = dataBase.getTaxiPlate();
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public boolean isTaxiOccupied(){
        return tripStatus;
    }

    public void assignTrip() {
        tripStatus = true;
    }

    public void makeAvailable() {
        tripStatus = false;
    }

    public void populateCar(String vehiclePlate) {
        try {
            String query = "SELECT specs.model, specs.color, specs.type " +
                    "FROM Taxi taxi " +
                    "INNER JOIN Taxi_specs specs ON taxi.taxi_specs_id = specs.id " +
                    "WHERE taxi.Plate = ?";

            try(ResultSet resultSet = Utils.grabDataFromDB(vehiclePlate, query)){
                model = resultSet.getString("Model");
                color = resultSet.getString("Color");
            }

//            String carType = resultSet.getString("Type");

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
