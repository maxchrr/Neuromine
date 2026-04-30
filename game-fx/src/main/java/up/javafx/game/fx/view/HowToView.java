package up.javafx.game.fx.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import up.javafx.mvc.View;

public class HowToView implements View {
    private final VBox rootNode;
    private final Button btnBack;

    public HowToView() {
        this.rootNode = new VBox(20);
        this.rootNode.setAlignment(Pos.CENTER);
        this.rootNode.setStyle("-fx-background-color: #2c3e50; -fx-padding: 40;");

        Text title = new Text("HOW TO PLAY");
        title.setFont(Font.font("System", FontWeight.BOLD, 30));
        title.setFill(javafx.scene.paint.Color.WHITE);

        Text instructions = new Text(
            " CONTROLES\n\n" +
            "• MOVE : ZQSD\n" +
            "• ATTACK : SHIFT + ARROW KEYS\n" +
            "• PLACE FLAG : CTRL + ZQSD\n\n" +
            "OBJECTIVE\n\n" +
            "Be careful: monsters are hidden and mines\n" +
            "will explode if you step on them.\n" +
            "Use the numbers to locate the danger."
        );
        instructions.setFont(Font.font("System", 18));
        instructions.setFill(javafx.scene.paint.Color.LIGHTGRAY);
        instructions.setTextAlignment(TextAlignment.CENTER);

        this.btnBack = new Button("Back to Menu");
        this.btnBack.setPrefWidth(150);

        rootNode.getChildren().addAll(title, instructions, btnBack);
    }

    public VBox getRootNode() { return rootNode; }
    public Button getBtnBack() { return btnBack; }
}