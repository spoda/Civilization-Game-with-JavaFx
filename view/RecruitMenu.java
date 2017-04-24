package view;

import controller.GameController;
//import model.Civilization;
import java.lang.Object;
import model.Unit;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import model.SettlerUnit;
import model.FarmerUnit;
import model.MasterBuilderUnit;
import javafx.scene.control.Alert;
/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    private ObservableList<String> names = FXCollections.observableArrayList(
           "Melee Unit", "Ranged Unit", "Hybrid Unit", "Siege Unit",
           "Settlers", "Farmers", "Coal Miners", "Angelers", "Master Builders");
    private Button selectButton = new Button("Select");
    private static int settlementnum = 2;
    private static String settlerstring = "Settlement" + settlementnum;

    public RecruitMenu() {
        //TODO
        ListView<String> list = new ListView<String>(names);
        super.addMenuItem(list);
        super.addMenuItem(selectButton);
        selectButton.setOnMouseClicked(e -> {
                String unitString = list.getSelectionModel().getSelectedItem();
                if (unitString.equals("Melee Unit")) {
                    boolean afford = ((Unit) (GameController.getCivilization()
                        .getMeleeUnit())).isAffordable();
                    if (afford) {
                        ((Unit) (GameController.getCivilization()
                            .getMeleeUnit())).applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            GameController.getCivilization().getMeleeUnit());
                        GameController.getLastClicked().updateTileView();
                    } else {
                        Alert newAlert = new Alert(
                            Alert.AlertType.CONFIRMATION);
                        newAlert.setHeaderText("Warning");
                        newAlert.setTitle("Not Enough Resources");
                        newAlert.showAndWait();
                    }
                }

                if (unitString.equals("Ranged Unit")) {
                    boolean afford = ((Unit) (GameController.getCivilization()
                        .getRangedUnit())).isAffordable();
                    if (afford) {
                        ((Unit) (GameController.getCivilization()
                            .getRangedUnit())).applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            GameController.getCivilization().getRangedUnit());
                        GameController.getLastClicked().updateTileView();
                    } else {
                        Alert newAlert = new Alert(
                            Alert.AlertType.CONFIRMATION);
                        newAlert.setHeaderText("Warning");
                        newAlert.setTitle("Not Enough Resources");
                        newAlert.showAndWait();
                    }
                }

                if (unitString.equals("Hybrid Unit")) {
                    boolean afford = ((Unit) (GameController.getCivilization()
                        .getHybridUnit())).isAffordable();
                    if (afford) {
                        ((Unit) (GameController.getCivilization()
                            .getHybridUnit())).applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            GameController.getCivilization().getHybridUnit());
                        GameController.getLastClicked().updateTileView();
                    } else {
                        Alert newAlert = new Alert(
                            Alert.AlertType.CONFIRMATION);
                        newAlert.setHeaderText("Warning");
                        newAlert.setTitle("Not Enough Resources");
                        newAlert.showAndWait();
                    }
                }
                if (unitString.equals("Siege Unit")) {
                    boolean afford = ((Unit) (GameController.getCivilization()
                        .getSiegeUnit())).isAffordable();
                    if (afford) {
                        ((Unit) (GameController.getCivilization()
                            .getSiegeUnit())).applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            GameController.getCivilization().getSiegeUnit());
                        GameController.getLastClicked().updateTileView();
                    } else {
                        Alert newAlert = new Alert(
                            Alert.AlertType.CONFIRMATION);
                        newAlert.setHeaderText("Warning");
                        newAlert.setTitle("Not Enough Resources");
                        newAlert.showAndWait();
                    }
                }

                if (unitString.equals("Settlers")) {
                    SettlerUnit seunit = new SettlerUnit(
                        GameController.getCivilization(), settlerstring);
                    boolean afford = seunit.isAffordable();
                    if (afford) {
                        seunit.applyInitialCosts();
                        GameController.getLastClicked()
                        .getTile().setOccupant(seunit);
                        GameController.getLastClicked().updateTileView();
                    } else {
                        Alert newAlert = new Alert(
                            Alert.AlertType.CONFIRMATION);
                        newAlert.setHeaderText("Warning");
                        newAlert.setTitle("Not Enough Resources");
                        newAlert.showAndWait();
                    }
                }
                if (unitString.equals("Farmers")) {
                    FarmerUnit funit = new FarmerUnit(
                        GameController.getCivilization());
                    boolean afford = funit.isAffordable();
                    if (afford) {
                        funit.applyInitialCosts();
                        GameController.getLastClicked()
                        .getTile().setOccupant(funit);
                        GameController.getLastClicked().updateTileView();
                    } else {
                        Alert newAlert = new Alert(
                            Alert.AlertType.CONFIRMATION);
                        newAlert.setHeaderText("Warning");
                        newAlert.setTitle("Not Enough Resources");
                        newAlert.showAndWait();
                    }
                }
                if (unitString.equals("Coal Miners")) {
                    boolean afford = ((Unit) (GameController.getCivilization()
                        .getCoalMinerUnit())).isAffordable();
                    if (afford) {
                        ((Unit) (GameController.getCivilization()
                            .getCoalMinerUnit())).applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            GameController.getCivilization()
                            .getCoalMinerUnit());
                        GameController.getLastClicked().updateTileView();
                    } else {
                        Alert newAlert = new Alert(
                            Alert.AlertType.CONFIRMATION);
                        newAlert.setHeaderText("Warning");
                        newAlert.setTitle("Not Enough Resources");
                        newAlert.showAndWait();
                    }
                }
                if (unitString.equals("Angelers")) {
                    boolean afford = ((Unit) (GameController.getCivilization()
                        .getAnglerUnit())).isAffordable();
                    if (afford) {
                        ((Unit) (GameController.getCivilization()
                            .getAnglerUnit())).applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            GameController.getCivilization().getAnglerUnit());
                        GameController.getLastClicked().updateTileView();
                    } else {
                        Alert newAlert = new Alert(
                            Alert.AlertType.CONFIRMATION);
                        newAlert.setHeaderText("Warning");
                        newAlert.setTitle("Not Enough Resources");
                        newAlert.showAndWait();
                    }
                }
                if (unitString.equals("Master Builders")) {
                    MasterBuilderUnit maunit = new MasterBuilderUnit(
                        GameController.getCivilization());
                    boolean afford = maunit.isAffordable();
                    if (afford) {
                        maunit.applyInitialCosts();
                        GameController.getLastClicked()
                        .getTile().setOccupant(maunit);
                        GameController.getLastClicked().updateTileView();
                    } else {
                        Alert newAlert = new Alert(
                            Alert.AlertType.CONFIRMATION);
                        newAlert.setHeaderText("Warning");
                        newAlert.setTitle("Not Enough Resources");
                        newAlert.showAndWait();
                    }
                }
            });
        GameController.updateResourcesBar();
    }
}
