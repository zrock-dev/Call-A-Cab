package Controller;

import Controller.util.CheckInputUser;
import View.OptionInformation;
import java.util.Scanner;

public class ValidateInformation {

    private final OptionInformation message;
    private final Scanner input;
    private final CheckInputUser checkInputUser;
    private final DataCollection dataCollection;

    public ValidateInformation(){
        message = new OptionInformation();
        input = new Scanner(System.in);
        checkInputUser = new CheckInputUser();
        dataCollection = new DataCollection();
    }

    public String validateTripInformation(){
        message.informationCorrect();
        return input.nextLine();
    }

    public String receiveCorrectLetter(){
        String userOption = input.nextLine();
        boolean checker = checkInputUser.verifyData(userOption);
        while(!checker){
            message.showCorrectOption();
            userOption = input.nextLine();
            checker = checkInputUser.verifyData(userOption);
        }
        return userOption;
    }


    /** This method changes one of these informations.
     *
     *   1. Location
     *   2. Arrive Place
     *   3. No, Passengers
     * @return
     */
    private int selectInformationToChange(){
        message.informationChange();
        return input.nextInt();
    }

    public void changeUserInformation(){
        switch(selectInformationToChange()){
            case 1:
                dataCollection.askCustomerLocation();
                break;
            case 2:
                dataCollection.askArriveDestination();
                break;
            case 3:
                dataCollection.askNoPassengers();
                break;
            default:
                message.showIncorrectSelect();
        }
    }
}


