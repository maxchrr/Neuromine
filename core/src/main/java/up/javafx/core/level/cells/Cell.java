package up.javafx.core.level.cells;

/**
 * Abstract representation of a grid cell.
 * Handles the visibility state and flag status.
 */
public abstract class Cell {

	protected CellType type;
	protected final int x;
	protected final int y;

	protected boolean revealed = false;
	protected boolean flagged = false;

	/**
	 * @param x    X coordinate in the grid.
	 * @param y    Y coordinate in the grid.
	 */
	public Cell(CellType type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

	/**
	 * Logic to reveal the tile.
	 * Specific behavior (like explosions) is handled in subclasses.
	 */
	public void reveal() {
		if (!flagged)
			this.revealed = true;
	}

	/**
	 * Places a flag on the tile to mark a suspected mine.
	 */
	public void toggleFlag() {
		if (!revealed && !flagged)
			this.flagged = true;
	}

	/**
	 * Removes the flag from the tile.
	 */
	public void uncovered() {
		if (flagged)
			this.flagged = false;
	}

	public CellType getType() {
		return type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public boolean isRevealed() {
		return revealed;
	}

	public boolean isFlagged() {
		return flagged;
	}

}
