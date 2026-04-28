package up.javafx.editor.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import up.javafx.editor.controller.EditorController;
import up.javafx.editor.fx.view.EditorFxView;
import up.javafx.editor.model.EditorModel;

public class AppFx extends Application {

    @Override
    public void start(Stage stage) {
        EditorModel model = new EditorModel(10, 10);
        EditorFxView view = new EditorFxView(stage);

        EditorController controller = new EditorController(model, view);
        controller.setOnUpdate(() -> view.update(controller.snapshot()));
        view.wire(controller);
        view.update(controller.snapshot());

        Scene scene = new Scene(view, 550, 480);
        stage.setTitle("Neuromine — Éditeur de niveaux");
        stage.setScene(scene);
        stage.show();
    }
}
