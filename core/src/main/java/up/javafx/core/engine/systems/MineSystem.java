package up.javafx.core.engine.systems;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.cells.MineCell;

public class MineSystem {

    public void trigger(Player player, MineCell cell) {
        cell.getMine().trigger(player);
    }
}
