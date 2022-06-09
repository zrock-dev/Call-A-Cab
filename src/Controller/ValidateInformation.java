package Controller;

import Controller.util.CheckInputUser;
import View.OptionInformation;
import java.util.Scanner;

public class ValidateInformation {

    private OptionInformation message;
    private Scanner input;
    private CheckInputUser checkInputUser;
    private DataCollection dataCollection;



    public ValidateInformation(){
        message = new OptionInformation();
        input = new Scanner(System.in);
        checkInputUser = new CheckInputUser();
        dataCollection = new DataCollection();
    }

    public String receiveYOrN(){
        message.informationCorrect();
        return checkCorrectLetter(input.nextLine());
    }

    private String checkCorrectLetter(String userOption){
        boolean checker = checkInputUser.verifyData(userOption);
        while(!checker){
            message.showCorrectOption();
            userOption = input.nextLine();
            checker = checkInputUser.verifyData(userOption);
        }
        return userOption;
    }

}


