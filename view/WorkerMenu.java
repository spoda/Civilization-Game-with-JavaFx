package view;

import controller.GameController;
import model.Convertable;
//import model.MapObject;
//import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    private Button moveButton = new Button("Move");
    private Button convertButton = new Button("Convert");
    public WorkerMenu() {
        //TODO
        super.addMenuItem(moveButton);
        super.addMenuItem(convertButton);
        moveButton.setOnMouseClicked(e -> {
                GameController.moving();
            });

        convertButton.setOnMouseClicked(e-> {
                boolean test = ((Convertable) (GameController.getLastClicked()
                    .getTile().getOccupant())).canConvert(
                    GameController.getLastClicked().getTile().getType());
                if (test) {
                    GameController.getLastClicked().getTile().setOccupant(
                        ((Convertable) (GameController.getLastClicked()
                            .getTile().getOccupant())).convert());
                    GameController.getLastClicked().updateTileView();
                } else {
                    Alert newAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    newAlert.setHeaderText("Can't Convert Tile");
                    newAlert.setTitle("Warning");
                    newAlert.showAndWait();
                }
            });
        GameController.updateResourcesBar();
    }
}
