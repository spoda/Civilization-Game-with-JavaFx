package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import view.GridFX;
/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    private Stage window;
    private Scene scene2;
    private StartScreen ss1 = new StartScreen();
    //private GameScreen gs1;

    public void start(Stage primaryStage) {
        //TODO
        window = primaryStage;
        Scene scene1 = new Scene(ss1, 1000, 1000);
        startGame();
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        //TODO
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {
        //TODO
        Button tempbut = ss1.getStartButton();
        tempbut.setOnMouseClicked(e -> {
                System.out.println("onclick");
                buttonClick();
            });
        return scene2;
    }

    public void buttonClick() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("First Settlement Name");
        dialog.setHeaderText("Choose a Settlement Name");
        dialog.setContentText("Please enter your Settlement Name:");

        Optional<String> civresult = dialog.showAndWait();
        if (civresult.isPresent()) {
            String temp = civresult.get();

            if (ss1.getCivList().getSelectionModel().getSelectedItem()
                == CivEnum.ANCIENT_EGYPT) {
                Egypt egyptciv = new Egypt();
                GameController.setCivilization(egyptciv);
                GridFX.getMap().putSettlement(temp, egyptciv, 0, 9);
            } else if (ss1.getCivList().getSelectionModel().getSelectedItem()
                == CivEnum.ROMAN_EMPIRE) {
                RomanEmpire reciv = new RomanEmpire();
                GameController.setCivilization(reciv);
                GridFX.getMap().putSettlement(temp, reciv, 0, 9);
            } else if (ss1.getCivList().getSelectionModel().getSelectedItem()
                == CivEnum.QIN_DYNASTY) {
                QinDynasty qdciv = new QinDynasty();
                GameController.setCivilization(qdciv);
                GridFX.getMap().putSettlement(temp, qdciv, 0, 9);
            }

            GameScreen gs1 = new GameScreen();
            scene2 = new Scene(gs1, 1000, 1000);
            window.setScene(scene2);
            Bandit bandit = new Bandit();
            GameController.setBandits(bandit);
            Map.addEnemies(bandit, 1);
            gs1.update();
        }
    }




}
