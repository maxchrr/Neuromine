package up.neuromine.core.entity.player;

/**
 * Enumeration of all player classes and their starting statistics.
 * HP: Health points | Damage: Base attack power | Mana: Ability cost/pool |
 * Range: Max move distance.
 */
public enum PlayerProfile {
	KNIGHT(4, 1, 1, 1),
	PALADIN(5, 2, 1, 1),
	DUCHESS(4, 2, 1, 1),
	BANDIT(3, 1, 2, 2);

	private final int baseHp;
	private final int baseDamage;
	private final int baseMana;
	private final int moveRange;

	PlayerProfile(int hp, int damage, int mana, int range) {
		this.baseHp = hp;
		this.baseDamage = damage;
		this.baseMana = mana;
		this.moveRange = range;
	}

	public int getBaseHp() {
		return baseHp;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public int getBaseMana() {
		return baseMana;
	}

	public int getMoveRange() {
		return moveRange;
	}
}
