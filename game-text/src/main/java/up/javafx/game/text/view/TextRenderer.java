package up.javafx.game.text.view;

import up.javafx.core.level.Grid;
import up.javafx.core.level.cells.*;
import up.javafx.game.dto.GameSnapshot;

public class TextRenderer {

    public static String render(GameSnapshot s) {
        Grid grid = s.grid();
        var sb = new StringBuilder();
        sb.append(String.format("HP: %d/%d  Score: %d  [%s]%n",
                s.playerHp(), s.playerMaxHp(), s.score(), s.state()));

        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getCols(); c++) {
                boolean isPlayer = s.playerPosition().x() == c && s.playerPosition().y() == r;
                if (isPlayer) { sb.append('@'); continue; }
                Cell cell = grid.getCell(r, c);
                if (!cell.isRevealed()) {
                    sb.append(cell.isFlagged() ? 'F' : '?');
                } else {
                    sb.append(switch (cell.getType()) {
                        case EMPTY   -> '.';
                        case MINE    -> '*';
                        case MONSTER -> 'M';
                        case WALL    -> '#';
                        case NUMBER  -> {
                            int n = ((NumberCell) cell).getAdjacentMines();
                            yield n > 9 ? '+' : (char) ('0' + n);
                        }
                    });
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
