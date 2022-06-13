package Controller;

import View.*;
import java.util.Scanner;

/**
 * This class controls the actions during the travel and after travel.
 * Executes the travel animation, controls the user's choice
 * about the tip, critics or exit and receives that.
 *
 * @author AfricanRiot
 */
public class DuringTravel {

    private final InformationTrip informationTrip;
    private final InformationUser informationUser;
    private final OptionInformation optionInformation;
    private final InputUser inputUser;
    private final Scanner input;

    /**
     * This constructor instantiates InformationTrip
     * InformationUser, OptionInformation, InputUser and a Scanner as input.
     */
    public DuringTravel(){
        informationTrip = new InformationTrip();
        informationUser = new InformationUser();
        optionInformation = new OptionInformation();
        inputUser = new InputUser();
        input = new Scanner(System.in);
    }

    /**
     * This method executes the travel animation.
     *
     * While count is less than 7, it will slow down
     * the execution time of the code by 1100, and executes
     * the traveling simulation with count as the parameter, then one will be added to count.
     * Then shows showUserDestinationArrived from InformationTrip.
     *
     * @see InformationTrip
     */
    private void executeTravelSimulation(){
        int count = 1;
        while(count < 7){
            try {
                Thread.sleep(1100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            informationTrip.showSimulationOfTravel(count);
            count++;
        }
        informationTrip.showUserDestinationArrived();
    }

    /**
     * This method shows the tips and critiques feature from OptionInformation,
     * receives the String number converted to int with userInputInteger from InputUser,
     * and saves on optionSelected.
     *
     * @see InputUser
     * @return returns optionSelected verified with validateChoiceInRange from InputUser.
     */
    private int choiceTipsOrCritiques(){
        optionInformation.tipsAndCritiques();
        int optionSelected = inputUser.userInputInteger(input.next());
        return inputUser.validateChoiceInRange(optionSelected, 1, 3);
    }

    /**
     * This method calls receiveTip or receiveCritique depending on user's choice.
     * This will be executed if user's selection is different to 3
     */
    private void chooseOptionAfterTrip(){
        int option = 0;
        do{
            option = choiceTipsOrCritiques();
            switch (option){
                case 1:
                    receiveTip();
                    break;
                case 2:
                    receiveCritique();
                    break;
            }
        } while(option != 3);
    }

    /**
     * This method calls showReceiveTip from InformationUser,
     * converts the user's tip to int with userInputInteger from InputUser,
     * and saves the result on tip.
     *
     * @see InputUser
     * @see InformationUser
     */
    private void receiveTip(){
        informationUser.showReceiveTip();
        int tip = inputUser.userInputInteger(input.next());
        informationUser.showTip(tip);
    }

    /**
     * This method calls showReceiveCritique from InformationUser,
     * saves that the user wrote in critique and shows it in showCritique from InformationUser
     *
     * @see InformationUser
     */
    private void receiveCritique(){
        informationUser.showReceiveCritique();
        String critique = input.next();
        informationUser.showCritique(critique);
    }

    /**
     * This method executes TravelSimulation and chooseOptionAfterTrip methods.
     */
    public void run(){
        executeTravelSimulation();
        chooseOptionAfterTrip();
    }
}
