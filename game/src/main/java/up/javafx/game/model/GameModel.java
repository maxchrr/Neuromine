package up.javafx.game.model;

import up.javafx.core.engine.GameEngine;
import up.javafx.core.engine.systems.GameState;
import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Direction;
import up.javafx.core.level.Grid;
import up.javafx.game.dto.GameSnapshot;
import up.javafx.mvc.Model;
import up.javafx.core.level.cells.CellType;

public class GameModel extends Model {

    private final GameEngine engine;
    private int score = 0;

    public GameModel(Grid grid, Player player) {
        engine = new GameEngine(grid, player);
    }

    public void move(Direction dir) { engine.movePlayer(dir); }

    // Dans GameModel.java

    public void toggleFlag(int col, int row) {
        var grid = engine.getGrid(); 
        var cell = grid.getCell(row, col); 
        
        
        boolean wasFlagged = cell.isFlagged();
        boolean isMine = cell.getType() == CellType.MINE;
        
        cell.toggleFlag(); 

        if (!wasFlagged && cell.isFlagged() && isMine) {
            addScore(10); 
        } else if (wasFlagged && !cell.isFlagged() && isMine) {
            addScore(-10); 
        }

        
        if (checkVictory()) {
            engine.setState(GameState.VICTORY); 
        }
    }

    private boolean checkVictory() {
        var grid = engine.getGrid(); //[cite: 6]
        int totalMines = 0;
        int flaggedMines = 0;

        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getCols(); c++) {
                var cell = grid.getCell(r, c); //[cite: 6]
                if (cell.getType() == CellType.MINE) {
                    totalMines++;
                    if (cell.isFlagged()) {
                        flaggedMines++;
                    }
                } else if (cell.isFlagged()) {
                    // Optionnel : Si un drapeau est sur une case vide, ce n'est pas encore une victoire parfaite
                    return false; 
                }
            }
        }
        return totalMines > 0 && flaggedMines == totalMines;
    }

    public GameSnapshot snapshot() {
        return new GameSnapshot(
                engine.getGrid(),
                engine.getPlayer().getPosition(),
                engine.getPlayer().getHp(),
                engine.getPlayer().getMaxHp(),
                score,
                engine.getState()
        );
    }

    public void addScore(int points) { score += points; }
    public int  getScore()           { return score; }
    public boolean isRunning()       { return engine.getState() == GameState.RUNNING; }
    public void attackCell(int x, int y) { engine.attackCell(x, y); }
}
