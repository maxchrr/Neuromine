package up.javafx.core.level.cells;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Position;
import up.javafx.core.level.mine.Mine;

public class MineCell extends Cell {

    private final Mine mine;

    public MineCell(Position position, Mine mine) {
        super(position);
        this.mine = mine;
    }

    @Override
    public void onEnter(Player player) {
        if (isFlagged()) return;
        reveal();
        mine.trigger(player);
    }

    @Override public CellType getType() { return CellType.MINE; }
    public Mine getMine() { return mine; }
}
