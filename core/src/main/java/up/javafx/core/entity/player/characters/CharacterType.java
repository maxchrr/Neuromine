package up.javafx.core.entity.player.characters;

public enum CharacterType {
	BANDIT(3,1,2),
	DUCHESS(4,2,1),
	KNIGHT(4,1,1),
	PALADIN(5,2,1);

	private final int baseHp;
	private final int attack;
	private final int mana;

	CharacterType(int baseHp, int attack, int mana) {
		this.baseHp = baseHp;
		this.attack = attack;
		this.mana = mana;
	}

	public int getBaseHp() {
		return baseHp;
	}

	public int getAttack() {
		return attack;
	}

	public int getMana() {
		return mana;
	}
}
