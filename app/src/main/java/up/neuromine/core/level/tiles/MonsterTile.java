package up.neuromine.core.level.tiles;

import up.neuromine.core.entity.enemy.Enemy;
import up.neuromine.core.level.Grid;

/**
 * A tile containing a monster.
 * Monsters are detected at radius 2 and can be fought by the player.
 */
public class MonsterTile extends Tile {

	private final Enemy enemy;

	/**
	 * @param grid  The parent grid.
	 * @param enemy The monster assigned to this tile.
	 * @param x     X coordinate.
	 * @param y     Y coordinate.
	 */
	public MonsterTile(Grid grid, Enemy enemy, int x, int y) {
		super(grid, x, y);
		this.enemy = enemy;
	}

	/**
	 * Revealing a monster tile alerts the player.
	 * If the monster is still alive, it might trigger an ambush.
	 */
	@Override
	public void reveal() {
		if (!covered && !revealed) {
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
	public void coverWithFlag() {
		if (!revealed && !covered) {
			super.coverWithFlag();
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
