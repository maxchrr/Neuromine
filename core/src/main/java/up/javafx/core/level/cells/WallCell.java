package up.javafx.core.level.cells;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Position;

public class WallCell extends Cell {

    public WallCell(Position position) { super(position); }

    @Override public void     onEnter(Player player) {}
    @Override public CellType getType()              { return CellType.WALL; }
}
