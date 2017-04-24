package view;



import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
//import model.Civilization;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    private Button button1 = new Button("START");
    private ListView<CivEnum> listView = new ListView<CivEnum>();

    public StartScreen() {
        //TODO
        Image image1 = new Image(
            "File:./src/main/java/view/civ_background.png");
        ImageView iv1 = new ImageView();
        iv1.setImage(image1);
        VBox vbox = new VBox();
        ObservableList<CivEnum> civs = FXCollections.observableArrayList(
            CivEnum.ANCIENT_EGYPT, CivEnum.QIN_DYNASTY, CivEnum.ROMAN_EMPIRE);
        listView.getItems().addAll(civs);
        vbox.getChildren().addAll(getCivList(), getStartButton());
        vbox.setMaxWidth(250);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        this.getChildren().addAll(iv1, vbox);
    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        //TODO
        return button1;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        //TODO
        return listView;
    }

}