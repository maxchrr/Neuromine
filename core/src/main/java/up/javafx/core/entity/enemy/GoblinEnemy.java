package up.javafx.core.entity.enemy;

import up.javafx.core.entity.player.Player;

public class GoblinEnemy extends Enemy {

	public GoblinEnemy() {
		super(EnemyType.GOBLIN);
	}

	@Override
	public void attack(Player player) {
		System.out.println("Goblin attacks!");
		player.takeDamage(getAttack());
	}
}
