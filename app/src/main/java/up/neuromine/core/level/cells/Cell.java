package up.neuromine.core.level.cells;

import up.neuromine.core.level.Grid;

public abstract class Cell {

	private Grid grid;

	protected Boolean revealed = false;
	protected Boolean covered = false;

	public Cell(Grid grid) {
		this.grid = grid;
	}

	public void reveal() {
		revealed = true;
	}

	public void coverWithFlag() {
		covered = true;
	}

	public void uncovered() {
		covered = false;
	}

	public Boolean isCovered() {
		return covered;
	}

	public Boolean isRevealed() {
		return revealed;
	}

	public Grid getGrid() {
		return grid;
	}

}
