package up.javafx.core.entity;

public abstract class Entity {

	protected int hp;

	public Entity(int hp) {
		this.hp = hp;
	}

	public void takeDamage(int amount) {
		this.hp = Math.max(0, this.hp - amount);
	}

	public boolean isAlive() {
		return hp > 0;
	}

	public int getHp() {
		return hp;
	}
}
