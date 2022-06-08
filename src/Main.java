import Controller.*;
import View.Greeting;
import View.InformationUser;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {
        DataCollection dataCollection= new DataCollection();
        ValidateInformation validateInformation = new ValidateInformation();
        Greeting greeting =new Greeting();
        greeting.welcome();
        dataCollection.start();
        dataCollection.changeUserInformation();



    }
}
