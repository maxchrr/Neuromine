package up.neuromine.core.entity;

import up.neuromine.core.level.cells.Cell;

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
	 */
	@Override
	public void move(int targetX, int targetY) {
		// Validation logic for distance == 1 would be in the Controller/Engine
		this.setPosition(targetX, targetY);
	}

	/**
	 * Attack: A slash affecting 3 front tiles.
	 * Reveals the target tile and its two direct neighbors relative to orientation.
	 */
	@Override
	public void attack(Cell targetCell) {
		if (targetCell == null)
			return;

		// 1. Reveal the main target
		targetCell.reveal();

		// 2. The Controller will use the player's orientation (0-3)
		// to identify and reveal the two side tiles.
		// Example: If facing North, side tiles are (x-1, y) and (x+1, y).
	}

	@Override
	public void useSpecialCapacity(Cell targetCell) {
		if (this.mana > 0) {
			// Special: e.g., Holy Heal (Restore 1 HP)
			this.hp = Math.min(this.maxHp, this.hp + 1);
			this.mana--;
		}
	}

}
