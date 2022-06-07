package View.Utils;

public class Decoration {

    public static String decorationForMessage(String decorativeElement, int numberRepetitions){
        return decorativeElement.repeat(numberRepetitions) + "\n";
    }

    public static String decorationForMessage(String decorativeElement){
        int numberOfRepetitions = 124;
        return decorativeElement.repeat(numberOfRepetitions) + "\n";
    }


}
