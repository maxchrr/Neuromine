package up.javafx.core.entity.player.characters;

public class CharacterFactory {

	public static PlayerCharacter create(CharacterType type) {
		return switch (type) {
			case BANDIT -> new BanditCharacter();
			case DUCHESS -> new DuchessCharacter();
			case KNIGHT -> new KnightCharacter();
			case PALADIN -> new PaladinCharacter();
			default -> throw new IllegalArgumentException("Unknown character: " + type);
		};
	}	
}
