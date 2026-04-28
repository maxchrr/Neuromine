package up.javafx.game.text.view;

import up.javafx.game.dto.GameSnapshot;
import up.javafx.mvc.View;

public class GameTextView implements View {

    public void render(GameSnapshot snapshot) {
        System.out.print(TextRenderer.render(snapshot));
    }
}
