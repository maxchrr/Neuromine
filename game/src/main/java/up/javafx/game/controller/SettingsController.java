package up.javafx.game.controller;

import up.javafx.game.model.SettingsModel;
import up.javafx.mvc.Controller;
import up.javafx.mvc.View;

public class SettingsController extends Controller<SettingsModel, View> {

    public SettingsController(SettingsModel model, View view) {
        super(model, view);
    }

    @Override
    protected void init() {
    }

    public void setVolume(double value) {
        model.volumeProperty().set(value);
    }

    public void toggleFullscreen() {
        boolean current = model.fullscreenProperty().get();
        model.fullscreenProperty().set(!current);
    }

    public void updateResolution(String res) {
        model.resolutionProperty().set(res);
    }
}
