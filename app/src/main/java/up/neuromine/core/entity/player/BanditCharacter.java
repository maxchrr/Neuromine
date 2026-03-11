<<<<<<<< HEAD:core/src/main/java/up/javafx/core/entity/player/characters/BanditCharacter.java
package up.javafx.core.entity.player.characters;
========
package up.neuromine.core.entity.player;
>>>>>>>> refs/remotes/origin/master:app/src/main/java/up/neuromine/core/entity/player/BanditCharacter.java

import up.javafx.core.entity.player.Player;
import up.javafx.core.entity.player.PlayerProfile;
import up.javafx.core.level.tiles.Tile;

/**
 * Bandit: Low HP but high mobility.
 * Combines movement and attack through a "Leap" mechanic.
 */
public class BanditCharacter extends Player {

	public BanditCharacter(int x, int y) {
		super("Bandit", PlayerProfile.BANDIT, x, y);
	}

	/**
	 * Movement: Can move diagonally or adjacently (up to 2 tiles).
	@Override
	public void move(int targetX, int targetY) {
		this.setPosition(targetX, targetY);
	}
	*/

	/**
	 * Attack: A leap forward by 1 or 2 tiles.
	 * The Bandit moves to the target tile and reveals it.
	 */
	@Override
	public void attack(Tile target) {
		if (target == null) return;
		target.reveal();
		this.setPosition(target.getGridX(), target.getGridY());
	}

	@Override
	public void useSpecialCapacity(Tile target) {
		if (this.mana > 0) {
			this.mana--;
		}
	}

}
