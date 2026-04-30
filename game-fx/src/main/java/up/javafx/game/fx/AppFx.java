package up.javafx.game.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import up.javafx.game.fx.view.SettingsView;
import up.javafx.game.fx.view.MainMenuView;
import up.javafx.core.entity.enemy.SkeletonEnemy;
import up.javafx.core.entity.player.Player;
import up.javafx.core.entity.player.PlayerProfile;
import up.javafx.core.entity.player.characters.CharacterFactory;
import up.javafx.core.entity.player.characters.CharacterType;
import up.javafx.core.io.CellDescriptor;
import up.javafx.core.io.Level;
import up.javafx.core.level.Direction;
import up.javafx.core.level.Grid;
import up.javafx.core.level.LevelGenerator;
import up.javafx.core.level.Position;
import up.javafx.core.level.cells.Cell;
import up.javafx.core.level.cells.EmptyCell;
import up.javafx.core.level.cells.EnemyCell;
import up.javafx.core.level.cells.MineCell;
import up.javafx.core.level.cells.NumberCell;
import up.javafx.core.level.mine.NormalMine;
import up.javafx.game.controller.CharacterSelectController;
import up.javafx.game.controller.GameController;
import up.javafx.game.controller.LevelSelectController;
import up.javafx.game.controller.SettingsController;
import up.javafx.game.fx.view.CharacterSelectView;
import up.javafx.game.fx.view.GameFxView;
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

    // Boutons de difficulté standard[cite: 10, 13]
    view.getBtnEasy().setOnAction(e -> showCharacterSelection(8, 15, 5, null));
    view.getBtnMedium().setOnAction(e -> showCharacterSelection(10, 30, 10, null));
    view.getBtnHard().setOnAction(e -> showCharacterSelection(12, 60, 20, null));

    // Bouton pour charger un niveau personnalisé[cite: 10, 13]
    view.getBtnLoadCustom().setOnAction(e -> {
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        fileChooser.setTitle("Open Custom Level");
        fileChooser.getExtensionFilters().add(new javafx.stage.FileChooser.ExtensionFilter("Level Files", "*.json"));
        
        java.io.File defaultDirectory = new java.io.File("levels");
        if (defaultDirectory.exists() && defaultDirectory.isDirectory()) {
            fileChooser.setInitialDirectory(defaultDirectory);
        }

        java.io.File file = fileChooser.showOpenDialog(primaryStage);
        
        if (file != null) {
            try {
                // On charge le niveau via le repository[cite: 10]
                up.javafx.core.io.Level customLevel = up.javafx.core.io.LevelRepository.load(file.toPath());
                
                // Au lieu de launcher.launchCustom, on appelle directement la méthode suivante
                showCharacterSelection(0, 0, 0, customLevel);
                
            } catch (Exception ex) {
                System.err.println("Erreur de chargement du niveau : " + ex.getMessage());
            }
        }
    });

    view.getBtnBack().setOnAction(e -> showMainMenu());
    mainScene.setRoot(view);
}

    private void showCharacterSelection(int size, int mines, int enemies, Level customLevel) {
        CharacterSelectModel model = new CharacterSelectModel();
        CharacterSelectView view = new CharacterSelectView();
        CharacterSelectController controller = new CharacterSelectController(model, view);

        // Centralisation des actions de sélection de personnage dans AppFx
        view.getBtnBandit().setOnAction(e -> showGame(size, mines, enemies, customLevel, CharacterType.BANDIT));
        view.getBtnDuchess().setOnAction(e -> showGame(size, mines, enemies, customLevel, CharacterType.DUCHESS));
        view.getBtnKnight().setOnAction(e -> showGame(size, mines, enemies, customLevel, CharacterType.KNIGHT));
        view.getBtnPaladin().setOnAction(e -> showGame(size, mines, enemies, customLevel, CharacterType.PALADIN));

        view.getBtnBack().setOnAction(e -> showLevelSelect());
        mainScene.setRoot(view);
    }

    private void showGame(int size, int mines, int enemies, Level customLevel, CharacterType charType) {
        
        Grid grid;
        Position startPos;

        if (customLevel != null) {
            System.out.println("Lancement du niveau custom : " + customLevel.name());
            
            grid = new Grid(customLevel.height(), customLevel.width());
            startPos = new Position(customLevel.startX(), customLevel.startY());
            
            for (int r = 0; r < customLevel.height(); r++) {
                for (int c = 0; c < customLevel.width(); c++) {
                    grid.setCell(r, c, new EmptyCell(new Position(c, r)));
                }
            }
            
            for (CellDescriptor desc : customLevel.cells()) {
                int r = desc.y();
                int c = desc.x();
                Position pos = new Position(c, r);
                
                switch (desc.type()) {
                    case MINE    -> grid.setCell(r, c, new MineCell(pos, new NormalMine()));
                    case MONSTER -> grid.setCell(r, c, new EnemyCell(pos, new SkeletonEnemy(pos)));
                    default      -> {}
                }
            }

            for (int r = 0; r < customLevel.height(); r++) {
                for (int c = 0; c < customLevel.width(); c++) {
                    Cell cell = grid.getCell(r, c);
                    if (cell instanceof MineCell || cell instanceof EnemyCell) continue;

                    int mineCount = countMinesAround(grid,r,c);
                    int monsterCount = countMonstersAround(grid,r,c);

                    if (mineCount > 0 || monsterCount > 0) {
                        grid.setCell(r, c, new NumberCell(new Position(c, r), mineCount, monsterCount));
                    }
                }
            }

        } else {
            grid = LevelGenerator.generateLevel(size, mines, enemies); 
            startPos = new Position(1, 1);
        }
        
        Player player = new Player(
                new PlayerProfile("Player1"),
                CharacterFactory.create(charType),
                startPos
        );
        
        GameModel model = new GameModel(grid, player);

        GameFxView view = new GameFxView();
        GameController controller = new GameController(model, view);
        controller.setOnUpdate(() -> view.update(controller.snapshot()));

        Position playerPos = player.getPosition();
        for (int r = playerPos.y() - 1; r <= playerPos.y() + 1; r++) {
            for (int c = playerPos.x() - 1; c <= playerPos.x() + 1; c++) {
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

    private int countMinesAround(Grid grid, int row, int col) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (grid.isInside(r, c) && grid.getCell(r, c) instanceof MineCell) {
                    count++;
                }
            }
        }
        return count;
    }

    private int countMonstersAround(Grid grid, int row, int col) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (grid.isInside(r, c) && grid.getCell(r, c) instanceof EnemyCell) {
                    count++;
                }
            }
        }
        return count;
    }
}
