package up.neuromine.core.level.tiles;

import up.neuromine.core.level.Grid;
import up.neuromine.core.level.mine.Mine;

/**
 * A tile containing a mine. Triggers explosion logic upon revelation.
 */
public class MineTile extends Tile {

	private final Mine mine;

	public MineTile(Grid grid, Mine mine, int x, int y) {
		super(grid, x, y);
		this.mine = mine;
	}

	/**
	 * Reveals the tile and triggers the mine explosion.
	 */
	@Override
	public void reveal() {
		if (!covered && !revealed) {
			super.reveal();
			if (mine != null) {
				System.out.println("BOOM: Mine exploded!");
			}
		}
	}

	@Override
	public void coverWithFlag() {
		if (!revealed && !covered) {
			super.coverWithFlag();
			grid.addDiscovered();
		}
	}

	@Override
	public void uncovered() {
		if (covered) {
			super.uncovered();
			grid.subDiscovered();
		}
	}

	public Mine getMine() {
		return mine;
	}

}
