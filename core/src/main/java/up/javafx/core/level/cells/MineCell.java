package up.javafx.core.level.cells;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Position;
import up.javafx.core.level.mine.Mine;

/**
 * A cell containing a mine.
 * Triggers the mine logic when entered by the player.
 */
public class MineCell extends Cell {

	private final Mine mine;

	public MineCell(Position position, Mine mine) {
		super(position);
		this.mine = mine;
		if (mine != null)
			mine.setCell(this);
	}

	@Override
	public void onEnter(Player player) {
		reveal();
		if (mine != null && mine.isActive())
			mine.trigger(player);
	}

	@Override
	public CellType getType() {
		return CellType.MINE;
	}

	public Mine getMine() {
		return mine;
	}
}
