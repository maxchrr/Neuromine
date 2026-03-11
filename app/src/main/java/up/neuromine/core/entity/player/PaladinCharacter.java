<<<<<<<< HEAD:core/src/main/java/up/javafx/core/entity/player/characters/PaladinCharacter.java
package up.javafx.core.entity.player.characters;
========
package up.neuromine.core.entity.player;
>>>>>>>> refs/remotes/origin/master:app/src/main/java/up/neuromine/core/entity/player/PaladinCharacter.java

import up.javafx.core.entity.player.Player;
import up.javafx.core.entity.player.PlayerProfile;
import up.javafx.core.level.Grid;
import up.javafx.core.level.tiles.Tile;

/**
 * Paladin: High HP and Area-of-Effect (AoE) attack.
 * Attacks the front tile and the two adjacent side tiles.
 */
public class PaladinCharacter extends Player {

	public PaladinCharacter(int x, int y) {
		super("Paladin", PlayerProfile.PALADIN, x, y);
	}

	/**
	 * Movement: Standard adjacent movement (1 tile).
	@Override
	public void move(int targetX, int targetY) {
		this.setPosition(targetX, targetY);
	}
	*/

	/**
	 * Attack: A slash affecting 3 front tiles.
	 * Reveals the target tile and its two direct neighbors relative to orientation.
	 */
	@Override
	public void attack(Tile target) {
		if (target == null)
			return;
		Grid grid = target.getGrid();
		int x = target.getGridX();
		int y = target.getGridY();
		target.reveal();
		switch (orientation) {
			case 0:
				revealIfValid(grid, x, y - 1);
				revealIfValid(grid, x, y - 2);
				break;
			case 1:
				revealIfValid(grid, x + 1, y);
				revealIfValid(grid, x + 2, y);
				break;
			case 2:
				revealIfValid(grid, x, y + 1);
				revealIfValid(grid, x, y + 2);
				break;
			case 3:
				revealIfValid(grid, x - 1, y);
				revealIfValid(grid, x - 2, y);
				break;
			default:
				System.err.println("Invalid orientation: " + orientation);
				break;
		}
	}

	@Override
	public void useSpecialCapacity(Tile target) {
		if (this.mana > 0) {
			this.hp++;
			this.mana--;
		}
	}

	/**
	 * Helper to prevent NullPointerExceptions if the slash hits the edge of the
	 * map.
	 */
	private void revealIfValid(Grid grid, int x, int y) {
		Tile t = grid.getTile(x, y);
		if (t != null) {
			t.reveal();
		}
	}

}
