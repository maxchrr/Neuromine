package up.neuromine.core.entity;

/**
 * Base class for any living entity on the grid.
 */
public abstract class Entity {

	protected int hp;
	protected int x, y;
	protected String name;

	public Entity(String name, int hp, int x, int y) {
		this.name = name;
		this.hp = hp;
		this.x = x;
		this.y = y;
	}

	public void takeDamage(int amount) {
		hp = Math.max(0, hp - amount);
	}

	public boolean isAlive() {
		return hp > 0;
	}

	public int getHp() {
		return hp;
	}

	public int getPosX() {
		return x;
	}

	public int getPosY() {
		return y;
	}

	public String getName() {
		return name;
	}

}
