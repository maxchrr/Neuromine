package up.neuromine.controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import up.neuromine.App;
import up.neuromine.view.BaseView;
import up.neuromine.view.StartView;

public class StartController extends BaseController {

	private final Stage stage;

	public static StartController create(Stage stage) {
		StartView view = StartView.create();
		return new StartController(stage, view);
	}

	public void run() {
		this.stage.setTitle(App.WINDOW_TITLE);

		this.stage.setScene(new Scene((Parent) super.getView(), App.WINDOW_WIDTH, App.WINDOW_HEIGHT));
		this.stage.show();
	}

	private StartController(Stage stage, BaseView view) {
		super(null, view);
		this.stage = stage;
	}

}
