package up.javafx.core.engine.systems;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.mine.Mine;
import up.javafx.core.level.mine.NormalMine;

public class MineSystem {

	public void trigger(Player player, Mine mine) {
		if (mine instanceof NormalMine normalMine)
			player.takeDamage(normalMine.getDamage());
	}
}
