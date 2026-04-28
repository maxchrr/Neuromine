package up.javafx.core.engine.systems;

import up.javafx.core.entity.enemy.Enemy;
import up.javafx.core.entity.player.Player;

public class CombatSystem {

    public void fight(Player player, Enemy enemy) {
        while (player.isAlive() && enemy.isAlive()) {
            enemy.takeDamage(player.getCharacter().getAttack());
            if (enemy.isAlive())
                player.takeDamage(enemy.getAttack());
        }
    }
}
