package up.javafx.core.entity;

import up.javafx.core.level.Position;

public abstract class Entity {

    protected int hp;
    protected final int maxHp;
    protected Position position;

    protected Entity(int hp, Position position) {
        this.hp       = hp;
        this.maxHp    = hp;
        this.position = position;
    }

    public void takeDamage(int amount) { hp = Math.max(0, hp - amount); }
    public void heal(int amount)       { hp = Math.min(maxHp, hp + amount); }
    public boolean isAlive()           { return hp > 0; }
    public void moveTo(Position pos)   { position = pos; }

    public int      getHp()       { return hp; }
    public int      getMaxHp()    { return maxHp; }
    public Position getPosition() { return position; }
}
