package up.javafx.core.level;

import up.javafx.core.entity.enemy.Enemy;
import up.javafx.core.entity.enemy.GoblinEnemy;
import up.javafx.core.level.cells.*;
import up.javafx.core.level.mine.Mine;
import up.javafx.core.level.mine.NormalMine;

import java.util.Random;

/**
 * Core logic for the game grid.
 * Stores cells, calculates threats, and provides utility methods for the
 * player.
 */
public class Grid {

	private final int rows;
	private final int cols;
	private final Cell[][] cells;

	private int nbMines;
	private int nbDiscovered;

	private final Random random = new Random();

	public Grid(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.cells = new Cell[rows][cols];
		this.nbMines = 0;
		this.nbDiscovered = 0;

		// Initialize with empty cells
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				cells[x][y] = new EmptyCell(new Position(x, y));
			}
		}
	}

	// -------------------------
	// Cell retrieval / placement
	// -------------------------

	public boolean isInside(int row, int col) {
		return row >= 0 && row < rows && col >= 0 && col < cols;
	}

	public Cell getCell(int row, int col) {
		return isInside(row, col) ? cells[row][col] : null;
	}

	public void setCell(int row, int col, Cell cell) {
		if (isInside(row, col))
			cells[row][col] = cell;
	}

	// -------------------------
	// Threat counting
	// -------------------------

	/**
	 * Counts the number of mines around a given cell (radius = 1).
	 */
	public int countMinesAround(int row, int col) {
		int count = 0;
		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				int nx = row + dr;
				int ny = col + dc;
				if ((dr != 0 || dc != 0) && isInside(nx, ny)) {
					if (getCell(nx, ny) instanceof MineCell)
						count++;
				}
			}
		}
		return count;
	}

	/**
	 * Counts the number of monsters around a given cell (radius = 2).
	 */
	public int countMonstersAround(int row, int col) {
		int count = 0;
		for (int dr = -2; dr <= 2; dr++) {
			for (int dc = -2; dc <= 2; dc++) {
				int nx = row + dr;
				int ny = col + dc;
				if ((dr != 0 || dc != 0) && isInside(nx, ny)) {
					if (getCell(nx, ny) instanceof MonsterCell monsterCell) {
						if (monsterCell.hasLivingMonster())
							count++;
					}
				}
			}
		}
		return count;
	}

	// -------------------------
	// Grid generation
	// -------------------------

	/**
	 * Randomly places a given number of mines on the grid.
	 */
	public void placeMines(int count) {
		int placed = 0;
		while (placed < count) {
			int r = random.nextInt(rows);
			int c = random.nextInt(cols);
			if (!(cells[r][c] instanceof MineCell)) {
				Mine mine = new NormalMine(1);
				cells[r][c] = new MineCell(new Position(r, c), mine);
				nbMines++;
				placed++;
			}
		}
	}

	/**
	 * Randomly places monsters on the grid.
	 */
	public void placeMonsters(int count, Enemy prototype) {
		int placed = 0;
		while (placed < count) {
			int r = random.nextInt(rows);
			int c = random.nextInt(cols);
			if (cells[r][c] instanceof EmptyCell) {
				Enemy enemy = new GoblinEnemy();
				cells[r][c] = new MonsterCell(new Position(r, c), enemy);
				placed++;
			}
		}
	}

	/**
	 * Computes the NumberCell values for all non-mine, non-monster cells.
	 */
	public void computeNumberCells() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Cell cell = cells[r][c];
				if (cell instanceof EmptyCell) {
					NumberCell numberCell = new NumberCell(cell.getPosition());
					numberCell.setThreatCount(countMinesAround(r, c), countMonstersAround(r, c));
					cells[r][c] = numberCell;
				}
			}
		}
	}

	// -------------------------
	// Counters
	// -------------------------

	public int getNbMines() {
		return nbMines;
	}

	public int getNbDiscovered() {
		return nbDiscovered;
	}

	public void addDiscovered() {
		nbDiscovered++;
	}

	public void subDiscovered() {
		nbDiscovered--;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
}
