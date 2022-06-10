package Controller;

import View.InformationUser;
import View.OptionInformation;
import java.util.Scanner;

public class CheckInputUser {

    private Scanner input;
    private OptionInformation message;
    private InformationUser informationUser;

    protected CheckInputUser(){
        input = new Scanner(System.in);
        message = new OptionInformation();
        informationUser = new InformationUser();
    }

    protected String askUserDecision(){
        String userDecision;
        do {
            informationUser.yesOrNo();
            userDecision = input.next();
        }while(!validateInput(userDecision));

        return userDecision;
    }

    private boolean validateInput(String userDecision) {
        boolean decisionValidation = false;
        if (userDecision.equalsIgnoreCase("Y") || userDecision.equalsIgnoreCase("N")){
            decisionValidation = true;
        }
        return decisionValidation;
    }

    protected boolean verifyInteger(String number) {
        try{
            Integer.parseInt(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean verifyNumberInsideRange(int number, int minRange, int maxRange) {
        return number <= maxRange && number >= minRange;
    }

    protected int validateChoiceInRange(int numberToVerify, int minRange, int maxRange){
        boolean checkNumber = verifyNumberInsideRange(numberToVerify, minRange,maxRange);
        while(!checkNumber){
            message.numberOutOfRange();
            numberToVerify = input.nextInt();
            checkNumber = verifyNumberInsideRange(numberToVerify, minRange, maxRange);
        }
        return numberToVerify;
    }
}
