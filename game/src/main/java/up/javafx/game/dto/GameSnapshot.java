package up.javafx.game.dto;

import up.javafx.core.engine.systems.GameState;
import up.javafx.core.level.Grid;
import up.javafx.core.level.Position;

public record GameSnapshot(
        Grid      grid,
        Position  playerPosition,
        int       playerHp,
        int       playerMaxHp,
        int       score,
        GameState state
) {}
