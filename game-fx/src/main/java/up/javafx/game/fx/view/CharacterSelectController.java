package up.javafx.game.fx.view;

import up.javafx.core.entity.player.characters.CharacterType;
import up.javafx.game.model.CharacterSelectModel;
import up.javafx.mvc.Controller;

public class CharacterSelectController extends Controller<CharacterSelectModel, CharacterSelectView> {

    public interface CharacterLauncher {
        void launch(CharacterType type);
    }
    
    private CharacterLauncher launcher;

    public CharacterSelectController(CharacterSelectModel model, CharacterSelectView view) {
        super(model, view);
    }

    public void setCharacterLauncher(CharacterLauncher launcher) {
        this.launcher = launcher;
    }

    @Override
    protected void init() {
        view.getBtnBandit().setOnAction(e -> triggerLaunch(CharacterType.BANDIT));
        view.getBtnDuchess().setOnAction(e -> triggerLaunch(CharacterType.DUCHESS));
        view.getBtnKnight().setOnAction(e -> triggerLaunch(CharacterType.KNIGHT));
        view.getBtnPaladin().setOnAction(e -> triggerLaunch(CharacterType.PALADIN));
    }

    private void triggerLaunch(CharacterType type) {
        if (launcher != null) {
            launcher.launch(type);
        }
    }
}