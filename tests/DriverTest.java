import Model.DataBase;
import Model.Driver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {

    @Test
    void overallTest(){
        DataBase dataBase = new DataBase();
        Driver driver = new Driver();
        driver.populateDriverInfo("2G00D");

        assertEquals("Shizuko", driver.getFirstName());
        assertEquals("Stiefel", driver.getLastName());
    }
}
