package up.javafx.core.level.mine;

<<<<<<< HEAD:core/src/main/java/up/javafx/core/level/mine/NormalMine.java
import up.javafx.core.entity.player.Player;
=======
import up.neuromine.core.entity.player.Player;
>>>>>>> refs/remotes/origin/master:app/src/main/java/up/neuromine/core/level/mine/NormalMine.java

public class NormalMine extends Mine {

	public NormalMine(int radius) {
		super(radius);
	}

	@Override
	public void explode(Player target) {
		// if personnage dans un certain rayon = mort (grace a une méthode kill dans
		// perso ou quoi)
	}

}
