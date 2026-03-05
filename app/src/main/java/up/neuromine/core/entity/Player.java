package up.neuromine.core.entity;

import up.neuromine.core.level.cells.Cell;

/**
 * Represents the user-controlled character.
 * Uses the PlayerProfile for initial stats and defines combat/movement
 * contracts.
 */
public abstract class Player extends Entity {

	protected final PlayerProfile profile;
	protected int mana;
	protected int damage;
	protected int orientation = 0; // 0: North, 1: East, 2: South, 3: West

	public Player(String name, PlayerProfile profile, int x, int y) {
		super(name, profile.getBaseHp(), x, y);
		this.profile = profile;
		this.mana = profile.getBaseMana();
		this.damage = profile.getBaseDamage();
	}

	/** Movement logic specific to each character class. */
	public abstract void move(int targetX, int targetY);

	/** Attack logic (area of effect, range) specific to each class. */
	public abstract void attack(Cell targetCell);

	/** Special ability logic using mana. */
	public abstract void useSpecialCapacity(Cell targetCell);

	/** Rotates the player clockwise to change attack direction. */
	public void rotate() {
		this.orientation = (this.orientation + 1) % 4;
	}

	// Common player actions
	public void flag(Cell cell) {
		cell.coverWithFlag();
	}

	public int getMana() {
		return mana;
	}

	public int getDamage() {
		return damage;
	}
}
