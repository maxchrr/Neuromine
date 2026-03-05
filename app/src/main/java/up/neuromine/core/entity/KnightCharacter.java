package up.neuromine.core.entity;

import up.neuromine.core.level.cells.Cell;

/**
 * Knight: High HP, L-shaped movement, and Piercing attack.
 */
public class KnightCharacter extends Player {

	public KnightCharacter(int x, int y) {
		super("Knight", PlayerProfile.KNIGHT, x, y);
	}

	@Override
	public void move(int targetX, int targetY) {
		// Logic check for L-shape move (2+1 or 1+2)
		// If valid, update position
		this.setPosition(targetX, targetY);
	}

	@Override
	public void attack(Cell targetCell) {
		// Attack: Front cell (1 damage) + Cell behind (2 damage)
		// Requires identifying direction via 'orientation'
		targetCell.reveal();
		// Additional logic for the second cell in line...
	}

	@Override
	public void useSpecialCapacity(Cell targetCell) {
		if (mana > 0) {
			// Knight's special: e.g., Shield (temporary invulnerability)
			mana--;
		}
	}
}
