package up.neuromine;

import javafx.application.Application;
import javafx.stage.Stage;
import up.neuromine.controller.StartController;

public class App extends Application {

	public static final int WINDOW_WIDTH = 1200;
	public static final int WINDOW_HEIGHT = 800;
	public static final String WINDOW_TITLE = "Neuromine";

	private Stage mainStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.mainStage = primaryStage;

		StartController controller = StartController.create(this.mainStage);
		controller.run();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
