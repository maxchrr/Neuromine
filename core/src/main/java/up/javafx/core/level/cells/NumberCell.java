package up.javafx.core.level.cells;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Position;

/**
 * A cell that shows the number of threats (mines and monsters) around it.
 */
public class NumberCell extends Cell {

	private int mineCount = 0;
	private int monsterCount = 0;

	public NumberCell(Position position) {
		super(position);
	}

	@Override
	public void onEnter(Player player) {
		reveal();
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

	public int totalThreats() {
		return mineCount + monsterCount;
	}

	@Override
	public CellType getType() {
		return CellType.NUMBER;
	}
}
