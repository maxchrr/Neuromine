package up.javafx.core.level.cells;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Position;

public abstract class Cell {

    protected final Position position;
    protected boolean revealed = false;
    protected boolean flagged  = false;

    protected Cell(Position position) { this.position = position; }

    public abstract void     onEnter(Player player);
    public abstract CellType getType();

    public void    reveal()      { revealed = true; }
    public void    toggleFlag()  { flagged = !flagged; }
    public boolean isRevealed()  { return revealed; }
    public boolean isFlagged()   { return flagged; }
    public Position getPosition(){ return position; }
}
