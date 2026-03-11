package up.javafx.core.level.mine;

<<<<<<< HEAD:core/src/main/java/up/javafx/core/level/mine/Mine.java
import up.javafx.core.entity.player.Player;
=======
import up.neuromine.core.entity.player.Player;
>>>>>>> refs/remotes/origin/master:app/src/main/java/up/neuromine/core/level/mine/Mine.java

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
