package up.javafx.core.level.cells;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Position;

public class NumberCell extends Cell {

    private final int adjacentMines;
    private final int adjacentMonsters;

    public NumberCell(Position position, int adjacentMines, int adjacentMonsters) {
        super(position);
        this.adjacentMines    = adjacentMines;
        this.adjacentMonsters = adjacentMonsters;
    }

    @Override public void     onEnter(Player player) { reveal(); }
    @Override public CellType getType()              { return CellType.NUMBER; }

    public int getAdjacentMines()    { return adjacentMines; }
    public int getAdjacentMonsters() { return adjacentMonsters; }
}
