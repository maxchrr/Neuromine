package up.javafx.game.fx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import up.javafx.game.dto.GameSnapshot;
import up.javafx.mvc.View;
import java.util.function.BiConsumer;

public class GameFxView extends VBox implements View {

    private final Label statusLabel = new Label("Chargement…");
    private final GridPane gridPane = new GridPane();

    private final Button btnBack = new Button("Retour menu");
    private final Button upBtn = new Button("↑");
    private final Button downBtn = new Button("↓");
    private final Button leftBtn = new Button("←");
    private final Button rightBtn = new Button("→");

    
    private final ToggleButton btnModeAttack = new ToggleButton("Attaque");
    private final ToggleButton btnModeFlag = new ToggleButton("Drapeau");

    private BiConsumer<Integer, Integer> onFlagAction = (c, r) -> {};

    public GameFxView() {
        
        this.setAlignment(Pos.TOP_CENTER); 
        this.setSpacing(20);
        this.setPadding(new Insets(15));

       
        HBox topBar = new HBox(btnBack);
        topBar.setAlignment(Pos.CENTER_RIGHT);
        
        
        VBox centerArea = new VBox(15);
        centerArea.setAlignment(Pos.CENTER);
        gridPane.setAlignment(Pos.CENTER);
        centerArea.getChildren().addAll(statusLabel, gridPane);
        
        
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        
        ToggleGroup modeGroup = new ToggleGroup();
        btnModeAttack.setToggleGroup(modeGroup);
        btnModeFlag.setToggleGroup(modeGroup);
        
        
        btnModeAttack.setStyle("-fx-text-fill: red;");
        btnModeFlag.setStyle("-fx-text-fill: blue;");

        
        GridPane controls = new GridPane();
        controls.setAlignment(Pos.CENTER);
        controls.setHgap(10);
        controls.setVgap(10);

        controls.add(upBtn, 1, 0);
        controls.add(leftBtn, 0, 1);
        controls.add(downBtn, 1, 1);
        controls.add(rightBtn, 2, 1);


        HBox boutons = new HBox(15);
        boutons.setAlignment(Pos.CENTER);
        boutons.getChildren().addAll(btnModeAttack, controls, btnModeFlag);
        
        this.getChildren().addAll(topBar, centerArea, spacer, boutons);
    }

    
    public ToggleButton getBtnModeAttack() { return btnModeAttack; }
    public ToggleButton getBtnModeFlag() { return btnModeFlag; }
    public Button getUpBtn() { return upBtn; }
    public Button getDownBtn() { return downBtn; }
    public Button getLeftBtn() { return leftBtn; }
    public Button getRightBtn() { return rightBtn; }
    public Button getBtnBack() { return btnBack; }

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
                    if (event.getButton() == javafx.scene.input.MouseButton.SECONDARY) {
                        onFlagAction.accept(col, row);
                    }
                });
                gridPane.add(cellView, c, r);
            }
        }
    }
}

