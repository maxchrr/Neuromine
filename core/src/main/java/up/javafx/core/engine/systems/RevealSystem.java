package up.javafx.core.engine.systems;

import up.javafx.core.level.Grid;
import up.javafx.core.level.Position;
import up.javafx.core.level.cells.Cell;
import up.javafx.core.level.cells.EmptyCell;

public class RevealSystem {

	public void reveal(Cell cell, Grid grid) {
		if (cell.isRevealed())
			return;

		cell.reveal();

		if (cell instanceof EmptyCell emptyCell)
			floodReveal(emptyCell.getPosition(), grid);
	}

	private void floodReveal(Position pos, Grid grid) {
		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				int nx = pos.x() + dr;
				int ny = pos.y() + dc;
				if ((dr != 0 || dc != 0) && grid.isInside(nx, ny)) {
					Cell neighbor = grid.getCell(nx, ny);
					if (!neighbor.isRevealed())
						reveal(neighbor, grid);
				}
			}
		}
	}
}
