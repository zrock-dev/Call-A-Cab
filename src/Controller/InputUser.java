package Controller;

import View.*;
import java.util.Scanner;

public class InputUser {

    private Scanner input;
    private OptionInformation optionInformation;
    private InformationUser informationUser;

    public InputUser(){
        input = new Scanner(System.in);
        optionInformation = new OptionInformation();
        informationUser = new InformationUser();
    }

    protected String askUserDecision(){
        String userDecision;
        do {
            informationUser.askUserDecision();
            userDecision = input.next();
        }while(!isUserDecisionExpected(userDecision));

        return userDecision;
    }

    private boolean isUserDecisionExpected(String userDecision) {
        boolean decisionValidation = false;
        if (userDecision.equalsIgnoreCase("Y") || userDecision.equalsIgnoreCase("N")){
            decisionValidation = true;
        }
        return decisionValidation;
    }

    private boolean isUserSelectionInteger(String number) {
        try{
            Integer.parseInt(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean isNumberInsideOfRange(int number, int minRange, int maxRange) {
        return number <= maxRange && number >= minRange;
    }

    protected int validateChoiceInRange(int numberToVerify, int minRange, int maxRange){
        boolean checkNumber = isNumberInsideOfRange(numberToVerify, minRange,maxRange);
        while(!checkNumber){
            optionInformation.numberOutOfRange();
            numberToVerify = input.nextInt();
            checkNumber = isNumberInsideOfRange(numberToVerify, minRange, maxRange);
        }
        return numberToVerify;
    }

    protected int userInputInteger(String number){
        while(!isUserSelectionInteger(number)){
            optionInformation.numberOutOfRange();
            number = input.next();
        }
        return Integer.parseInt(number);
    }
}
