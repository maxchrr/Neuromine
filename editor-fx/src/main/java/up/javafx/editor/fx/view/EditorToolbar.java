package up.javafx.editor.fx.view;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import up.javafx.core.io.LevelIOException;
import up.javafx.editor.controller.EditorController;
import up.javafx.editor.dto.EditorSnapshot;
import up.javafx.editor.model.EditorState;

public class EditorToolbar extends HBox {

    private final Label statusLabel = new Label();

    public EditorToolbar() {
        setSpacing(6);
        getChildren().add(statusLabel);
    }

    public void wire(EditorController controller, Stage stage) {
        Button btnMine  = toolButton("Mine",   controller, EditorState.PLACE_MINE);
        Button btnEnemy = toolButton("Ennemi", controller, EditorState.PLACE_ENEMY);
        Button btnWall  = toolButton("Mur",    controller, EditorState.PLACE_WALL);
        Button btnErase = toolButton("Effacer",controller, EditorState.ERASE);

        Button btnSave = new Button("💾 Sauver");
        btnSave.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.setTitle("Sauvegarder le niveau");
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
            var file = fc.showSaveDialog(stage);
            if (file != null) {
                try { controller.handleSave(file.toPath()); }
                catch (LevelIOException ex) { alert(ex.getMessage()); }
            }
        });

        Button btnLoad = new Button("📂 Charger");
        btnLoad.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.setTitle("Charger un niveau");
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
            var file = fc.showOpenDialog(stage);
            if (file != null) {
                try { controller.handleLoad(file.toPath()); }
                catch (LevelIOException ex) { alert(ex.getMessage()); }
            }
        });

        Button btnNew = new Button("Nouveau");
        btnNew.setOnAction(e -> {
            TextInputDialog dlg = new TextInputDialog("10x10");
            dlg.setTitle("Nouveau niveau");
            dlg.setHeaderText("Dimensions (LargeurxHauteur) :");
            dlg.showAndWait().ifPresent(s -> {
                try {
                    String[] p = s.split("[xX]");
                    controller.handleNew(Integer.parseInt(p[0].trim()), Integer.parseInt(p[1].trim()));
                } catch (Exception ex) { alert("Format invalide (ex: 10x10)"); }
            });
        });

        getChildren().addAll(0, java.util.List.of(
                btnMine, btnEnemy, btnWall, btnErase,
                new Separator(), btnSave, btnLoad, btnNew, new Separator()));
    }

    public void update(EditorSnapshot s) {
        statusLabel.setText(String.format("Outil : %s%s",
                s.currentTool(), s.hasUnsavedChanges() ? "  [*]" : ""));
    }

    private Button toolButton(String label, EditorController ctrl, EditorState state) {
        Button b = new Button(label);
        b.setOnAction(e -> ctrl.handleToolChange(state));
        return b;
    }

    private void alert(String msg) {
        new Alert(Alert.AlertType.ERROR, msg, ButtonType.OK).show();
    }
}
