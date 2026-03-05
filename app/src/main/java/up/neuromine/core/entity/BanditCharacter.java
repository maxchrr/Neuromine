package up.neuromine.core.entity;

import up.neuromine.core.level.cells.Cell;

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
	 */
	@Override
	public void move(int targetX, int targetY) {
		this.setPosition(targetX, targetY);
	}

	/**
	 * Attack: A leap forward by 1 or 2 tiles.
	 * The Bandit moves to the target tile and reveals it.
	 */
	@Override
	public void attack(Cell targetCell) {
		if (targetCell == null)
			return;

		// 1. Reveal the destination
		targetCell.reveal();

		// 2. Teleport the bandit to the new coordinates
		// This is a "Leap" attack: Move + Reveal
		this.setPosition(targetCell.getGridX(), targetCell.getGridY());
	}

	@Override
	public void useSpecialCapacity(Cell targetCell) {
		if (this.mana > 0) {
			// Special: e.g., Stealth (cannot be detected by monsters for 1 turn)
			this.mana--;
		}
	}

}
