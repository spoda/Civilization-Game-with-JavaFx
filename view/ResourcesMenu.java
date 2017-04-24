package view;

import controller.GameController;
//import model.Strategy;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
//import model.Civilization;
//import model.Treasury;

public class ResourcesMenu {

    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    //Civilization civ = GameController.getCivilization();
    private int strategylevel;
    private int resources;
    private int numsettlement;
    private int money;
    private int food;
    private int happiness;
    private HBox hbox = new HBox();

    public ResourcesMenu() {
        //TODO
        hbox = getRootNode();
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
       // if (GameController.getCivilization() != null) {
        strategylevel
            = GameController.getCivilization().getStrategy().getStrategyLevel();
        resources = GameController.getCivilization().getResources();
        numsettlement = GameController.getCivilization().getNumSettlements();
        money = GameController.getCivilization().getTreasury().getCoins();
        food = GameController.getCivilization().getFood();
        happiness = GameController.getCivilization().getHappiness();
        Text tstrat = new Text("Strat Level: " + strategylevel + " ");
        Text tresource = new Text("Resources: " + resources + " ");
        Text tsettlements = new Text("Settlement: " + numsettlement + " ");
        Text tmoney = new Text("Money: " + money + " ");
        Text tfood = new Text("Food: " + food + " ");
        Text thappiness = new Text("Happiness: " + happiness + " ");
        hbox.getChildren().clear();
        hbox.getChildren().addAll(
            tstrat, tresource, tsettlements, tmoney, tfood, thappiness);
    //}
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        //TODO
        update();
        return hbox;
    }
}