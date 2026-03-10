package up.neuromine.core.entity;

import up.neuromine.core.level.tiles.Tile;

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
