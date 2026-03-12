package up.javafx.core.engine.systems;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Direction;
import up.javafx.core.level.Grid;
import up.javafx.core.level.Position;

public class MovementSystem {

	public void move(Player player, Direction direction, Grid grid) {
		Position pos = player.getPosition();
		int newRow = pos.x() + direction.dx();
		int newCol = pos.y() + direction.dy();
		if (!grid.isInside(newRow, newCol))
			return;
		player.moveTo(new Position(newRow, newCol));
	}
}
