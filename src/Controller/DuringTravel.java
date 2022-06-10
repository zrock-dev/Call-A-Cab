package Controller;

import View.*;

import java.util.Scanner;


public class DuringTravel {

    private static InformationTrip informationTrip;
    private InformationUser informationUser;
    private OptionInformation optionInformation;
    private CheckInputUser checkInputUser;
    private Scanner input;

    public DuringTravel(){
        informationTrip = new InformationTrip();
        informationTrip = new InformationTrip();
        optionInformation = new OptionInformation();
        checkInputUser = new CheckInputUser();
        input = new Scanner(System.in);
    }


    public static void showSimulationTravel(){
        int count = 1;
        while(count < 7){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            informationTrip.showSimulationOfTravel(count);
            count++;
        }
        informationTrip.showYouAreInYourDestination();
    }

    public int choiceTipsOrCritiques(){
        optionInformation.tipsAndCritiques();
        int optionSelected = input.nextInt();
        return checkInputUser.validateChoiceInRange(optionSelected, 1, 3);
    }

    public void receiveTip(){
        int tip = 0;
        informationUser.aboutTheTrip();
        tip = input.nextInt();
    }

    public void receiveCritique(){
        String critique;
        informationTrip.showMessageCritiques();
        critique = input.nextLine();
    }

    public static void main(String[] args) {
        DuringTravel duringTravel= new DuringTravel();
        duringTravel.showSimulationTravel();
        duringTravel.choiceTipsOrCritiques();
    }
}







