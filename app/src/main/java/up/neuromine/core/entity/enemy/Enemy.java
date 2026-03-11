package up.neuromine.core.entity.enemy;

import up.neuromine.core.entity.Entity;

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
