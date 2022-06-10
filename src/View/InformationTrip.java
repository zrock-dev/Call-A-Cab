package View;

import Model.*;
import View.Utils.*;

public class InformationTrip {

    Decoration decoration=new Decoration();

    public void earlyArrivalNotification(TaxiDriver driver, Car car) {
        System.out.println(Colors.RESET+ decoration.decorationForMessage("≡", 125)+"\n"+
                decoration.decorationForMessage("〝•〞",30)+"\n"+
                decoration.decorationForMessage(" ⁛ •",13)+
                " Arriving Soon " + decoration.decorationForMessage(" ⁛ •",14)+"\n"+
                decoration.decorationForMessage("〝•〞",30)+"\n"+
                decoration.decorationForMessage("≡", 125)+"\n"+
                driver.getFirstName()+ " "+ driver.getLastName()+
                " is arriving soon in a "+car.getCarType() + "("+car.getLicencePlate()+")"+
                " in a color " + car.getColor()+ ".\nWe hope you have a safe trip to your" +
                " desired destination.\n"+
                decoration.decorationForMessage("≡", 125));
    }

    public void showSimulationOfTravel(int numberOfPoint){
        System.out.println("Traveling"+".".repeat(numberOfPoint));

    }

    public void showTripTicket(TaxiDriver driver, Car car){
        System.out.println(Colors.BLUE +decoration.decorationForMessage("=")+
                decoration.decorationForMessage("»°", 62)+"\n"+
                decoration.decorationForMessage("=")+
                " \tT\t\t▓"+" Conductor Information\n"
                +" \tA\t\t▓ Name:         "+ driver.getFirstName() +" "+driver.getLastName()+
                "\n \tX\t\t▓ Phone Number: "+driver.getPhone()+
                "\n \tI\t\t▓ Gender:       "+driver.getGender()+
                "\n   #"+ car.getCarIdentification() +"      ▓"+"\n"+
                decoration.decorationForMessage("=")+
                decoration.decorationForMessage("»°",62)+"\n"+
                decoration.decorationForMessage("=")+
                ">> Car model:" + car.getModel()+
                "\n>> Plate:    "+ car.getLicencePlate()+
                "\n>> Type:     "+ car.getCarType()+
                "\n>> Color:    "+ car.getColor()+"\n"+
                decoration.decorationForMessage("≡", 124));
    }

    public void showYouAreInYourDestination(){
        System.out.println("\nYou have arrived to your destine.");
    }

    public void showMessageCritiques(){
        System.out.println("Write your opinion about the travel.\n");
    }
}
