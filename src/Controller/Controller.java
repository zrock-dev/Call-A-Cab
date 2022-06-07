package Controller;


import Controller.util.CheckInputUser;
// Not to be a master controller
// check names
public class Controller {
    CheckInputUser checkInputUser;
    DataCollection dataCollection;

    public Controller(){
        checkInputUser = new CheckInputUser();
        dataCollection = new DataCollection();
    }

    public void start(){
        dataCollection.askAllData();
        dataCollection.showInformation();
    }
}
