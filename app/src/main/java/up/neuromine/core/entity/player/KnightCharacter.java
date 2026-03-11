<<<<<<<< HEAD:core/src/main/java/up/javafx/core/entity/player/characters/KnightCharacter.java
package up.javafx.core.entity.player.characters;
========
package up.neuromine.core.entity.player;
>>>>>>>> refs/remotes/origin/master:app/src/main/java/up/neuromine/core/entity/player/KnightCharacter.java

import up.javafx.core.entity.player.Player;
import up.javafx.core.entity.player.PlayerProfile;
import up.javafx.core.level.tiles.Tile;

/**
 * Knight: High HP, L-shaped movement, and Piercing attack.
 */
public class KnightCharacter extends Player {

	public KnightCharacter(int x, int y) {
		super("Knight", PlayerProfile.KNIGHT, x, y);
	}

	/** 
	@Override
	public void move(int targetX, int targetY) {
		this.setPosition(targetX, targetY);
	}
	*/

	@Override
	public void attack(Tile target) {
		if (target == null) return;
		target.reveal();
	}

	@Override
	public void useSpecialCapacity(Tile target) {
		if (mana > 0) {
			mana--;
		}
	}
}
