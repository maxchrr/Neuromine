package up.javafx.core.entity.enemy;

import up.javafx.core.entity.Entity;
import up.javafx.core.entity.player.Player;

public abstract class Enemy extends Entity {

	private final EnemyType type;

	public Enemy(EnemyType type) {
		super(type.getBaseHp());
		this.type = type;
	}

	public abstract void attack(Player player);

	public EnemyType getType() {
		return type;
	}

	public int getBaseHp() {
		return type.getBaseHp();
	}

	public int getAttack() {
		return type.getAttack();
	}
}
