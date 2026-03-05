package up.neuromine.core.level;

import up.neuromine.core.level.cells.Cell;

/**
 * Core logic for the game grid.
 * Handles cell states and proximity calculations.
 */
public class Grid {

	private final int size;
	private final Cell[][] cells;

	private int nbMines;
	private int nbDiscovered;

	public Grid(int size) {
		this.size = size;
		this.cells = new Cell[size][size];

		this.nbMines = 0;
		this.nbDiscovered = 0;
	}

	/**
	 * Calculates the number of mines in a radius of 1.
	 */
	public int countMinesAround(int x, int y) {
		// Logic for radius 1
		return 0;
	}

	/**
	 * Calculates the number of monsters in a radius of 2.
	 */
	public int countMonstersAround(int x, int y) {
		// Logic for radius 2
		return 0;
	}

	public int getNbMines() {
		return nbMines;
	}

	public int getNbDiscovered() {
		return nbDiscovered;
	}

	public void addMine() {
		nbMines += 1;
	}

	public void subMine() {
		nbMines -= 1;
	}

	public void addDiscovered() {
		nbDiscovered += 1;
	}

	public void subDiscovered() {
		nbDiscovered -= 1;
	}
}
