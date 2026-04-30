package up.javafx.game.fx.view;

import up.javafx.game.model.LevelSelectModel;
import up.javafx.mvc.Controller;

public class LevelSelectController extends Controller<LevelSelectModel, LevelSelectView> {

    public interface GameLauncher {
        void launch(int size, int mines, int enemies);
    }
    
    private GameLauncher launcher;

    public LevelSelectController(LevelSelectModel model, LevelSelectView view) {
        super(model, view);
    }

    public void setGameLauncher(GameLauncher launcher) {
        this.launcher = launcher;
    }

    @Override
    protected void init() {
        view.getBtnEasy().setOnAction(e -> {
            if (launcher != null) launcher.launch(10, 15, 5);
        });
        
        view.getBtnMedium().setOnAction(e -> {
            if (launcher != null) launcher.launch(15, 30, 10);
        });
        
        view.getBtnHard().setOnAction(e -> {
            if (launcher != null) launcher.launch(20, 60, 20);
        });
    }
}