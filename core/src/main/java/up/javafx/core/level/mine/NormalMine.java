package up.javafx.core.level.mine;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.cells.Cell;

public class NormalMine implements Mine {

    private static final int DAMAGE = 10;
    private boolean active = true;
    private Cell cell;

    @Override
    public void trigger(Player player) {
        if (active) {
            player.takeDamage(DAMAGE);
            active = false;
        }
    }

    @Override public boolean isActive()        { return active; }
    @Override public void    setCell(Cell cell) { this.cell = cell; }
    @Override public Cell    getCell()          { return cell; }
}
