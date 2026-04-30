package up.javafx.game.fx.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import up.javafx.mvc.View;

public class CharacterSelectView implements View {

    private final VBox rootNode;
    private final Button btnBandit;
    private final Button btnDuchess;
    private final Button btnKnight;
    private final Button btnPaladin;
    private final Button btnBack;

    public CharacterSelectView() {
        this.rootNode = new VBox(30);
        this.rootNode.setAlignment(Pos.CENTER);

        Text title = new Text("Choose Your Hero");
        title.setFont(Font.font("System", FontWeight.BOLD, 30));
        this.btnBandit  = createCharButton("BANDIT\nHP: 10 | ATK: 5");
        this.btnDuchess = createCharButton("DUCHESS\nHP: 4 | ATK: 2");
        this.btnKnight  = createCharButton("KNIGHT\nHP: 4 | ATK: 1");
        this.btnPaladin = createCharButton("PALADIN\nHP: 5 | ATK: 2");

        this.btnBack = new Button("Back to Difficulty");
        this.btnBack.setPrefWidth(200);

        HBox row1 = new HBox(20, btnBandit, btnDuchess);
        row1.setAlignment(Pos.CENTER);
        
        HBox row2 = new HBox(20, btnKnight, btnPaladin);
        row2.setAlignment(Pos.CENTER);

        rootNode.getChildren().addAll(title, row1, row2, btnBack);
    }

    private Button createCharButton(String text) {
        Button btn = new Button(text);
        btn.setPrefSize(200, 100); 
        btn.setStyle("-fx-text-alignment: center; -fx-font-size: 14px; -fx-font-weight: bold;");
        return btn;
    }

    public VBox getRootNode() { return rootNode; }
    public Button getBtnBandit() { return btnBandit; }
    public Button getBtnDuchess() { return btnDuchess; }
    public Button getBtnKnight() { return btnKnight; }
    public Button getBtnPaladin() { return btnPaladin; }
    public Button getBtnBack() { return btnBack; }
}