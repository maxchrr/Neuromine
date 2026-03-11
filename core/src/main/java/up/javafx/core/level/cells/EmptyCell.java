package up.javafx.core.level.cells;

/**
 * A neutral tile with no specific threat or number.
 */
public class EmptyCell extends Cell {

	public EmptyCell(int x, int y) {
		super(CellType.EMPTY, x, y);
	}

}
