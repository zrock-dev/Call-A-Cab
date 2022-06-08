package Controller.util;

import View.OptionInformation;

import java.util.Scanner;

public class CheckInputUser {

    Scanner input;
    OptionInformation message;

    public CheckInputUser(){
        input = new Scanner(System.in);
        message=new OptionInformation();
    }

    public boolean verifyData(String character) {
        boolean checkData =false;
        if (character.equalsIgnoreCase("Y")||character.equalsIgnoreCase("N")){
            checkData =true;
        }
        return checkData;
    }

    private boolean verifyInteger(String number) {
        try{
            Integer.parseInt(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean verifyNumberInsideRange(int number, int optionMin, int optionMax) {
        return number <= optionMax && number >= optionMin;
    }


    public int receiveCorrectOption(){
        int number = input.nextInt();
        boolean checkNumber=verifyNumberInsideRange(number, 1,3);
        while(!checkNumber){
            message.showIncorrectSelect();
            number = input.nextInt();
            checkNumber=verifyNumberInsideRange(number,1,3);
        }
        return number;
    }


}


