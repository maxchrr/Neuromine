package up.javafx.core.entity.enemy;

public enum EnemyType {

	GOBLIN(3,1),
	SKELETON(4,2),
	BOSS(10,4);

	private final int baseHp;
	private final int attack;

	EnemyType(int baseHp, int attack) {
		this.baseHp = baseHp;
		this.attack = attack;
	}

	public int getBaseHp() {
		return baseHp;
	}

	public int getAttack() {
		return attack;
	}
}
