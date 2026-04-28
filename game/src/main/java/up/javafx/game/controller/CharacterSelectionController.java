package up.javafx.game.controller;

import up.javafx.core.entity.player.characters.CharacterType;
import up.javafx.game.model.CharacterSelectionModel;
import up.javafx.mvc.Controller;
import up.javafx.mvc.View;

public class CharacterSelectionController extends Controller<CharacterSelectionModel, View> {

    private Runnable onUpdate = () -> {};

    public CharacterSelectionController(CharacterSelectionModel model, View view) {
        super(model, view);
    }

    @Override protected void init() {}

    public void setOnUpdate(Runnable r) { onUpdate = r; }

    public void selectCharacter(CharacterType type) {
        model.selectCharacter(type);
        onUpdate.run();
    }

    public void setPlayerName(String name) {
        model.setPlayerName(name);
        onUpdate.run();
    }

    public CharacterSelectionModel getSelectionModel() { return model; }
}
