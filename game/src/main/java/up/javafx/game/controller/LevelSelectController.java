package up.javafx.game.controller;

import up.javafx.game.model.LevelSelectModel;
import up.javafx.mvc.Controller;
import up.javafx.mvc.View;

public class LevelSelectController extends Controller<LevelSelectModel, View> {
    public LevelSelectController(LevelSelectModel model, View view) {
        super(model, view);
    }

    @Override 
    protected void init() {
        // Vide : les setOnAction sont faits dans AppFx
    }
}