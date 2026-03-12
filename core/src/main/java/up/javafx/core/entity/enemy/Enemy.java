package up.javafx.core.entity.enemy;

import up.javafx.core.entity.Entity;
import up.javafx.core.level.Position;

public abstract class Enemy extends Entity {

	private final EnemyType type;

	public Enemy(EnemyType type, Position pos) {
		super(type.getBaseHp(), pos);
		this.type = type;
	}

	public EnemyType getType() {
		return type;
	}

	public int getAttack() {
		return type.getAttack();
	}
}
