package up.javafx.game.fx.view;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import up.javafx.core.level.cells.*;

public class CellView extends StackPane {

    static final int SIZE = 40;

    public CellView(Cell cell, boolean isPlayer) {
        Rectangle rect = new Rectangle(SIZE, SIZE);
        Text      text = new Text();

        if (isPlayer) {
            rect.setFill(Color.DODGERBLUE);
            text.setText("@");
            text.setFill(Color.WHITE);
        } else if (!cell.isRevealed()) {
            rect.setFill(cell.isFlagged() ? Color.YELLOW : Color.DARKGRAY);
            text.setText(cell.isFlagged() ? "F" : "");
        } else {
            rect.setFill(FxRenderer.colorForType(cell.getType()));
            text.setText(switch (cell.getType()) {
                case NUMBER  -> String.valueOf(((NumberCell) cell).getAdjacentMines());
                case MINE    -> "✱";
                case MONSTER -> "M";
                case WALL    -> "▪";
                default      -> "";
            });
        }

        rect.setStroke(Color.GRAY);
        rect.setStrokeWidth(0.5);
        getChildren().addAll(rect, text);
    }
}
