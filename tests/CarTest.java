import Model.Car;
import Model.DataBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    public void overallTest(){
        DataBase dataBase = new DataBase();
        Car car = new Car();
        car.populateCar("2G00D");
        assertEquals("Mitsubishi", car.getModel());
        assertEquals("Green", car.getColor());
    }
}
