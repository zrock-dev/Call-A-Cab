import Model.DataBase;
import Model.TaxiTrip;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataBaseTest {

    @Test
    public void testOverall(){
        String taxiPlate = "2G00D";
        DataBase dataBase = new DataBase();
        TaxiTrip taxiTrip = dataBase.getTaxiTrip();

        try {
            taxiTrip.setTaxiPlate(taxiPlate);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        taxiTrip.setCustomerLocation("false Street");
        taxiTrip.setArriveDestination("Sesame Street");
        taxiTrip.setPassengers(3);
        taxiTrip.setTotalCost(120);

        try {
            taxiTrip.saveData();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void wrongPlateProvided(){
        String taxiPlate = "WRONG";
        DataBase dataBase = new DataBase();
        TaxiTrip taxiTrip = dataBase.getTaxiTrip();
        String exceptionMessage = "";

        try {
            taxiTrip.setTaxiPlate(taxiPlate);
        }catch (Exception e){
            exceptionMessage = e.getMessage();
        }
        taxiTrip.setCustomerLocation("false Street");
        taxiTrip.setArriveDestination("Sesame Street");
        taxiTrip.setPassengers(3);
        taxiTrip.setTotalCost(120);


        try {
            taxiTrip.saveData();
        }catch (Exception e){
        }

        assertEquals("The plate " + taxiPlate + " can't be found in the database", exceptionMessage);
    }

    @Test
   public void nullTaxiPlate(){
        DataBase dataBase = new DataBase();
        TaxiTrip taxiTrip = dataBase.getTaxiTrip();
        taxiTrip.setCustomerLocation("false Street");
        taxiTrip.setArriveDestination("Sesame Street");
        taxiTrip.setPassengers(3);
        taxiTrip.setTotalCost(120);

        String exceptionMessage = "";

        try {
            taxiTrip.saveData();
        }catch (Exception e){
            exceptionMessage = e.getMessage();
        }
        assertEquals("Taxi plate can't be null", exceptionMessage);
    }
}

