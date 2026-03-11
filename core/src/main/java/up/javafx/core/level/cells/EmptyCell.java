package up.javafx.core.level.cells;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Position;

/**
 * A cell that does nothing when entered, just reveals itself.
 */
public class EmptyCell extends Cell {

	public EmptyCell(Position position) {
		super(position);
	}

	@Override
	public void onEnter(Player player) {
		reveal();
	}

	@Override
	public CellType getType() {
		return CellType.EMPTY;
	}
}
