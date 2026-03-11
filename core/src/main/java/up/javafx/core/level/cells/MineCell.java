package up.javafx.core.level.cells;

import up.javafx.core.level.mine.Mine;

/**
 * A tile containing a mine. Triggers explosion logic upon revelation.
 */
public class MineCell extends Cell {

	private final Mine mine;

	public MineCell(int x, int y, Mine mine) {
		super(CellType.MINE, x, y);
		this.mine = mine;
	}

	/**
	 * Reveals the tile and triggers the mine explosion.
	 */
	@Override
	public void reveal() {
		if (!flagged && !revealed) {
			super.reveal();
			if (mine != null) {
				System.out.println("BOOM: Mine exploded!");
			}
		}
	}

	@Override
	public void toggleFlag() {
		if (!revealed && !flagged) {
			super.toggleFlag();
			grid.addDiscovered();
		}
	}

	@Override
	public void uncovered() {
		if (flagged) {
			super.uncovered();
			grid.subDiscovered();
		}
	}

	public Mine getMine() {
		return mine;
	}

}
