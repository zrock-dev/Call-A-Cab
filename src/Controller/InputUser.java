package Controller;

import View.*;
import java.util.Scanner;

/**
 * This class controls the user's inputs.
 * This class converts the user's number to int, verifies if it's convertible to int,
 * controls if the user's number is on range, and gets user decision.
 */
public class InputUser {

    private final Scanner input;
    private final OptionInformation optionInformation;
    private final InformationUser informationUser;

    /**
     * This constructor instantiates Scanner, OptionInformation, and InformationUser.
     */
    public InputUser(){
        input = new Scanner(System.in);
        optionInformation = new OptionInformation();
        informationUser = new InformationUser();
    }

    /**
     * This method ask the user's decision and saves in userDecision,
     * If isUserDecisionExpected returns false, the method will ask again.
     *
     * @return if isUserDecisionExpected returns true, the method will return userDecision.
     */
    protected String getUserDecision(){
        String userDecision;
        do {
            informationUser.askUserDecision();
            userDecision = input.next();
        }while(!isUserDecisionExpected(userDecision));

        return userDecision;
    }

    /**
     * This method verifies Y or N.
     * Compares UserDecision with Y or N, changing decisionValidation
     * to true or keeping false depending on the comparison.
     *
     * @param userDecision the inputted value to evaluate.
     * @return returns true if user's entered character is equals to Y or N.
     *         returns false if user's entered character is not equals to Y or N.
     */
    private boolean isUserDecisionExpected(String userDecision) {
        return userDecision.equalsIgnoreCase("Y") || userDecision.equalsIgnoreCase("N");
    }

    /**
     * This method converts the string number to int.
     *
     * @param number the inputted value to evaluate.
     * @return returns true if it can be converted to a number.
     *         returns false if it cannot be converted to a number.
     */
    private boolean isUserSelectionAnInteger(String number) {
        try{
            Integer.parseInt(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * This method compares if the number is between minRange and maxRange.
     *
     * @param number   number to compare.
     * @param minRange minimum range.
     * @param maxRange maximum range.
     * @return return true if the number is between minimum range and max range.
     *         return false if the number is not between minimum range and max range.
     */
    private boolean isNumberInsideOfRange(int number, int minRange, int maxRange) {
        return number <= maxRange && number >= minRange;
    }

    /**
     * This method verifies if the user number is between minRange and maxRange
     * and saves his number in numberToVerify
     *
     * @param numberToVerify user's number.
     * @param minRange minimum range.
     * @param maxRange maximum range.
     * @return returns numberToVerify if isNumberInsideOfRange returns true.
     */
    protected int validateChoiceInRange(int numberToVerify, int minRange, int maxRange){
        boolean checkNumber = isNumberInsideOfRange(numberToVerify, minRange,maxRange);
        while(!checkNumber){
            optionInformation.numberOutOfRange();
            numberToVerify = input.nextInt();
            checkNumber = isNumberInsideOfRange(numberToVerify, minRange, maxRange);
        }
        return numberToVerify;
    }

    /**
     * This method compares the String number if it is out of range.
     * This method with isUserSelectionAnInteger controls number if it is convertible to int.
     *
     * @param number user's number.
     * @param minRange minimum range.
     * @param maxRange maximum range.
     * @return returns number converted to int with validateChoiceInRange.
     */
    protected int userInputInteger(String number, int minRange, int maxRange){
        while(!isUserSelectionAnInteger(number)){
            optionInformation.numberOutOfRange();
            number = input.next();
        }
        return validateChoiceInRange(Integer.parseInt(number), minRange, maxRange);
    }

    /**
     * This method returns number if it is convertible
     * to int with isUserSelectionAnInteger.
     *
     * @param number user's number
     * @return returns number converted to int.
     */
    protected int userInputInteger(String number){
        while(!isUserSelectionAnInteger(number)){
            optionInformation.numberOutOfRange();
            number = input.next();
        }
        return Integer.parseInt(number);
    }
}
