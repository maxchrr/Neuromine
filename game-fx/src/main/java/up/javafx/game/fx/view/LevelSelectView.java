package up.javafx.game.fx.view;

import java.util.stream.Stream;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import up.javafx.mvc.View;

public class LevelSelectView extends VBox implements View {

    private final Button btnEasy;
    private final Button btnMedium;
    private final Button btnHard;
    private final Button btnLoadCustom;
    private final Button btnBack;

    public LevelSelectView() {
        super(20);
        this.setAlignment(Pos.CENTER);

        Text title = new Text("Choose Difficulty");
        title.setFont(Font.font("System", FontWeight.BOLD, 30));

        this.btnEasy = new Button("Easy (8x8 | 15 Mines | 5 Monsters)");
        this.btnMedium = new Button("Medium (10x10 | 30 Mines | 10 Monsters)");
        this.btnHard = new Button("Hard (12x12 | 60 Mines | 20 Monsters)");
        this.btnLoadCustom = new Button("Load Custom Level (.json)");
        this.btnBack = new Button("Back to Main Menu");

        
        Stream.of(btnEasy, btnMedium, btnHard, btnLoadCustom, btnBack)
              .forEach(b -> b.setPrefWidth(300));

        this.getChildren().addAll(title, btnEasy, btnMedium, btnHard, btnLoadCustom, btnBack);    
    }

    public Button getBtnEasy() { return btnEasy; }
    public Button getBtnMedium() { return btnMedium; }
    public Button getBtnHard() { return btnHard; }
    public Button getBtnLoadCustom() { return btnLoadCustom; }
    public Button getBtnBack() { return btnBack; }
}