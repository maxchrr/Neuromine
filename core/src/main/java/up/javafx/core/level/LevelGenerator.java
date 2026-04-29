package up.javafx.core.level;

import up.javafx.core.level.cells.*;
import up.javafx.core.level.mine.NormalMine;
import up.javafx.core.entity.enemy.SkeletonEnemy;
import java.util.Random;

public class LevelGenerator {

    public static Grid generateLevel(int n, int numMines, int numEnemies) {
        Grid grid = new Grid(n, n);
        Random random = new Random();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                grid.setCell(r, c, new EmptyCell(new Position(c, r)));
            }
        }

        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int r = random.nextInt(n);
            int c = random.nextInt(n);
            if (!(grid.getCell(r, c) instanceof MineCell)) {
                grid.setCell(r, c, new MineCell(new Position(c, r), new NormalMine()));
                minesPlaced++;
            }
        }

        int enemiesPlaced = 0;
        while (enemiesPlaced < numEnemies) {
            int r = random.nextInt(n);
            int c = random.nextInt(n);
            Cell currentCell = grid.getCell(r, c);
            if (!(currentCell instanceof MineCell) && !(currentCell instanceof EnemyCell)) {
                Position pos = new Position(c, r);
                grid.setCell(r, c, new EnemyCell(pos, new SkeletonEnemy(pos)));
                enemiesPlaced++;
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                Cell cell = grid.getCell(r, c);
                if (cell instanceof MineCell || cell instanceof EnemyCell) continue;

                int mineCount = countAdjacentMines(grid, r, c);
                int monsterCount = countAdjacentMonsters(grid, r, c);

                if (mineCount > 0 || monsterCount > 0) {
                    // On utilise TON vrai constructeur ici :
                    grid.setCell(r, c, new NumberCell(new Position(c, r), mineCount, monsterCount));
                }
            }
        }

        return grid;
    }

    private static int countAdjacentMines(Grid grid, int row, int col) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (grid.isInside(r, c) && grid.getCell(r, c) instanceof MineCell) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countAdjacentMonsters(Grid grid, int row, int col) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (grid.isInside(r, c) && grid.getCell(r, c) instanceof EnemyCell) {
                    count++;
                }
            }
        }
        return count;
    }
}