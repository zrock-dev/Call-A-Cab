package Controller;

import View.OptionInformation;
import java.util.Scanner;

public class ValidateInformation {

    private OptionInformation message;
    private Scanner input;
    private InputUser inputUser;
    private TravelDetailsManager travelDetailsManager;



    public ValidateInformation(){
        message = new OptionInformation();
        input = new Scanner(System.in);
        inputUser = new InputUser();
        travelDetailsManager = new TravelDetailsManager();
    }
    // public String receiveYOrN(){
    //   message.informationCorrect();
    // return checkCorrectLetter(input.nextLine());
    //}


//    private String checkCorrectLetter(String userOption){
//        boolean checker = checkInputUser.isUserInputCorrect(userOption);
//        while(!checker){
//            message.showCorrectOption();
//            userOption = input.nextLine();
//            checker = checkInputUser.isUserInputCorrect(userOption);
//        }
//        return userOption;
//    }

}


