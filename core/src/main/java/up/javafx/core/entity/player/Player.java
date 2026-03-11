package up.javafx.core.entity.player;

import up.javafx.core.entity.Entity;
import up.javafx.core.entity.player.characters.PlayerCharacter;

public class Player extends Entity {

	private final PlayerProfile profile;
	private final PlayerCharacter character;

	public Player(PlayerProfile profile, PlayerCharacter character) {
		super(character.getBaseHp());
		this.profile = profile;
		this.character = character;
	}

	public void heal(int amount) {
		hp += amount;
	}

	public PlayerProfile getProfile() {
		return profile;
	}

	public PlayerCharacter getCharacter() {
		return character;
	}
}
