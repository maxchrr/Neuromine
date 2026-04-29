package up.javafx.game.model;

import up.javafx.core.engine.GameEngine;
import up.javafx.core.engine.systems.GameState;
import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Direction;
import up.javafx.core.level.Grid;
import up.javafx.game.dto.GameSnapshot;
import up.javafx.mvc.Model;

public class GameModel extends Model {

    private final GameEngine engine;
    private int score = 0;

    public GameModel(Grid grid, Player player) {
        engine = new GameEngine(grid, player);
    }

    public void move(Direction dir) { engine.movePlayer(dir); }

    public void toggleFlag(int col, int row) {
        engine.getGrid().getCell(row, col).toggleFlag(); 
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
