package up.javafx.game.fx.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import up.javafx.game.dto.GameSnapshot;
import up.javafx.mvc.View;
import java.util.function.BiConsumer;

public class GameFxView extends VBox implements View {

    private final Label     statusLabel = new Label("Chargement…");
    private final GridPane  gridPane    = new GridPane();

    private final Button btnBack;
    private final Button upBtn;
    private final Button downBtn;
    private final Button leftBtn;
    private final Button rightBtn;

    private BiConsumer<Integer, Integer> onFlagAction = (c, r) -> {};

    public GameFxView() {
        VBox rootNode = new VBox(15);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setStyle("-fx-padding: 20;");


        this.btnBack = new Button("Retour menu");
        this.upBtn = new Button("↑");
        this.downBtn = new Button("↓");
        this.leftBtn = new Button("←");
        this.rightBtn = new Button("→");

        GridPane controls = new GridPane();
        controls.setAlignment(Pos.CENTER);
        controls.setHgap(10);
        controls.setVgap(10);

        controls.add(upBtn, 1, 0);
        controls.add(leftBtn, 0, 1);
        controls.add(downBtn, 1, 1);
        controls.add(rightBtn, 2, 1);

        
        setSpacing(4);
        rootNode.getChildren().addAll(statusLabel, gridPane , controls, btnBack);
    
        getChildren().add(rootNode);
    }

    public void setOnFlagAction(BiConsumer<Integer, Integer> action) {
        this.onFlagAction = action;
    }

    public void update(GameSnapshot s) {
        statusLabel.setText(String.format("PV : %d/%d   Score : %d   [%s]",
                s.playerHp(), s.playerMaxHp(), s.score(), s.state()));
        gridPane.getChildren().clear();
        var grid = s.grid();

        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getCols(); c++) {
                boolean isPlayer = s.playerPosition().x() == c && s.playerPosition().y() == r;
                CellView cellView = new CellView(grid.getCell(r, c), isPlayer);

                final int col = c;
                final int row = r;
                cellView.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.SECONDARY) {
                        onFlagAction.accept(col, row);
                    }
                });

                gridPane.add(cellView, c, r);
            }
        }
    }

    public Button getUpBtn() { return upBtn; }
    public Button getDownBtn() { return downBtn; }
    public Button getLeftBtn() { return leftBtn; }
    public Button getRightBtn() { return rightBtn; }
    public Button getBtnBack() { return btnBack; }
}
