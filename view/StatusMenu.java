package view;
import javafx.scene.layout.VBox;
public class StatusMenu extends AbstractMenu {
    /**
     * Concerte implementation of abstract menu, could be useful for
     * other unit information
     */
    private VBox vbox = new VBox();
    public StatusMenu() {
        //TODO
        vbox = super.getRootNode();
    }
}
