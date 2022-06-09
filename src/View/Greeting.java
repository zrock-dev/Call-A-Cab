package View;

import View.Utils.Decoration;

public class Greeting {

    Decoration decoration=new Decoration();
    InformationUser informationUser = new InformationUser();
    public void welcome(){
        System.out.println(
                decoration.decorationForMessage("▓",124)+"\n"+
                        decoration.decorationForMessage("♦",124)+
                        "\n"+ decoration.decorationForMessage("❉",45)+
                        " Welcome to our Call-A-Cab System " +
                        decoration.decorationForMessage("❉",45)+"\n"
                        +decoration.decorationForMessage("♦",124)+"\n"+
                        decoration.decorationForMessage("▓",124));
        informationUser.messageToEnterUserData();
    }

    public void farewell(){
        System.out.println("\n"+
                decoration.decorationForMessage("▓",124)+"\n"+
                decoration.decorationForMessage("♦",124)+
                "\n"+ decoration.decorationForMessage("❉",34)+
                " Thank you for choosing us, we hope you have a nice day " +
                decoration.decorationForMessage("❉",34)+"\n"
                +decoration.decorationForMessage("♦",124)+"\n"+
                decoration.decorationForMessage("▓",124)+"\n");
    }

}
