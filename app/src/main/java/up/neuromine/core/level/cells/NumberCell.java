package up.neuromine.core.level.cells;

import up.neuromine.core.level.Grid;

public class NumberCell extends Cell {

	private int number;

	public NumberCell(Grid grid, int n) {
		super(grid);
		this.number = n;
	}
}
