package up.javafx.core.entity.enemy;

import up.javafx.core.entity.Entity;
import up.javafx.core.level.Position;

public abstract class Enemy extends Entity {

    protected final EnemyType type;

    protected Enemy(EnemyType type, Position position) {
        super(type.hp, position);
        this.type = type;
    }

    public EnemyType getType()   { return type; }
    public int       getAttack() { return type.attack; }
}
