package up.javafx.core.entity.player.characters;

public abstract class PlayerCharacter {

    protected final CharacterType type;

    protected PlayerCharacter(CharacterType type) { this.type = type; }

    public CharacterType getType()   { return type; }
    public int           getHp()     { return type.hp; }
    public int           getAttack() { return type.attack; }
    public int           getMana()   { return type.mana; }
}
