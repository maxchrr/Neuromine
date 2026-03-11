package up.javafx.neuromine.controller;

import up.javafx.mvc.controller.Controller;
import up.javafx.neuromine.model.GameModel;
import up.javafx.neuromine.view.GameView;

public class GameController extends Controller<GameModel, GameView> {

	public GameController(GameModel model, GameView view) {
		super(model, view);
	}

	@Override
	protected void init() {
		view.btn.setOnAction(e -> {
			model.increment();
			view.updateScore(model.getScore());
		});
	}

}
