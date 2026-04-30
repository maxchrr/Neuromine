package up.javafx.game.fx;

import javafx.application.Application;
import javafx.application.Platform;
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
import up.javafx.game.fx.view.CharacterSelectController;
import up.javafx.game.fx.view.CharacterSelectView;
import up.javafx.game.fx.view.GameFxView;
import up.javafx.game.fx.view.LevelSelectController;
import up.javafx.game.fx.view.LevelSelectView;
import up.javafx.game.model.CharacterSelectModel;
import up.javafx.game.model.GameModel;
import up.javafx.game.model.LevelSelectModel;
import up.javafx.game.model.SettingsModel;

public class AppFx extends Application {

    private Stage primaryStage;
    private Scene mainScene;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        this.mainScene = new Scene(new Pane(), 1280, 720);

        stage.setTitle("Neuromine");
        stage.setScene(mainScene);

        showMainMenu();

        stage.show();
    }

    private void showMainMenu() {
        MainMenuView menuView = new MainMenuView();
        menuView.getBtnPlay().setOnAction(e -> showLevelSelect());
        menuView.getBtnSettings().setOnAction(e -> showSettings());
        menuView.getBtnQuit().setOnAction(e -> Platform.exit());
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
        view.getItem3().setOnAction(e -> controller.updateResolution("1280x720"));

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

    private void showLevelSelect() {
        LevelSelectModel model = new LevelSelectModel();
        LevelSelectView view = new LevelSelectView();
        LevelSelectController controller = new LevelSelectController(model, view);

        controller.setGameLauncher((size, mines, enemies) -> showCharacterSelect(size, mines, enemies));

        view.getBtnBack().setOnAction(e -> showMainMenu());

        mainScene.setRoot(view.getRootNode());
    }

    private void showCharacterSelect(int size, int mines, int enemies) {
        CharacterSelectModel model = new CharacterSelectModel();
        CharacterSelectView view = new CharacterSelectView();
        CharacterSelectController controller = new CharacterSelectController(model, view);

        controller.setCharacterLauncher((charType) -> showGame(size, mines, enemies, charType));

        view.getBtnBack().setOnAction(e -> showLevelSelect());

        mainScene.setRoot(view.getRootNode());
    }

    private void showGame(int size, int mines, int enemies, CharacterType charType) {
        Grid grid = LevelGenerator.generateLevel(size, mines, enemies);
        Player player = new Player(
                new PlayerProfile("Player1"),
                CharacterFactory.create(charType),
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

        
        view.getUpBtn().setOnAction(e -> handlePlayerAction(view, controller, Direction.UP));
        view.getDownBtn().setOnAction(e -> handlePlayerAction(view, controller, Direction.DOWN));
        view.getLeftBtn().setOnAction(e -> handlePlayerAction(view, controller, Direction.LEFT));
        view.getRightBtn().setOnAction(e -> handlePlayerAction(view, controller, Direction.RIGHT));


        view.getBtnBack().setOnAction(e -> showMainMenu());


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

    private void handlePlayerAction(GameFxView view, GameController controller, Direction dir) {
            var pos = controller.snapshot().playerPosition();
            
            int targetX = pos.x() + dir.dx;
            int targetY = pos.y() + dir.dy;

            if (view.getBtnModeAttack().isSelected()) {
                controller.handleAttack(targetX, targetY);
            } else if (view.getBtnModeFlag().isSelected()) {
                controller.handleFlag(targetX, targetY);
            } else {
                controller.handleMove(dir);
            }
        }
}
