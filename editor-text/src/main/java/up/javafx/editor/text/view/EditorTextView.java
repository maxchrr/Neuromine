package up.javafx.editor.text.view;

import up.javafx.core.io.CellDescriptor;
import up.javafx.core.level.cells.CellType;
import up.javafx.editor.dto.EditorSnapshot;
import up.javafx.mvc.View;

import java.util.Arrays;

public class EditorTextView implements View {

    public void render(EditorSnapshot s) {
        var level = s.level();
        System.out.printf("=== %s (%dx%d) [outil: %s]%s ===%n",
                level.name(), level.width(), level.height(),
                s.currentTool(),
                s.hasUnsavedChanges() ? " *" : "");

        char[][] grid = new char[level.height()][level.width()];
        for (char[] row : grid) Arrays.fill(row, '.');
        grid[level.startY()][level.startX()] = 'S';

        for (CellDescriptor cd : level.cells()) {
            if (cd.y() < level.height() && cd.x() < level.width())
                grid[cd.y()][cd.x()] = charFor(cd.type());
        }
        for (char[] row : grid) System.out.println(new String(row));
        System.out.println();
    }

    private char charFor(CellType t) {
        return switch (t) {
            case MINE    -> '*';
            case MONSTER -> 'M';
            case WALL    -> '#';
            default      -> '.';
        };
    }
}
