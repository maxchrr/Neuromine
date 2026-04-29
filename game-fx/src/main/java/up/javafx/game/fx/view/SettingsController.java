package up.javafx.game.fx.view;

import javafx.stage.Stage;
import up.javafx.mvc.Controller;

public class SettingsController extends Controller<SettingsModel, SettingsView> {

    private final Stage primaryStage;

    public SettingsController(SettingsModel model, SettingsView view, Stage primaryStage) {
        // On passe le modèle et la vue à la classe parente
        super(model, view);
        this.primaryStage = primaryStage;
    }

    @Override
    protected void init() {
        // 1. Liaison bidirectionnelle pour le Volume
        // Si on bouge le slider, le modèle change. Si le modèle change, le slider bouge.
        view.getVolSlider().valueProperty().bindBidirectional(model.volumeProperty());

        // 2. Gestion du bouton Mute
        view.getBtnMute().setOnAction(event -> {
            model.volumeProperty().set(0);
        });

        // 3. Gestion du Fullscreen
        view.getBtnFullscreen().setOnAction(event -> {
            // On inverse l'état actuel dans le modèle
            model.fullscreenProperty().set(!model.fullscreenProperty().get());
        });

        // On écoute le modèle pour appliquer le changement au Stage
        model.fullscreenProperty().addListener((obs, oldVal, isFull) -> {
            primaryStage.setFullScreen(isFull);
            view.getBtnFullscreen().setText(isFull ? "On" : "Off");
        });

        // 4. Gestion de la Résolution (via les MenuItem)
        // Note : On suppose que tu as ajouté des getters pour tes MenuItem dans SettingsView
        view.getItem1920().setOnAction(e -> model.resolutionProperty().set("1920x1080"));
        view.getItem1680().setOnAction(e -> model.resolutionProperty().set("1680x1050"));
        view.getItem1280().setOnAction(e -> model.resolutionProperty().set("1280x720"));

        // On écoute le changement de résolution dans le modèle
        model.resolutionProperty().addListener((obs, oldRes, newRes) -> {
            applyResolution(newRes);
            view.getResMenu().setText("Current : " + newRes);
        });
    }

    private void applyResolution(String res) {
        String[] parts = res.split("x");
        if (parts.length == 2) {
            primaryStage.setWidth(Double.parseDouble(parts[0]));
            primaryStage.setHeight(Double.parseDouble(parts[1]));
        }
    }
}
