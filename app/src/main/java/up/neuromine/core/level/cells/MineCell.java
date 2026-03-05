package up.neuromine.core.level.cells;

import up.neuromine.core.level.Grid;
import up.neuromine.core.level.mine.Mine;

/**
 * A cell containing a mine. Triggers explosion logic upon revelation.
 */
public class MineCell extends Cell {

	private final Mine mine;

	public MineCell(Grid grid, Mine mine, int x, int y) {
		super(grid, x, y);
		this.mine = mine;
	}

	/**
	 * Reveals the cell and triggers the mine explosion.
	 * Note: Damage logic is usually coordinated by the Controller via a Signal.
	 */
	@Override
	public void reveal() {
		if (!covered && !revealed) {
			super.reveal();
			// The signal for explosion will be caught by the Controller
			if (mine != null) {
				// Here, we could return a Signal in a real MVC flow
				System.out.println("BOOM: Mine exploded!");
			}
		}
	}

	@Override
	public void coverWithFlag() {
		if (!revealed && !covered) {
			super.coverWithFlag();
			grid.addDiscovered(); // Increment the found mines counter
		}
	}

	@Override
	public void uncovered() {
		if (covered) {
			super.uncovered();
			grid.subDiscovered(); // Decrement the found mines counter
		}
	}

	public Mine getMine() {
		return mine;
	}

}
