package up.javafx.core.engine.systems;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Direction;
import up.javafx.core.level.Grid;
import up.javafx.core.level.Position;

public class MovementSystem {

    public boolean move(Player player, Direction dir, Grid grid) {
        Position pos  = player.getPosition();
        int newX = pos.x() + dir.dx;
        int newY = pos.y() + dir.dy;
        if (!grid.isInside(newY, newX)) return false;
        player.moveTo(new Position(newX, newY));
        return true;
    }
}
