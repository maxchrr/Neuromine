package up.javafx.core.level;

import up.javafx.core.level.tiles.*;

/**
 * Core logic for the game grid.
 * Responsible for tile storage, bounds checking, and proximity calculations
 * for both mines (radius 1) and monsters (radius 2).
 */
public class Grid {

	private final int size;
	private final Tile[][] tiles;

	private int nbMines;
	private int nbDiscovered;

	/**
	 * Initializes an empty grid of a given size.
	 * 
	 * @param size The width and height of the square grid.
	 */
	public Grid(int size) {
		this.size = size;
		this.tiles = new Tile[size][size];
		this.nbMines = 0;
		this.nbDiscovered = 0;

		// Default initialization with EmptyCells
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				tiles[x][y] = new EmptyTile(this, x, y);
			}
		}
	}

	/**
	 * Checks if the given coordinates are within the grid boundaries.
	 * 
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @return true if coordinates are valid.
	 */
	public boolean isInside(int x, int y) {
		return x >= 0 && x < size && y >= 0 && y < size;
	}

	/**
	 * Calculates the number of mines in a radius of 1.
	 * Standard Minesweeper logic.
	 * 
	 * @param x X coordinate of the center cell
	 * @param y Y coordinate of the center cell
	 * @return Number of MineTile in the 3x3 area around (x,y).
	 */
	public int countMinesAround(int x, int y) {
		int count = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0)
					continue; // Skip center

				int nextX = x + i;
				int nextY = y + j;

				if (isInside(nextX, nextY) && tiles[nextX][nextY] instanceof MineTile) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Calculates the number of monsters in a radius of 2.
	 * 
	 * @param x X coordinate of the center cell
	 * @param y Y coordinate of the center cell
	 * @return Number of MonsterTile with living enemies in a 5x5 area.
	 */
	public int countMonstersAround(int x, int y) {
		int count = 0;
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				if (i == 0 && j == 0)
					continue; // Skip center

				int nextX = x + i;
				int nextY = y + j;

				if (isInside(nextX, nextY)) {
					Tile tile = getTile(nextX, nextY);
					if (tile instanceof MonsterTile && ((MonsterTile) tile).hasLivingMonster()) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public int getSize() {
		return size;
	}

	public Tile getTile(int x, int y) {
		return isInside(x, y) ? tiles[x][y] : null;
	}

	public void setTile(int x, int y, Tile tile) {
		if (isInside(x, y)) {
			tiles[x][y] = tile;
		}
	}

	public int getNbMines() {
		return nbMines;
	}

	public int getNbDiscovered() {
		return nbDiscovered;
	}

	public void addMine() {
		nbMines++;
	}

	public void subMine() {
		nbMines--;
	}

	public void addDiscovered() {
		nbDiscovered++;
	}

	public void subDiscovered() {
		nbDiscovered--;
	}

}
