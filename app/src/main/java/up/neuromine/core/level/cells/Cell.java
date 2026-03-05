package up.neuromine.core.level.cells;

import up.neuromine.core.level.Grid;

/**
 * Abstract representation of a grid cell.
 * Handles the visibility state and flag status.
 */
public abstract class Cell {

	protected final Grid grid;
	protected final int gridX;
	protected final int gridY;

	protected boolean revealed = false;
	protected boolean covered = false;

	/**
	 * @param grid The parent grid.
	 * @param x    X coordinate in the grid.
	 * @param y    Y coordinate in the grid.
	 */
	public Cell(Grid grid, int x, int y) {
		this.grid = grid;
		this.gridX = x;
		this.gridY = y;
	}

	/**
	 * Logic to reveal the cell.
	 * Specific behavior (like explosions) is handled in subclasses.
	 */
	public void reveal() {
		if (!covered) {
			this.revealed = true;
		}
	}

	/**
	 * Places a flag on the cell to mark a suspected mine.
	 */
	public void coverWithFlag() {
		if (!revealed && !covered) {
			this.covered = true;
		}
	}

	/**
	 * Removes the flag from the cell.
	 */
	public void uncovered() {
		if (covered) {
			this.covered = false;
		}
	}

	public int getGridX() {
		return gridX;
	}

	public int getGridY() {
		return gridY;
	}

	public Grid getGrid() {
		return grid;
	}

	public boolean isCovered() {
		return covered;
	}

	public boolean isRevealed() {
		return revealed;
	}

}
