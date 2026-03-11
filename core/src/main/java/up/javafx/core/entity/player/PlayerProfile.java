package up.javafx.core.entity.player;

import java.util.HashSet;
import java.util.Set;

import up.javafx.core.entity.player.characters.CharacterType;

public class PlayerProfile {

	private String name;

	private int level;
	private int xp;

	private int gamesPlayed;
	private int wins;

	private Set<CharacterType> unlockedCharacters;

	public PlayerProfile(String name) {
		this.name = name;
		this.level = 1;
		this.xp = 0;
		this.gamesPlayed = 0;
		this.wins = 0;
		this.unlockedCharacters = new HashSet<>();
	}

	public void addExperience(int xp) {
		xp += xp;
		while (xp >= level * 100) {
			xp -= level * 100;
			levelUp();
		}
	}

	private void levelUp() {
		level++;
		System.out.println(name + " reached level " + level + "!");
	}

	public void addGamePlayed(boolean win) {
		gamesPlayed++;
		if (win)
			wins++;
	}

	public void unlockCharacter(CharacterType type) {
		unlockedCharacters.add(type);
	}

	public boolean isCharacterUnlocked(CharacterType type) {
		return unlockedCharacters.contains(type);
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public int getXp() {
		return xp;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getWins() {
		return wins;
	}

	public Set<CharacterType> getUnlockedCharacters() {
		return unlockedCharacters;
	}
}
