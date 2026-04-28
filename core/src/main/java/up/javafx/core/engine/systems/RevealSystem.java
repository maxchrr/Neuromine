package up.javafx.core.engine.systems;

import up.javafx.core.level.Grid;
import up.javafx.core.level.cells.Cell;
import up.javafx.core.level.cells.CellType;

public class RevealSystem {

    public void reveal(Grid grid, int row, int col) {
        if (!grid.isInside(row, col)) return;
        Cell cell = grid.getCell(row, col);
        if (cell.isRevealed() || cell.isFlagged()) return;
        cell.reveal();
        if (cell.getType() == CellType.EMPTY) {
            for (int dr = -1; dr <= 1; dr++)
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0) continue;
                    reveal(grid, row + dr, col + dc);
                }
        }
    }
}
