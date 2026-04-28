package up.javafx.core.level;

import up.javafx.core.level.cells.*;
import up.javafx.core.level.mine.NormalMine;

import java.util.Random;

public class LevelGenerator {

    private static final Random RNG = new Random();

    public static Grid generateLevel(int size, int numMines) {
        Grid grid = new Grid(size, size);

        for (int r = 0; r < size; r++)
            for (int c = 0; c < size; c++)
                grid.setCell(r, c, new EmptyCell(new Position(c, r)));

        int placed = 0;
        while (placed < numMines) {
            int r = RNG.nextInt(size);
            int c = RNG.nextInt(size);
            if (grid.getCell(r, c).getType() == CellType.EMPTY && !isCorner(r, c, size)) {
                grid.setCell(r, c, new MineCell(new Position(c, r), new NormalMine()));
                placed++;
            }
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid.getCell(r, c).getType() == CellType.EMPTY) {
                    int count = countAdjacentMines(grid, r, c);
                    if (count > 0)
                        grid.setCell(r, c, new NumberCell(new Position(c, r), count, 0));
                }
            }
        }
        return grid;
    }

    private static boolean isCorner(int r, int c, int size) {
        return (r == 0 || r == size - 1) && (c == 0 || c == size - 1);
    }

    public static int countAdjacentMines(Grid grid, int row, int col) {
        int count = 0;
        for (int dr = -1; dr <= 1; dr++)
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                int nr = row + dr, nc = col + dc;
                if (grid.isInside(nr, nc) && grid.getCell(nr, nc).getType() == CellType.MINE)
                    count++;
            }
        return count;
    }
}
