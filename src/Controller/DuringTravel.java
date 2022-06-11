package Controller;

import View.*;

import java.util.Scanner;
public class DuringTravel {

    private static InformationTrip informationTrip;
    private InformationUser informationUser;
    private OptionInformation optionInformation;
    private InputUser inputUser;
    private Scanner input;

    public DuringTravel(){
        informationTrip = new InformationTrip();
        informationUser = new InformationUser();
        optionInformation = new OptionInformation();
        inputUser = new InputUser();
        input = new Scanner(System.in);
    }

    private static void simulationTravel(){
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
        informationTrip.showYouAreInYourDestination();
    }

    private int choiceTipsOrCritiques(){
        optionInformation.tipsAndCritiques();
        int optionSelected = inputUser.userInputInteger(input.next());
        return inputUser.validateChoiceInRange(optionSelected, 1, 3);
    }

    private void chooseOptionAfterTrip(){
        int option = 0;
        do{
            option=choiceTipsOrCritiques();
            switch (option){
                case 1:
                    receiveTip();
                    break;
                case 2:
                    receiveCritique();
                    break;
            }
        }while(option!=3);
    }

    private void receiveTip(){
        informationUser.showReceiveTip();
        int tip = inputUser.userInputInteger(input.next());
        informationUser.showTip(tip);
    }

    private void receiveCritique(){
        String critique = "";
        informationUser.showReceiveCritique();
        critique = input.next();
        informationUser.showCritique(critique);
    }

    public void terminateTravel(){
        simulationTravel();
        chooseOptionAfterTrip();
    }
}
