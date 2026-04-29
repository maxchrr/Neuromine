package up.javafx.core.entity.player.characters;

public enum CharacterType {
    BANDIT (10, 5, 2),
    DUCHESS(4, 2, 1),
    KNIGHT (4, 1, 1),
    PALADIN(5, 2, 1);

    public final int hp;
    public final int attack;
    public final int mana;

    CharacterType(int hp, int attack, int mana) {
        this.hp     = hp;
        this.attack = attack;
        this.mana   = mana;
    }
}
