package up.javafx.core.level;

import up.javafx.core.level.cells.Cell;;

public class Grid {

	private final int rows;
	private final int cols;
	private final Cell[][] cells;

	public Grid(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.cells = new Cell[rows][cols];
	}

	public boolean isInside(int r, int c) {
		return r >= 0 && r < rows && c >= 0 && c < cols;
	}

	public Cell getCell(int r, int c) {
		return isInside(r, c) ? cells[r][c] : null;
	}

	public void setCell(int r, int c, Cell cell) {
		if (isInside(r, c))
			cells[r][c] = cell;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
}
