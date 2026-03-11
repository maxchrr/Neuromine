package up.javafx.core.level.cells;

import up.javafx.core.entity.enemy.Enemy;
import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Position;

/**
 * A cell containing a monster.
 * Revealing this cell may trigger a combat encounter.
 */
public class MonsterCell extends Cell {

	private final Enemy enemy;

	public MonsterCell(Position position, Enemy enemy) {
		super(position);
		this.enemy = enemy;
	}

	@Override
	public void onEnter(Player player) {
		reveal();
		if (enemy != null && enemy.isAlive()) {
			System.out.println("A wild " + enemy.getType().toString() + " appears!");
		}
	}

	@Override
	public CellType getType() {
		return CellType.MONSTER;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public boolean hasLivingMonster() {
		return enemy != null && enemy.isAlive();
	}
}
