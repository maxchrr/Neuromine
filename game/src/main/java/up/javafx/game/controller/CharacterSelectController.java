package up.javafx.game.controller;


import up.javafx.game.model.CharacterSelectModel;
import up.javafx.mvc.Controller;
import up.javafx.mvc.View;

public class CharacterSelectController extends Controller<CharacterSelectModel, View> {
    public CharacterSelectController(CharacterSelectModel model, View view) {
        super(model, view);
    }

    @Override 
    protected void init() {
        // Vide : les setOnAction sont faits dans AppFx
    }
}