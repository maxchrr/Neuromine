package up.javafx.game.fx.view;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import up.javafx.mvc.View;

public class SettingsView extends VBox implements View {

    private final Slider volSlider;
    private final Button btnMute;
    private final Button btnBack;
    private final Button btnFullscreen;
    private final MenuButton resMenu;
    private final MenuItem item1;
    private final MenuItem item2;
    private final MenuItem item3;

    public SettingsView() {
        setAlignment(javafx.geometry.Pos.CENTER);
        setFillWidth(true);
        setSpacing(10); // Ajout d'un petit espacement

        this.volSlider = new Slider(0, 100, 50);
        this.btnMute = new Button("Mute");
        this.btnBack = new Button("Back to Main Menu");
        this.btnFullscreen = new Button("Off");

        HBox hboxfullscreen = new HBox(10, new Label("Fullscreen : ") ,btnFullscreen);
        hboxfullscreen.setAlignment(javafx.geometry.Pos.CENTER);

        this.item1 = new MenuItem("1920x1080");
        this.item2 = new MenuItem("1680x1050");
        this.item3 = new MenuItem("1280x720");

        this.resMenu = new MenuButton("Resolution");
        this.resMenu.getItems().addAll(item1, item2, item3);

        HBox hboxVol = new HBox(10, new Label("Volume : "), volSlider, btnMute);
        hboxVol.setAlignment(javafx.geometry.Pos.CENTER);

        getChildren().addAll(hboxVol, hboxfullscreen, resMenu, btnBack);
    }

    public Slider getVolSlider() {
        return volSlider;
    }

    public Button getBtnMute() {
        return btnMute;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public Button getBtnFullscreen() {
        return btnFullscreen;
    }

    public MenuButton getResMenu() {
        return resMenu;
    }

    public MenuItem getItem1() {
        return item1;
    }

    public MenuItem getItem2() {
        return item2;
    }

    public MenuItem getItem3() {
        return item3;
    }
}
