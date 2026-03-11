package up.javafx.core.level.cells;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Position;

/**
 * Abstract base class for all types of cells.
 */
public abstract class Cell {

	protected final Position position;
	protected boolean revealed = false;
	protected boolean flagged = false;

	public Cell(Position position) {
		this.position = position;
	}

	/**
	 * Logic executed when the player steps on this cell.
	 */
	public abstract void onEnter(Player player);

	/**
	 * Reveals the cell if it is not flagged.
	 */
	public void reveal() {
		if (!flagged && !revealed)
			this.revealed = true;
	}

	/**
	 * Toggles a flag on the cell if it is not revealed.
	 */
	public void toggleFlag() {
		if (!revealed)
			this.flagged = !this.flagged;
	}

	/**
	 * Removes a flag if present.
	 */
	public void uncovered() {
		if (flagged)
			this.flagged = false;
	}

	public boolean isRevealed() {
		return revealed;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public Position getPosition() {
		return position;
	}

	public abstract CellType getType();
}
