package up.javafx.game.fx.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import up.javafx.mvc.View;

public class LevelSelectView implements View {

    private final VBox rootNode;
    private final Button btnEasy;
    private final Button btnMedium;
    private final Button btnHard;
    private final Button btnBack;

    public LevelSelectView() {
        this.rootNode = new VBox(20);
        this.rootNode.setAlignment(Pos.CENTER);

        Text title = new Text("Choose Difficulty");
        title.setFont(Font.font("System", FontWeight.BOLD, 30));

        this.btnEasy = new Button("Easy (10x10)");
        this.btnMedium = new Button("Medium (15x15)");
        this.btnHard = new Button("Hard (20x20)");
        this.btnBack = new Button("Back to Main Menu");

        btnEasy.setPrefWidth(250);
        btnMedium.setPrefWidth(250);
        btnHard.setPrefWidth(250);
        btnBack.setPrefWidth(250);

        rootNode.getChildren().addAll(title, btnEasy, btnMedium, btnHard, btnBack);    
    }

    public VBox getRootNode() { return rootNode; }
    public Button getBtnEasy() { return btnEasy; }
    public Button getBtnMedium() { return btnMedium; }
    public Button getBtnHard() { return btnHard; }
    public Button getBtnBack() { return btnBack; }
}