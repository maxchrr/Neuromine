package up.javafx.editor.text;

import up.javafx.core.io.LevelIOException;
import up.javafx.core.level.cells.CellType;
import up.javafx.editor.controller.EditorController;
import up.javafx.editor.model.EditorModel;
import up.javafx.editor.text.view.CommandParser;
import up.javafx.editor.text.view.EditorTextView;

import java.nio.file.Path;
import java.util.Scanner;

public class AppText {

    public static void main(String[] args) {
        EditorModel model = new EditorModel(10, 10);
        EditorTextView view = new EditorTextView();
        EditorController controller = new EditorController(model, view);
        controller.setOnUpdate(() -> view.render(controller.snapshot()));

        view.render(controller.snapshot());
        System.out.println("Commandes :");
        System.out.println("  place <x> <y> <MINE|MONSTER|WALL|EMPTY>");
        System.out.println("  erase <x> <y>");
        System.out.println("  new <largeur> <hauteur>");
        System.out.println("  save <fichier.json>");
        System.out.println("  load <fichier.json>");
        System.out.println("  quit");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            try {
                switch (CommandParser.parse(line)) {
                    case PLACE -> {
                        int x = Integer.parseInt(parts[1]);
                        int y = Integer.parseInt(parts[2]);
                        CellType t = CellType.valueOf(parts[3].toUpperCase());
                        controller.handlePlace(x, y, t);
                    }
                    case ERASE -> {
                        int x = Integer.parseInt(parts[1]);
                        int y = Integer.parseInt(parts[2]);
                        controller.handlePlace(x, y, CellType.EMPTY);
                    }
                    case RESIZE -> {
                        int w = Integer.parseInt(parts[1]);
                        int h = Integer.parseInt(parts[2]);
                        controller.handleNew(w, h);
                    }
                    case SAVE -> {
                        controller.handleSave(Path.of(parts[1]));
                        System.out.println("Sauvegardé.");
                    }
                    case LOAD -> {
                        controller.handleLoad(Path.of(parts[1]));
                    }
                    case QUIT -> { System.out.println("Au revoir !"); return; }
                    default   -> System.out.println("Commande inconnue. Tapez 'quit' pour quitter.");
                }
            } catch (LevelIOException e) {
                System.out.println("Erreur E/S : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
        sc.close();
    }
}
