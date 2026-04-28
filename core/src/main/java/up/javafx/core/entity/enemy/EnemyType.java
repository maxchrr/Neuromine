package up.javafx.core.entity.enemy;

public enum EnemyType {
    GOBLIN (3, 1),
    SKELETON(4, 2),
    BOSS   (10, 4);

    public final int hp;
    public final int attack;

    EnemyType(int hp, int attack) {
        this.hp     = hp;
        this.attack = attack;
    }
}
