package up.javafx.game.fx.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import up.javafx.mvc.View;

public class MainMenuView extends VBox implements View {

    private final Button btnPlay;
    private final Button btnSettings;
    private final Button btnQuit;
    private final Button btnHowTo;

    public MainMenuView() {
        setSpacing(20);
        setAlignment(Pos.CENTER);

        Label title = new Label("NEUROMINE");
        title.setFont(Font.font("System", FontWeight.BOLD, 36));

        this.btnPlay = new Button("Play");
        this.btnPlay.setPrefWidth(150);

        this.btnSettings = new Button("Settings");
        this.btnSettings.setPrefWidth(150);

        this.btnQuit = new Button("Quit");
        this.btnQuit.setPrefWidth(150);

        this.btnHowTo = new Button("How to Play");
        this.btnHowTo.setPrefWidth(150);

        getChildren().addAll(title, btnPlay, btnSettings,btnHowTo, btnQuit);
    }

    public Button getBtnPlay() {
        return btnPlay;
    }

    public Button getBtnSettings() {
        return btnSettings;
    }

    public Button getBtnQuit() {
        return btnQuit;
    }

    public Button getBtnHowTo() { 
        return btnHowTo; 
    }
}
