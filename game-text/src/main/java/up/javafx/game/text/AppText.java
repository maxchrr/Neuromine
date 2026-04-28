package up.javafx.game.text;

import up.javafx.core.entity.player.Player;
import up.javafx.core.entity.player.PlayerProfile;
import up.javafx.core.entity.player.characters.CharacterFactory;
import up.javafx.core.entity.player.characters.CharacterType;
import up.javafx.core.level.Direction;
import up.javafx.core.level.Grid;
import up.javafx.core.level.LevelGenerator;
import up.javafx.core.level.Position;
import up.javafx.game.controller.GameController;
import up.javafx.game.model.GameModel;
import up.javafx.game.text.view.GameTextView;

import java.util.Scanner;

public class AppText {

    public static void main(String[] args) {
        Grid grid = LevelGenerator.generateLevel(10, 15);
        Player player = new Player(
                new PlayerProfile("Player1"),
                CharacterFactory.create(CharacterType.BANDIT),
                new Position(1, 1)
        );
        GameModel model = new GameModel(grid, player);
        GameTextView view = new GameTextView();
        GameController controller = new GameController(model, view);
        controller.setOnUpdate(() -> view.render(controller.snapshot()));

        grid.getCell(1, 1).reveal();
        view.render(controller.snapshot());

        System.out.println("Z=haut  S=bas  Q=gauche  D=droite  X=quitter");
        Scanner sc = new Scanner(System.in);
        while (controller.isRunning()) {
            String cmd = sc.nextLine().trim().toUpperCase();
            switch (cmd) {
                case "Z" -> controller.handleMove(Direction.UP);
                case "S" -> controller.handleMove(Direction.DOWN);
                case "Q" -> controller.handleMove(Direction.LEFT);
                case "D" -> controller.handleMove(Direction.RIGHT);
                case "X" -> { System.out.println("Au revoir !"); return; }
                default  -> System.out.println("Commande inconnue : " + cmd);
            }
        }
        System.out.println("Partie terminée ! Score : " + model.getScore());
        sc.close();
    }
}
