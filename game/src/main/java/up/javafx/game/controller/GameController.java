package up.javafx.game.controller;

import up.javafx.core.level.Direction;
import up.javafx.game.dto.GameSnapshot;
import up.javafx.game.model.GameModel;
import up.javafx.mvc.Controller;
import up.javafx.mvc.View;

public class GameController extends Controller<GameModel, View> {

    private Runnable onUpdate = () -> {};

    public GameController(GameModel model, View view) {
        super(model, view);
    }

    @Override protected void init() {}

    public void setOnUpdate(Runnable r) { onUpdate = r; }

    public void handleMove(Direction dir) {
        model.move(dir);
        onUpdate.run();
    }

    public void handleFlag(int col, int row) {
        // TODO: toggle flag on cell at (col, row)
        onUpdate.run();
    }

    public GameSnapshot snapshot()        { return model.snapshot(); }
    public boolean      isRunning()       { return model.isRunning(); }
}
