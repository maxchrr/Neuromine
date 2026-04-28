package up.javafx.editor.controller;

import up.javafx.core.io.LevelIOException;
import up.javafx.core.level.cells.CellType;
import up.javafx.editor.dto.EditorSnapshot;
import up.javafx.editor.model.EditorModel;
import up.javafx.editor.model.EditorState;
import up.javafx.mvc.Controller;
import up.javafx.mvc.View;

import java.nio.file.Path;

public class EditorController extends Controller<EditorModel, View> {

    private Runnable onUpdate = () -> {};

    public EditorController(EditorModel model, View view) {
        super(model, view);
    }

    @Override protected void init() {}

    public void setOnUpdate(Runnable r) { onUpdate = r; }

    public void handlePlace(int x, int y, CellType type) {
        model.placeCell(x, y, type);
        onUpdate.run();
    }

    public void handleToolChange(EditorState tool) {
        model.setCurrentTool(tool);
        onUpdate.run();
    }

    public void handleNew(int width, int height) {
        model.newLevel(width, height);
        onUpdate.run();
    }

    public void handleSave(Path path) throws LevelIOException {
        model.save(path);
        onUpdate.run();
    }

    public void handleLoad(Path path) throws LevelIOException {
        model.load(path);
        onUpdate.run();
    }

    public EditorSnapshot snapshot() { return model.snapshot(); }
}
