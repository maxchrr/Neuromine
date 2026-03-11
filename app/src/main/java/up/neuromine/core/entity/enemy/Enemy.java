<<<<<<<< HEAD:core/src/main/java/up/javafx/core/entity/enemy/Enemy.java
package up.javafx.core.entity.enemy;

import up.javafx.core.entity.Entity;
========
package up.neuromine.core.entity.enemy;

import up.neuromine.core.entity.Entity;
>>>>>>>> refs/remotes/origin/master:app/src/main/java/up/neuromine/core/entity/enemy/Enemy.java

/**
 * Represents a monster on the grid.
 * Monsters have a detection radius of 2 as per project rules.
 */
public class Enemy extends Entity {

	private final int attackPower;
	private final int detectionRadius = 2;

	public Enemy(String name, int hp, int attackPower, int x, int y) {
		super(name, hp, x, y);
		this.attackPower = attackPower;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public int getDetectionRadius() {
		return detectionRadius;
	}

}
