package up.javafx.core.level.cells;

import up.javafx.core.entity.enemy.Enemy;
import up.javafx.core.entity.player.Player;
import up.javafx.core.level.Position;

public class EnemyCell extends Cell {

    private final Enemy enemy;

    public EnemyCell(Position position, Enemy enemy) {
        super(position);
        this.enemy = enemy;
    }

    @Override public void     onEnter(Player player) { reveal(); }
    @Override public CellType getType()              { return CellType.MONSTER; }
    public Enemy getEnemy() { return enemy; }
}
