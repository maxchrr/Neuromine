package up.javafx.game.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import up.javafx.core.entity.player.Player;
import up.javafx.core.entity.player.PlayerProfile;
import up.javafx.core.entity.player.characters.CharacterFactory;
import up.javafx.core.entity.player.characters.CharacterType;
import up.javafx.core.level.Direction;
import up.javafx.core.level.Grid;
import up.javafx.core.level.LevelGenerator;
import up.javafx.core.level.Position;
import up.javafx.game.controller.GameController;
import up.javafx.game.fx.view.GameFxView;
import up.javafx.game.model.GameModel;

public class AppFx extends Application {

    @Override
    public void start(Stage stage) {
        Grid grid = LevelGenerator.generateLevel(10, 15);
        Player player = new Player(
                new PlayerProfile("Player1"),
                CharacterFactory.create(CharacterType.BANDIT),
                new Position(1, 1)
        );
        GameModel model = new GameModel(grid, player);
        GameFxView view = new GameFxView();
        GameController controller = new GameController(model, view);
        controller.setOnUpdate(() -> view.update(controller.snapshot()));

        view.setOnFlagAction((col, row) -> controller.handleFlag(col, row));

        Position startPos = player.getPosition();
        for (int r = startPos.y() - 1; r <= startPos.y() + 1; r++) {
            for (int c = startPos.x() - 1; c <= startPos.x() + 1; c++) {
                if (grid.isInside(r, c)) {
                    grid.getCell(r, c).reveal();
                }
            }
        }
        view.update(controller.snapshot());

        Scene scene = new Scene(view, 450, 480);
        scene.setOnKeyPressed(e -> {
            Position p = controller.snapshot().playerPosition();
            int px = p.x();
            int py = p.y();

            if (e.isControlDown()) {
                switch (e.getCode()) {
                    case UP, Z    -> controller.handleFlag(px, py - 1);
                    case DOWN, S  -> controller.handleFlag(px, py + 1);
                    case LEFT, Q  -> controller.handleFlag(px - 1, py);
                    case RIGHT, D -> controller.handleFlag(px + 1, py);
                    default -> {}
                }
            } else {
                switch (e.getCode()) {
                    case UP, Z    -> controller.handleMove(Direction.UP);
                    case DOWN, S  -> controller.handleMove(Direction.DOWN);
                    case LEFT, Q  -> controller.handleMove(Direction.LEFT);
                    case RIGHT, D -> controller.handleMove(Direction.RIGHT);
                    default -> {}
                }
            }
        });

        stage.setTitle("Neuromine");
        stage.setScene(scene);
        stage.show();
    }
}
