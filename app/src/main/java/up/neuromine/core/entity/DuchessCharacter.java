package up.neuromine.core.entity;

import up.neuromine.core.level.cells.Cell;

/**
 * Duchess: Balanced stats with high precision.
 * Features a Quickslash attack and agile movement.
 */
public class DuchessCharacter extends Player {

	public DuchessCharacter(int x, int y) {
		// Initializes with the Duchess profile stats
		super("Duchess", PlayerProfile.DUCHESS, x, y);
	}

	/**
	 * Movement: Agile movement. Can move to any adjacent or diagonal tile
	 * within a range of 1 or 2, as per her profile.
	 */
	@Override
	public void move(int targetX, int targetY) {
		// Logic check: (distance <= moveRange)
		this.setPosition(targetX, targetY);
	}

	/**
	 * Attack: Quickslash.
	 * Precisely reveals and attacks the single tile directly in front.
	 */
	@Override
	public void attack(Cell targetCell) {
		if (targetCell != null) {
			// Reveal the tile (standard minesweeper logic)
			targetCell.reveal();

			// Business logic: If an enemy is present, apply 'this.damage'
			// This coordination is handled by the GameEngine.
		}
	}

	/**
	 * Special Capacity: Royal Command (Concept).
	 * Could reveal all mines in a radius of 2 without triggering them.
	 */
	@Override
	public void useSpecialCapacity(Cell targetCell) {
		if (this.mana > 0) {
			// Implementation of the special effect
			this.mana--;
		}
	}
}
