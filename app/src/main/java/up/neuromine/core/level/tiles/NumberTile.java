package up.neuromine.core.level.tiles;

import up.neuromine.core.level.Grid;

/**
 * A tile that displays the number of surrounding threats.
 */
public class NumberTile extends Tile {

	private int mineCount = 0;
	private int monsterCount = 0;

	public NumberTile(Grid grid, int x, int y) {
		super(grid, x, y);
		calculateNumbers(x, y);
	}

	/**
	 * Queries the grid to update local threat counters.
	 * 
	 * @param x Current tile X position
	 * @param y Current tile Y position
	 */
	public void calculateNumbers(int x, int y) {
		this.mineCount = grid.countMinesAround(x, y);
		this.monsterCount = grid.countMonstersAround(x, y);
	}

	public int getMineCount() {
		return mineCount;
	}

	public int getMonsterCount() {
		return monsterCount;
	}

}
