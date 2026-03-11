package up.javafx.core.level.mine;

import up.javafx.core.entity.player.Player;

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
