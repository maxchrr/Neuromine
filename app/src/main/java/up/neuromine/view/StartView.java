package up.neuromine.view;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class StartView extends BorderPane implements BaseView {

	@FXML
	private Button quitButton;

	public static StartView create() {
		return new StartView();
	}

	@Override
	public void hide() {
		super.setVisible(false);
	}

	@Override
	public void show() {
		super.setVisible(true);
	}

	private StartView() {
		super();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/up/neuromine/view/StartView.fxml"));
		loader.setRoot(this);
		loader.setController(this);

		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException("Failed to load StartView.fxml", e);
		}
	}

	@FXML
	private void handleQuit() {
		Platform.exit();
	}

}
