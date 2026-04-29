package up.javafx.game.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import up.javafx.game.fx.view.SettingsView;
import up.javafx.game.fx.view.MainMenuView;
import up.javafx.core.entity.player.Player;
import up.javafx.core.entity.player.PlayerProfile;
import up.javafx.core.entity.player.characters.CharacterFactory;
import up.javafx.core.entity.player.characters.CharacterType;
import up.javafx.core.level.Direction;
import up.javafx.core.level.Grid;
import up.javafx.core.level.LevelGenerator;
import up.javafx.core.level.Position;
import up.javafx.game.controller.GameController;
import up.javafx.game.controller.SettingsController;
import up.javafx.game.fx.view.GameFxView;
import up.javafx.game.model.GameModel;
import up.javafx.game.model.SettingsModel;

public class AppFx extends Application {

    private Stage primaryStage;
    private Scene mainScene;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        this.mainScene = new Scene(new Pane(), 600, 600);

        stage.setTitle("Neuromine");
        stage.setScene(mainScene);

        showMainMenu();

        stage.show();
    }

    private void showMainMenu() {
        MainMenuView menuView = new MainMenuView();
        menuView.getBtnPlay().setOnAction(e -> showGame());
        menuView.getBtnSettings().setOnAction(e -> showSettings());
        mainScene.setRoot(menuView);
    }

    private void showSettings() {
        SettingsModel model = new SettingsModel();
        SettingsView view = new SettingsView();
        SettingsController controller = new SettingsController(model, view);

        view.getVolSlider().valueProperty().addListener((obs, old, val) ->
            controller.setVolume(val.doubleValue())
        );

        view.getBtnFullscreen().setOnAction(e -> controller.toggleFullscreen());

        view.getItem1().setOnAction(e -> controller.updateResolution("1920x1080"));
        view.getItem2().setOnAction(e -> controller.updateResolution("1680x1050"));
        view.getItem2().setOnAction(e -> controller.updateResolution("1280x720"));

        model.fullscreenProperty().addListener((obs, old, isFull) -> {
            primaryStage.setFullScreen(isFull);
            view.getBtnFullscreen().setText(isFull ? "On" : "Off");
        });

        model.resolutionProperty().addListener((obs, old, res) -> {
            String[] parts = res.split("x");
            if (parts.length == 2) {
                primaryStage.setWidth(Double.parseDouble(parts[0]));
                primaryStage.setHeight(Double.parseDouble(parts[1]));
                view.getResMenu().setText("Current : " + res);
            }
        });

        view.getBtnBack().setOnAction(e -> showMainMenu());
        mainScene.setRoot(view);
    }

    private void showGame() {
        Grid grid = LevelGenerator.generateLevel(10, 15, 5);
        Player player = new Player(
                new PlayerProfile("Player1"),
                CharacterFactory.create(CharacterType.PALADIN),
                new Position(1, 1)
        );
        GameModel model = new GameModel(grid, player);

        GameFxView view = new GameFxView();
        GameController controller = new GameController(model, view);
        controller.setOnUpdate(() -> view.update(controller.snapshot()));

        Position startPos = player.getPosition();
        for (int r = startPos.y() - 1; r <= startPos.y() + 1; r++) {
            for (int c = startPos.x() - 1; c <= startPos.x() + 1; c++) {
                if (grid.isInside(r, c)) {
                    grid.getCell(r, c).reveal();
                }
            }
        }
        view.update(controller.snapshot());

        mainScene.setOnKeyPressed(e -> {
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
            } else if (e.isShiftDown()) {
                switch (e.getCode()) {
                    case UP, Z    -> controller.handleAttack(px, py - 1);
                    case DOWN, S  -> controller.handleAttack(px, py + 1);
                    case LEFT, Q  -> controller.handleAttack(px - 1, py);
                    case RIGHT, D -> controller.handleAttack(px + 1, py);
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

        view.setOnFlagAction((col, row) -> controller.handleFlag(col, row));

        mainScene.setRoot(view);
    }
}
