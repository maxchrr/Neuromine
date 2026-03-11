package up.javafx.neuromine.model;

import up.javafx.mvc.model.Model;

public class GameModel extends Model {

	private int score = 0;

	public void increment() {
		score++;
	}

	public int getScore() {
		return score;
	}

}
