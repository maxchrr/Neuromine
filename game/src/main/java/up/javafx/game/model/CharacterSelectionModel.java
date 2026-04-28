package up.javafx.game.model;

import up.javafx.core.entity.player.characters.CharacterFactory;
import up.javafx.core.entity.player.characters.CharacterType;
import up.javafx.core.entity.player.characters.PlayerCharacter;
import up.javafx.mvc.Model;

import java.util.Arrays;
import java.util.List;

public class CharacterSelectionModel extends Model {

    private CharacterType selectedType = CharacterType.BANDIT;
    private String playerName = "Player";

    public List<CharacterType> getAvailableCharacters() {
        return Arrays.asList(CharacterType.values());
    }

    public void selectCharacter(CharacterType type) { selectedType = type; }
    public CharacterType getSelectedType()          { return selectedType; }

    public void   setPlayerName(String name) { playerName = name; }
    public String getPlayerName()            { return playerName; }

    public PlayerCharacter createSelectedCharacter() {
        return CharacterFactory.create(selectedType);
    }
}
