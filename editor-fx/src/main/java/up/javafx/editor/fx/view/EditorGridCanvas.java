package up.javafx.editor.fx.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import up.javafx.core.io.CellDescriptor;
import up.javafx.core.level.cells.CellType;
import up.javafx.editor.controller.EditorController;
import up.javafx.editor.dto.EditorSnapshot;

public class EditorGridCanvas extends Pane {

    private static final int CELL = 40;
    private final Canvas canvas = new Canvas();
    private EditorController controller;

    public EditorGridCanvas() {
        getChildren().add(canvas);
        canvas.setOnMouseClicked(e -> {
            if (controller == null) return;
            int x = (int) (e.getX() / CELL);
            int y = (int) (e.getY() / CELL);
            CellType type = switch (controller.snapshot().currentTool()) {
                case PLACE_MINE   -> CellType.MINE;
                case PLACE_ENEMY  -> CellType.MONSTER;
                case PLACE_WALL   -> CellType.WALL;
                case ERASE, PLACE_EMPTY -> CellType.EMPTY;
                default           -> CellType.EMPTY;
            };
            controller.handlePlace(x, y, type);
        });
    }

    public void setController(EditorController c) { controller = c; }

    public void render(EditorSnapshot s) {
        var level = s.level();
        double w = level.width()  * CELL;
        double h = level.height() * CELL;
        canvas.setWidth(w);
        canvas.setHeight(h);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, w, h);

        for (CellDescriptor cd : level.cells()) {
            gc.setFill(colorFor(cd.type()));
            gc.fillRect(cd.x() * CELL + 1, cd.y() * CELL + 1, CELL - 2, CELL - 2);
        }

        gc.setStroke(Color.GRAY);
        gc.setLineWidth(0.5);
        for (int col = 0; col <= level.width();  col++) gc.strokeLine(col * CELL, 0, col * CELL, h);
        for (int row = 0; row <= level.height(); row++) gc.strokeLine(0, row * CELL, w, row * CELL);

        gc.setFill(Color.LIMEGREEN);
        gc.fillOval(level.startX() * CELL + 12, level.startY() * CELL + 12, 16, 16);
    }

    private Color colorFor(CellType t) {
        return switch (t) {
            case MINE    -> Color.CRIMSON;
            case MONSTER -> Color.DARKORANGE;
            case WALL    -> Color.DIMGRAY;
            default      -> Color.LIGHTBLUE;
        };
    }
}
