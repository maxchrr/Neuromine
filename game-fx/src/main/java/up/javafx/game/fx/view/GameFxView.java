package up.javafx.game.fx.view;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import up.javafx.game.dto.GameSnapshot;
import up.javafx.mvc.View;

public class GameFxView extends VBox implements View {

    private final Label     statusLabel = new Label("Chargement…");
    private final GridPane  gridPane    = new GridPane();

    public GameFxView() {
        setSpacing(4);
        getChildren().addAll(statusLabel, gridPane);
    }

    public void update(GameSnapshot s) {
        statusLabel.setText(String.format("PV : %d/%d   Score : %d   [%s]",
                s.playerHp(), s.playerMaxHp(), s.score(), s.state()));
        gridPane.getChildren().clear();
        var grid = s.grid();
        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getCols(); c++) {
                boolean isPlayer = s.playerPosition().x() == c && s.playerPosition().y() == r;
                gridPane.add(new CellView(grid.getCell(r, c), isPlayer), c, r);
            }
        }
    }
}
