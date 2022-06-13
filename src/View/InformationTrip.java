package View;

import View.Utils.*;

import static View.Utils.Decoration.decorationForMessage;

/**
 *
 * This class shows the trip information.
 *
 * Shows the necessary messages with driver
 * information and trip status.
 */
public class InformationTrip {

    /**
     * This method displays a notification to the client.
     *
     * This message lets the customer know with a
     * message that the taxi they requested is already
     * on the way with their respective data that the
     * taxi has.
     *
     * @param driverFirstName It gives the name of the driver.
     * @param driverLastName It gives the last name of the driver.
     * @param carModel It gives the model of the driver's car.
     * @param licencePlate It gives the license plate of the driver's car.
     * @param color It gives the color of the driver's car.
     */
    public void showCabArrivalNotification(String driverFirstName, String driverLastName,
                                           String carModel, String licencePlate, String color) {

        System.out.print(Colors.RESET +
                decorationForMessage("≡", 125)+"\n"+
                decorationForMessage("〝•〞",30)+"\n"+
                decorationForMessage(" ⁛ •",13)+
                " Arriving Soon " +
                decorationForMessage(" ⁛ •",14)+"\n"+
                decorationForMessage("〝•〞",30)+"\n"+
                decorationForMessage("≡", 125)+"\n"+
                driverFirstName+ " " + driverLastName +
                " is arriving soon in a " + carModel + " (" + licencePlate + ")" +
                " color " + color + ".\nWe hope you have a safe trip " +
                " desired destination.\n"+
                decorationForMessage("≡", 125)+
                "\nDo you need another cab?:\n>>");
    }

    /**
     * This method shows a simulation of the trip.
     * It shows us the "Traveling" message with a point that
     * will be repeated depending on the parameter that you put.
     *
     * @param numberOfPoint Number of points that they want in
     *                      the "Traveling" to appear next to them.
     */
    public void showSimulationOfTravel(int numberOfPoint){
        System.out.println(Colors.BLUE + "Traveling"+ ".".repeat(numberOfPoint));
    }

    /**
     * This method shows the driver's information.
     *
     * @param firstName driver's first name.
     * @param lastName driver's last name.
     * @param phone driver's phone.
     * @param gender driver's gender.
     * @param carIdentification driver's car identification.
     */
    public void showInformationDriver(String firstName, String lastName, int phone, String gender,
                                      int carIdentification){
        System.out.println(Colors.BLUE +
                decorationForMessage("=")+
                decorationForMessage("»°", 62)+"\n"+
                decorationForMessage("=")+
                " \tT\t\t▓"+" Conductor Information\n"+
                " \tA\t\t▓ Name:         "+ firstName +" "+ lastName +
                "\n \tX\t\t▓ Phone Number: "+ phone  +
                "\n \tI\t\t▓ Gender:       "+ gender +
                "\n   #"+ carIdentification +"      ▓"+"\n"+
                decorationForMessage("=")+
                decorationForMessage("»°",62)+"\n"+
                decorationForMessage("=", 124)
        );
    }

    /**
     * This method shows the car's information.
     *
     * @param model gives the model of the car.
     * @param licencePlate gives the car's license plate.
     * @param carType gives the type of car.
     * @param colorCar gives the color of the car.
     */
    public void showInformationCar(String model, String licencePlate,String carType, String colorCar ){
        System.out.println(Colors.BLUE +
                  ">> Car model:"  + model+
                "\n>> Plate:    "+ licencePlate+
                "\n>> Type:     "+ carType+
                "\n>> Color:    "+ colorCar+ "\n"+
                decorationForMessage("≡", 124));
    }

    /**
     *This method shows the end of trip.
     *
     * Displays a message to the user when they have
     * reached their destination.
     */
    public void showUserDestinationArrived(){
        System.out.println("\nYou have arrived to your destine.");
    }

    /**
     *This method displays the History header.
     */
    public void printHistoryHeader(){
        System.out.println(Colors.CYAN +
            decorationForMessage("▓")+
            decorationForMessage(" ",46)+
            "Take a look of what you scheduled\n"+
            decorationForMessage("▓")
        );
    }

    /**
     *This method shows the History of the trips.
     *
     * shows all the trips that made each taxi with their
     * data of the Taxi, the Client, the trip and the price.
     * @param taxiIdentifier gives the number of the taxi that is identified
     * @param driverFirstName give the name of the driver
     * @param driverLastName give the last name of the driver
     * @param location gives the location of the client who was picked up
     * @param arriveDestination gives the destination where the client was taken
     * @param cost gives the cost of the trip that was requested
     */

    public void showScheduledTripsHistory(int taxiIdentifier, String driverFirstName, String driverLastName, String location,
                                          String arriveDestination, double cost){
        System.out.println(Colors.CYAN +
                "Taxi # \t\t|"+ taxiIdentifier+"\n"+
                "Driver: \t|"+ driverFirstName + " " + driverLastName + "\n"+
                "From - To: \t|"+ location + " - " + arriveDestination + "\n"+
                "Price ($): \t|"+ cost + "\n" +
                decorationForMessage("＊•",48) + "\n");
    }
}
