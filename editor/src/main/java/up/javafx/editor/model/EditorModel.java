package up.javafx.editor.model;

import up.javafx.core.io.CellDescriptor;
import up.javafx.core.io.Level;
import up.javafx.core.io.LevelIOException;
import up.javafx.core.io.LevelRepository;
import up.javafx.core.level.cells.CellType;
import up.javafx.editor.dto.EditorSnapshot;
import up.javafx.mvc.Model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EditorModel extends Model {

    private Level level;
    private EditorState currentTool = EditorState.PLACE_EMPTY;
    private boolean unsaved = false;

    public EditorModel(int width, int height) {
        level = Level.empty("untitled", width, height);
    }

    public void newLevel(int width, int height) {
        level   = Level.empty("untitled", width, height);
        unsaved = false;
    }

    public void placeCell(int x, int y, CellType type) {
        List<CellDescriptor> cells = new ArrayList<>(level.cells());
        cells.removeIf(c -> c.x() == x && c.y() == y);
        if (type != CellType.EMPTY)
            cells.add(new CellDescriptor(x, y, type));
        level   = new Level(level.name(), level.width(), level.height(),
                            level.startX(), level.startY(), List.copyOf(cells));
        unsaved = true;
    }

    public void setStartPosition(int x, int y) {
        level   = new Level(level.name(), level.width(), level.height(), x, y, level.cells());
        unsaved = true;
    }

    public void rename(String name) {
        level   = new Level(name, level.width(), level.height(),
                            level.startX(), level.startY(), level.cells());
        unsaved = true;
    }

    public void save(Path path) throws LevelIOException {
        LevelRepository.save(level, path);
        unsaved = false;
    }

    public void load(Path path) throws LevelIOException {
        level   = LevelRepository.load(path);
        unsaved = false;
    }

    public void setCurrentTool(EditorState tool) { currentTool = tool; }

    public EditorSnapshot snapshot() {
        return new EditorSnapshot(level, currentTool, unsaved);
    }

    public Level       getLevel()       { return level; }
    public EditorState getCurrentTool() { return currentTool; }
    public boolean     isUnsaved()      { return unsaved; }
}
