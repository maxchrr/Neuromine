package up.neuromine.model;

import javafx.application.Platform;

public class StartModel implements BaseModel {

	@Override
	public void run() {
		Platform.exit();
	}

}
