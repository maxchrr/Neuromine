package up.javafx.game.fx.view;

import javafx.beans.property.*;
import up.javafx.mvc.Model;

public class SettingsModel extends Model {
    private final DoubleProperty volume = new SimpleDoubleProperty(50);
    private final BooleanProperty fullscreen = new SimpleBooleanProperty(false);
    private final ObjectProperty<String> resolution = new SimpleObjectProperty<>("1280x720");

    public DoubleProperty volumeProperty() { return volume; }
    public BooleanProperty fullscreenProperty() { return fullscreen; }
    public ObjectProperty<String> resolutionProperty() { return resolution; }
}
