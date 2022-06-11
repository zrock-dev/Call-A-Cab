package View;

import View.Utils.*;

import static View.Utils.Decoration.decorationForMessage;

/**
 * This class show the trip's status.
 * Shows the driver's information and trip's status.
 */
public class InformationTrip {

    public void showCabArrivalNotification(String firstName, String lastName,
                                           String carType, String licencePlate, String color) {

        System.out.print(Colors.RESET +
                decorationForMessage("≡", 125)+"\n"+
                decorationForMessage("〝•〞",30)+"\n"+
                decorationForMessage(" ⁛ •",13)+
                " Arriving Soon " +
                decorationForMessage(" ⁛ •",14)+"\n"+
                decorationForMessage("〝•〞",30)+"\n"+
                decorationForMessage("≡", 125)+"\n"+
                firstName+ " "+ lastName+
                " is arriving soon in a "+carType + "("+licencePlate+")"+
                " with color " + color+ ".\nWe hope you have a safe trip " +
                " desired destination.\n"+
                decorationForMessage("≡", 125)+
                "\nDo you need another cab?:\n>>");
    }

    /**
     * This method shows a simulation of the trip.
     * @param numberOfPoint number of points next to "Traveling".
     */
    public void showSimulationOfTravel(int numberOfPoint){
        System.out.println(Colors.BLUE + "\nTraveling"+ ".".repeat(numberOfPoint));
    }

    /**
     * This method shows the driver's information.
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
     * @param model car's model.
     * @param licencePlate car's license plate.
     * @param carType car type.
     * @param colorCar car's color.
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
     */
    public void showUserDestinationArrived(){
        System.out.println("\nYou have arrived to your destine.");
    }

    public void printHistoryHeader(){
        System.out.println(Colors.CYAN +
            decorationForMessage("▓")+
            decorationForMessage(" ",46)+
            "Take a look of what you scheduled\n"+
            decorationForMessage("▓")
        );
    }

    public void showScheduledTripsHistory(int taxiIdentifier, String driverFirstName, String driverLastName, String location,
                                          String arriveDestination, double cost){
        System.out.println(Colors.CYAN +
                "Taxi # \t\t|"+ taxiIdentifier+"\n"+
                "Driver: \t\t|"+ driverFirstName + " " + driverLastName + "\n"+
                "From - To: \t|"+ location + " - " + arriveDestination + "\n"+
                "Price ($): \t|"+ cost + "\n" +
                decorationForMessage("＊•",48) + "\n");
    }
}
