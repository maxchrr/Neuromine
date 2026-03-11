package up.javafx.core.level.cells;

import up.javafx.core.entity.enemy.Enemy;

/**
 * A tile containing a monster.
 * Monsters are detected at radius 2 and can be fought by the player.
 */
public class MonsterCell extends Cell {

	private final Enemy enemy;

	/**
	 * @param enemy The monster assigned to this tile.
	 * @param x     X coordinate.
	 * @param y     Y coordinate.
	 */
	public MonsterCell(int x, int y, Enemy enemy) {
		super(CellType.MONSTER, x, y);
		this.enemy = enemy;
	}

	/**
	 * Revealing a monster tile alerts the player.
	 * If the monster is still alive, it might trigger an ambush.
	 */
	@Override
	public void reveal() {
		if (!flagged && !revealed) {
			super.reveal();
			if (enemy != null && enemy.isAlive()) {
				System.out.println("A wild " + enemy.getName() + " appears!");
			}
		}
	}

	/**
	 * Flags can be used to mark suspected monster locations,
	 * just like with mines.
	 */
	@Override
	public void toggleFlag() {
		if (!revealed && !flagged) {
			super.toggleFlag();
		}
	}

	public Enemy getEnemy() {
		return enemy;
	}

	/**
	 * Checks if the monster in this cell is still a threat.
	 */
	public boolean hasLivingMonster() {
		return enemy != null && enemy.isAlive();
	}

}
