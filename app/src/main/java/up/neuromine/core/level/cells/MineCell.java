package up.neuromine.core.level.cells;

import up.neuromine.core.level.Grid;
import up.neuromine.core.level.mine.Mine;

public class MineCell extends Cell {

	private Mine mine;

	public MineCell(Grid grid, Mine mine) {
		super(grid);
		this.mine = mine;
	}

	@Override
	public void reveal() {
		revealed = true;
		getMine().explode(null);
	}

	@Override
	public void coverWithFlag() {
		if (!isCovered()) {
			covered = true;
			addMineCount(getGrid());
		}

	}

	@Override
	public void uncovered() {
		if (isCovered()) {
			covered = false;
			subMineCount(getGrid());
		}
	}

	public void addMineCount(Grid grid) {
		grid.addDiscovered();
	}

	public void subMineCount(Grid map) {
		map.subDiscovered();
	}

	public Mine getMine() {
		return mine;
	}
}
