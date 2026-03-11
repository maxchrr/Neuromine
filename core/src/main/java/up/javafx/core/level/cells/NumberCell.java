package up.javafx.core.level.cells;

/**
 * A tile that displays the number of surrounding threats.
 */
public class NumberCell extends Cell {

	private int mineCount = 0;
	private int monsterCount = 0;

	public NumberCell(int x, int y) {
		super(CellType.NUMBER, x, y);
	}

	public void setThreatCount(int mines, int monsters) {
		this.mineCount = mines;
		this.monsterCount = monsters;
	}

	public int getMineCount() {
		return mineCount;
	}

	public int getMonsterCount() {
		return monsterCount;
	}

}
