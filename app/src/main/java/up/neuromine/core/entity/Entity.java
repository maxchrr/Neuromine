package up.neuromine.core.entity;

/**
 * Abstract base class for all living entities (Players and Enemies).
 * Handles health, positioning, and basic life status.
 */
public abstract class Entity {

	protected String name;
	protected int hp;
	protected int maxHp;
	protected int x;
	protected int y;

	public Entity(String name, int hp, int x, int y) {
		this.name = name;
		this.hp = hp;
		this.maxHp = hp;
		this.x = x;
		this.y = y;
	}

	/** Applies damage and ensures HP doesn't drop below zero. */
	public void takeDamage(int amount) {
		this.hp = Math.max(0, this.hp - amount);
	}

	public boolean isAlive() {
		return hp > 0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getHp() {
		return hp;
	}

	public String getName() {
		return name;
	}

}
