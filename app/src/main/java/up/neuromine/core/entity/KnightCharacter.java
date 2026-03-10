package up.neuromine.core.entity;

import up.neuromine.core.level.tiles.Tile;

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
