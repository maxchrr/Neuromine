package up.javafx.game.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

// Imports de tes Settings et Menu
import up.javafx.game.fx.view.SettingsModel;
import up.javafx.game.fx.view.SettingsController;
import up.javafx.game.fx.view.SettingsView;
import up.javafx.game.fx.view.MainMenuView;

// Imports de ton Jeu (ajuste si besoin)
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

    private Stage primaryStage;
    private Scene mainScene;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        
        // On crée une scène vide au départ
        this.mainScene = new Scene(new Pane(), 600, 600);
        
        stage.setTitle("Neuromine");
        stage.setScene(mainScene);
        
        // On démarre l'application en affichant le Menu Principal
        showMainMenu();
        
        stage.show();
    }

    /**
     * Affiche le Menu Principal
     */
    private void showMainMenu() {
        MainMenuView menuView = new MainMenuView();

        // Si on clique sur Play, on lance la méthode showGame()
        menuView.getBtnPlay().setOnAction(e -> showGame());
        
        // Si on clique sur Settings, on lance la méthode showSettings()
        menuView.getBtnSettings().setOnAction(e -> showSettings());

        // On remplace le contenu de la fenêtre par le menu
        mainScene.setRoot(menuView);
    }

    /**
     * Affiche les Paramètres
     */
    private void showSettings() {
        SettingsModel model = new SettingsModel();
        SettingsView view = new SettingsView();
        
        // On instancie le contrôleur pour que la logique des paramètres s'active
        new SettingsController(model, view, primaryStage);

        // On connecte le bouton Retour pour qu'il recharge le Menu Principal
        view.getBtnBack().setOnAction(e -> showMainMenu());

        // On remplace le contenu de la fenêtre par les paramètres
        mainScene.setRoot(view.getRootNode());
    }

    /**
     * Affiche et lance le Jeu (Ton code d'avant, isolé ici)
     */
    private void showGame() {
        // 1. Initialisation du modèle
        Grid grid = LevelGenerator.generateLevel(10, 15, 5); 
        Player player = new Player(
                new PlayerProfile("Player1"),
                CharacterFactory.create(CharacterType.PALADIN),
                new Position(1, 1)
        );
        GameModel model = new GameModel(grid, player);
        
        // 2. Initialisation de la vue et du contrôleur
        GameFxView view = new GameFxView();
        GameController controller = new GameController(model, view);
        controller.setOnUpdate(() -> view.update(controller.snapshot()));

        // Révélation de départ
        Position startPos = player.getPosition();
        for (int r = startPos.y() - 1; r <= startPos.y() + 1; r++) {
            for (int c = startPos.x() - 1; c <= startPos.x() + 1; c++) {
                if (grid.isInside(r, c)) {
                    grid.getCell(r, c).reveal();
                }
            }
        }
        view.update(controller.snapshot());

        // 3. Gestion des contrôles clavier
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

        // N'oublie pas le clic droit pour le drapeau !
        view.setOnFlagAction((col, row) -> controller.handleFlag(col, row));

        // On remplace le contenu de la fenêtre par le jeu
        mainScene.setRoot(view);
    }
}