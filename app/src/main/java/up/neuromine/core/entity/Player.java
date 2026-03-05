package up.neuromine.core.entity;

import up.neuromine.core.level.tiles.Tile;

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
	public abstract void attack(Tile target);

	/** Special ability logic using mana. */
	public abstract void useSpecialCapacity(Tile target);

	/** Rotates the player clockwise to change attack direction. */
	public void rotate() {
		this.orientation = (orientation + 1) % 4;
	}

	// Common player actions
	public void flag(Tile cell) {
		cell.coverWithFlag();
	}

	public int getMana() {
		return mana;
	}

	public int getDamage() {
		return damage;
	}
}
