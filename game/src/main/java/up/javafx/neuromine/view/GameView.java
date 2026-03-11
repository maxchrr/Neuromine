package up.javafx.neuromine.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import up.javafx.mvc.view.View;

public class GameView extends VBox implements View {

	public final Button btn = new Button("Action");
	public final Label label = new Label("Score: 0");

	public GameView() {
		this.getChildren().addAll(label, btn);
	}

	public void updateScore(int score) {
		label.setText("Score: " + score);
	}

}
