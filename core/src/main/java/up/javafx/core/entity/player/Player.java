package up.javafx.core.entity.player;

import up.javafx.core.entity.Entity;
import up.javafx.core.entity.player.characters.PlayerCharacter;
import up.javafx.core.level.Position;

public class Player extends Entity {

	private final PlayerProfile profile;
	private final PlayerCharacter character;

	public Player(PlayerProfile profile, PlayerCharacter character, Position pos) {
		super(character.getBaseHp(), pos);
		this.profile = profile;
		this.character = character;
	}

	public PlayerProfile getProfile() {
		return profile;
	}

	public PlayerCharacter getCharacter() {
		return character;
	}
}
