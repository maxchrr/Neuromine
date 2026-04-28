package up.javafx.game.fx.view;

import javafx.scene.paint.Color;
import up.javafx.core.level.cells.CellType;

public class FxRenderer {

    public static Color colorForType(CellType type) {
        return switch (type) {
            case EMPTY   -> Color.LIGHTGRAY;
            case MINE    -> Color.CRIMSON;
            case MONSTER -> Color.DARKORANGE;
            case NUMBER  -> Color.WHITESMOKE;
            case WALL    -> Color.DIMGRAY;
        };
    }
}
