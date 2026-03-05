package up.neuromine.core.entity;

import up.neuromine.core.level.cells.Cell;

/**
 * Represents a player with a specific profile and characteristics.
 */
public abstract class Player extends Entity {

	private final PlayerProfile profile;
	protected int mana;
	protected int damage;
	private Cell selected; // Tile currently targeted by the player

	/**
	 * Constructor using the predefined PlayerProfile to set base stats.
	 * 
	 * @param name    The name of the player instance.
	 * @param profile The chosen class (Knight, Paladin, etc.).
	 * @param x       Initial X position.
	 * @param y       Initial Y position.
	 */
	public Player(String name, PlayerProfile profile, int x, int y) {
		super(name, profile.getBaseHp(), x, y);
		this.profile = profile;
		this.mana = profile.getBaseMana();
		this.damage = profile.getBaseDamage();
	}

	/**
	 * * Abstract methods to be implemented by specific character classes.
	 * These are triggered by the Controller upon receiving a View Action.
	 */
	public abstract void move(Cell target);

	public abstract void attack(Cell target);

	public abstract void speCapacity(Cell target);

	/**
	 * Logic to reveal a tile, respecting the specific detection rules:
	 * - Mines: Radius 1
	 * - Monsters: Radius 2
	 */
	public void reveal(Cell cell) {
		if (cell != null) {
			cell.reveal(); // Calls the core logic to uncover the tile
		}
	};

	/** Places a flag as a reminder of a suspected mine. */
	public void flag(Cell cell) {
		if (cell != null) {
			cell.coverWithFlag();
		}
	}

	/**
	 * Rotates the player's focus clockwise.
	 * Useful for directional attacks (like the Knight's spear).
	 */
	public void rotate() {
		// Logic to update selectedTile based on current orientation
	}

	public PlayerProfile getProfile() {
		return profile;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Cell getCell() {
		return selected;
	}

	public void setCell(Cell cell) {
		selected = cell;
	}
}
