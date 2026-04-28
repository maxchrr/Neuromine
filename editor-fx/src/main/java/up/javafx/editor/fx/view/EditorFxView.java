package up.javafx.editor.fx.view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import up.javafx.editor.controller.EditorController;
import up.javafx.editor.dto.EditorSnapshot;
import up.javafx.mvc.View;

public class EditorFxView extends BorderPane implements View {

    private final EditorGridCanvas canvas  = new EditorGridCanvas();
    private final EditorToolbar    toolbar = new EditorToolbar();
    private final Stage stage;

    public EditorFxView(Stage stage) {
        this.stage = stage;
        setTop(toolbar);
        setCenter(canvas);
    }

    public void wire(EditorController controller) {
        canvas.setController(controller);
        toolbar.wire(controller, stage);
    }

    public void update(EditorSnapshot snapshot) {
        canvas.render(snapshot);
        toolbar.update(snapshot);
    }
}
