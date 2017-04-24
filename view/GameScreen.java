package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {


    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    private GridFX gridfx =  GridFX.getInstance();
    private static ResourcesMenu remenu;
    private static StatusMenu smenu;
    private static MilitaryMenu mmenu;
    private static WorkerMenu wmenu;
    private static RecruitMenu rmenu;
    private static BuildingMenu bmenu;
    private static VBox vbox = new VBox();

    public GameScreen() {
        //TODO
        remenu = new ResourcesMenu();
        smenu = new StatusMenu();
        vbox.getChildren().setAll(smenu.getRootNode());
        this.setCenter(gridfx);
        this.setTop(remenu.getRootNode());
        this.setLeft(vbox);
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
      //TODO
        gridfx.update();
        getResources().update();
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        //TODO
        return remenu;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
       //TODO
        switch (state) {

        case MILITARY:
            vbox.getChildren().clear();
            vbox.getChildren().setAll(new MilitaryMenu().getRootNode());
            break;
        case WORKER:
            vbox.getChildren().clear();
            vbox.getChildren().setAll(new WorkerMenu().getRootNode());
            break;
        case RECRUITING:
            vbox.getChildren().clear();
            vbox.getChildren().setAll(new RecruitMenu().getRootNode());
            break;
        case BUILDING:
            vbox.getChildren().clear();
            vbox.getChildren().setAll(new BuildingMenu().getRootNode());
            break;
        default:
            vbox.getChildren().clear();
            vbox.getChildren().setAll(smenu.getRootNode());
            break;
        }

    }
}
