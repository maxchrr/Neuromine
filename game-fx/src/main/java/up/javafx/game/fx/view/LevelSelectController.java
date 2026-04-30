package up.javafx.game.fx.view;

import javafx.stage.FileChooser;
import java.io.File;
import up.javafx.core.io.Level;
import up.javafx.core.io.LevelRepository;
import up.javafx.game.model.LevelSelectModel;
import up.javafx.game.fx.view.LevelSelectView;
import up.javafx.mvc.Controller;

public class LevelSelectController extends Controller<LevelSelectModel, LevelSelectView> {

    public interface GameLauncher {
        void launchRandom(int size, int mines, int enemies);
        void launchCustom(Level level);
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
        view.getBtnEasy().setOnAction(e -> { if (launcher != null) launcher.launchRandom(10, 15, 5); });
        view.getBtnMedium().setOnAction(e -> { if (launcher != null) launcher.launchRandom(15, 30, 10); });
        view.getBtnHard().setOnAction(e -> { if (launcher != null) launcher.launchRandom(20, 60, 20); });

        view.getBtnLoadCustom().setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Custom Level");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Level Files", "*.json"));
            
            File defaultDirectory = new File("levels");

            if (defaultDirectory.exists() && defaultDirectory.isDirectory()) {
                fileChooser.setInitialDirectory(defaultDirectory);
            }

            File file = fileChooser.showOpenDialog(null);
            
            if (file != null) {
                try {
                    Level customLevel = LevelRepository.load(file.toPath());
                    if (launcher != null) {
                        launcher.launchCustom(customLevel);
                    }
                } catch (Exception ex) {
                    System.err.println("Erreur de chargement du niveau : " + ex.getMessage());
                }
            }
        });
    }
}