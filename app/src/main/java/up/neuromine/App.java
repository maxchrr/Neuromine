package up.neuromine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
	
	public static final int WINDOW_WIDTH = 1200;
	public static final int WINDOW_HEIGHT = 800;
	public static final String WINDOW_TITLE = "JavaFX Application";
	
	private Stage mainStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.mainStage = primaryStage;
		
		Pane root = new Pane();
		this.mainStage.setTitle(WINDOW_TITLE);;
        this.mainStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
        this.mainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
