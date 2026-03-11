package up.javafx.core.entity.enemy;

import up.javafx.core.entity.player.Player;

public class SkeletonEnemy extends Enemy {

	public SkeletonEnemy() {
		super(EnemyType.SKELETON);
	}

	@Override
	public void attack(Player player) {
		System.out.println("Skeleton shoots an arrow!");
		player.takeDamage(getAttack());
	}
}
