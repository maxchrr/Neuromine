package up.javafx.neuromine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import up.javafx.neuromine.controller.GameController;
import up.javafx.neuromine.model.GameModel;
import up.javafx.neuromine.view.GameView;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GameModel model = new GameModel();
		GameView view = new GameView();
		new GameController(model, view);

		Scene scene = new Scene(view, 400, 300);
		primaryStage.setTitle("Neuromine");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
