package View.Utils;

public class Decoration {

    public String decorationForMessage(String decorativeElement, int numberRepetitions){
        return decorativeElement.repeat(numberRepetitions);
    }
    public String decorationForMessage(String decorativeElement){
        int numberOfRepetitions = 124;
        return decorativeElement.repeat(numberOfRepetitions) + "\n";
    }
}
