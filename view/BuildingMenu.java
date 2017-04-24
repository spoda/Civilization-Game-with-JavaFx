package view;

import controller.GameController;
import model.Building;
import model.Settlement;
//import model.Treasury;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    private Button investButton = new Button("Invest");
    private Button demolishButton = new Button("Demolish");
    public BuildingMenu() {
        //TODO
        super.addMenuItem(investButton);
        super.addMenuItem(demolishButton);
        int canInvest
            = GameController.getCivilization().getTreasury().getCoins();
        investButton.setOnMouseClicked(e -> {
                if (canInvest >= 25) {
                    ((Building) (GameController.getLastClicked()
                        .getTile().getOccupant())).invest();
                    GameController.getCivilization().getTreasury().spend(25);
                } else {
                    Alert newAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    newAlert.setHeaderText("Warning");
                    newAlert.setTitle("Not Enough Gold");
                    newAlert.showAndWait();
                    System.exit(0);
                }
                GameController.updateResourcesBar();
            });

        demolishButton.setOnMouseClicked(e -> {
                int checkNumSettlement
                    = GameController.getCivilization().getNumSettlements();
                if (checkNumSettlement >= 1
                    && (GameController.getLastClicked()
                        .getTile().getOccupant()) instanceof Settlement) {
                    GameController.getLastClicked().getTile().setOccupant(null);
                    GameController.getCivilization().decrementNumSettlements();
                }
                GameController.getLastClicked().getTile().setOccupant(null);
            });

    }
}
