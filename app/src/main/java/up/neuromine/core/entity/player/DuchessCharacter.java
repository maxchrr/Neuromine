<<<<<<<< HEAD:core/src/main/java/up/javafx/core/entity/player/characters/DuchessCharacter.java
package up.javafx.core.entity.player.characters;
========
package up.neuromine.core.entity.player;
>>>>>>>> refs/remotes/origin/master:app/src/main/java/up/neuromine/core/entity/player/DuchessCharacter.java

import up.javafx.core.entity.player.Player;
import up.javafx.core.entity.player.PlayerProfile;
import up.javafx.core.level.tiles.MonsterTile;
import up.javafx.core.level.tiles.Tile;

/**
 * Duchess: Balanced stats with high precision.
 * Features a Quickslash attack and agile movement.
 */
public class DuchessCharacter extends Player {

	public DuchessCharacter(int x, int y) {
		super("Duchess", PlayerProfile.DUCHESS, x, y);
	}

	/**
	 * Movement: Agile movement. Can move to any adjacent or diagonal tile
	 * within a range of 1 or 2, as per her profile.
	 * 
	 * @Override
	 *           public void move(int targetX, int targetY) {
	 *           this.setPosition(targetX, targetY);
	 *           }
	 */

	/**
	 * Attack: Quickslash.
	 * Precisely reveals and attacks the single tile directly in front.
	 */
	@Override
	public void attack(Tile target) {
		if (target == null)
			return;
		target.reveal();
		if (target instanceof MonsterTile) {
			((MonsterTile) target).getEnemy().takeDamage(damage);
		}
	}

	/**
	 * Special Capacity: Royal Command (Concept).
	 * Could reveal all mines in a radius of 2 without triggering them.
	 */
	@Override
	public void useSpecialCapacity(Tile target) {
		if (this.mana > 0) {
			this.mana--;
		}
	}
}
