package up.neuromine.core.level.mine;

import up.neuromine.core.entity.player.Player;

public abstract class Mine {

	protected int radius;

	public Mine(int radius) {
		this.radius = radius;
	}

	public void explode(Player target) {
	}

	public int getRadius() {
		return radius;
	}
}
