package up.javafx.core.level.mine;

import up.javafx.core.level.cells.Cell;
import up.javafx.core.entity.player.Player;

public interface Mine {

	void trigger(Player player);

	boolean isActive();

	void setCell(Cell cell);

	Cell getCell();
}
