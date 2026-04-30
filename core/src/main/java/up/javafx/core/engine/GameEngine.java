package up.javafx.core.engine;

import up.javafx.core.engine.systems.*;
import up.javafx.core.entity.enemy.Enemy;
import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Direction;
import up.javafx.core.level.Grid;
import up.javafx.core.level.Position;
import up.javafx.core.level.cells.*;

public class GameEngine {

    private final Grid grid;
    private final Player player;
    private final MovementSystem movementSystem = new MovementSystem();
    private final CombatSystem   combatSystem   = new CombatSystem();
    private final RevealSystem   revealSystem   = new RevealSystem();
    private final MineSystem     mineSystem     = new MineSystem();
    private GameState state = GameState.RUNNING;

    public GameEngine(Grid grid, Player player) {
        this.grid   = grid;
        this.player = player;
    }

    public void movePlayer(Direction dir) {
        if (state != GameState.RUNNING) return;
        if (!movementSystem.move(player, dir, grid)) return;
        resolveCell();
    }

    private void resolveCell() {
        Position pos  = player.getPosition();
        Cell cell = grid.getCell(pos.y(), pos.x());

        if (cell.isFlagged()) {
            return;
        }

        cell.reveal();
        switch (cell.getType()) {
            case MINE    -> mineSystem.trigger(player, (MineCell) cell);
            case MONSTER -> {
                Enemy enemy = ((EnemyCell) cell).getEnemy();
                
                if (enemy.isAlive()) {
                    player.takeDamage(enemy.getAttack());
                }
            }
            case EMPTY   -> revealSystem.reveal(grid, pos.y(), pos.x());
            default      -> {}
        }
        if (!player.isAlive()) state = GameState.GAME_OVER;
    }

    public void attackCell(int x, int y) {
        if (state != GameState.RUNNING || !grid.isInside(y, x)) return;
        
        Cell cell = grid.getCell(y, x);
        
        if (cell instanceof EnemyCell enemyCell) {
            combatSystem.fight(player, enemyCell.getEnemy());
            cell.reveal();

            if (!player.isAlive()) state = GameState.GAME_OVER; 
        } 
    }

    public Grid      getGrid()   { return grid; }
    public Player    getPlayer() { return player; }
    public GameState getState()  { return state; }

    public void setState(GameState state) {
        this.state = state;
    }
}
