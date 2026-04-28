package up.javafx.core.entity.player;

import up.javafx.core.entity.player.characters.CharacterType;

import java.util.EnumSet;
import java.util.Set;

public class PlayerProfile {

    private String name;
    private int level = 1;
    private int xp = 0;
    private int gamesPlayed = 0;
    private int wins = 0;
    private final Set<CharacterType> unlockedCharacters = EnumSet.of(CharacterType.BANDIT);

    public PlayerProfile(String name) { this.name = name; }

    public void addExperience(int amount) {
        this.xp += amount;
        if (this.xp >= level * 100) {
            level++;
            xp = 0;
        }
    }

    public void recordGame(boolean won) {
        gamesPlayed++;
        if (won) wins++;
    }

    public void unlockCharacter(CharacterType type) { unlockedCharacters.add(type); }
    public boolean hasUnlocked(CharacterType type)  { return unlockedCharacters.contains(type); }

    public String getName()       { return name; }
    public int    getLevel()      { return level; }
    public int    getXp()         { return xp; }
    public int    getGamesPlayed(){ return gamesPlayed; }
    public int    getWins()       { return wins; }
    public Set<CharacterType> getUnlockedCharacters() { return unlockedCharacters; }
}
