package up.javafx.core.entity.enemy;

import up.javafx.core.entity.player.Player;

public class BossEnemy extends Enemy {

	public BossEnemy() {
		super(EnemyType.BOSS);
	}

	@Override
	public void attack(Player player) {
		System.out.println("The Boss wants to kill you!");
		player.takeDamage(getAttack());
	}
}
