package up.javafx.core.engine;

import up.javafx.core.engine.systems.CombatSystem;
import up.javafx.core.engine.systems.GameState;
import up.javafx.core.engine.systems.MineSystem;
import up.javafx.core.engine.systems.MovementSystem;
import up.javafx.core.engine.systems.RevealSystem;
import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Direction;
import up.javafx.core.level.Grid;
import up.javafx.core.level.Position;
import up.javafx.core.level.cells.Cell;
import up.javafx.core.level.cells.EnemyCell;
import up.javafx.core.level.cells.MineCell;

public class GameEngine {

	private Grid grid;
	private Player player;

	private MovementSystem movementSystem;
	private CombatSystem combatSystem;
	private RevealSystem revealSystem;
	private MineSystem mineSystem;

	private GameState state = GameState.RUNNING;

	public GameEngine(Grid grid, Player player) {
		this.grid = grid;
		this.player = player;

		this.movementSystem = new MovementSystem();
		this.combatSystem = new CombatSystem();
		this.revealSystem = new RevealSystem();
		this.mineSystem = new MineSystem();
	}

	public void movePlayer(Direction dir) {
		if (state != GameState.RUNNING) return;

		movementSystem.move(player, dir, grid);
		resolveCell();
	}

	private void resolveCell() {
		Position pos = player.getPosition();
		Cell cell = grid.getCell(pos.x(), pos.y());

		if (!cell.isRevealed())
			revealSystem.reveal(cell, grid);

		switch (cell.getType()) {
			case MONSTER -> combatSystem.fight(player, ((EnemyCell) cell).getEnemy());
			case MINE -> mineSystem.trigger(player, ((MineCell) cell).getMine());
			default -> {
			}
		}
	}
}
