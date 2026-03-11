package up.javafx.core.entity.player.characters;

public abstract class PlayerCharacter {

	private final CharacterType type;

	public PlayerCharacter(CharacterType type) {
		this.type = type;
	}

	public CharacterType getType() {
		return type;
	}
}
