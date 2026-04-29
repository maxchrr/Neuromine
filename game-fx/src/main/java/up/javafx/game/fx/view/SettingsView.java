package up.javafx.game.fx.view;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import up.javafx.mvc.View;

public class SettingsView implements View {
    
    // 1. On déclare TOUTES les variables ici pour qu'elles existent dans toute la classe
    private final VBox rootNode;
    private final Slider volSlider;
    private final Button btnMute;
    private final Button btnBack;
    private final Button btnFullscreen;
    private final MenuButton resMenu;
    private final MenuItem item1;
    private final MenuItem item2;
    private final MenuItem item3;

    public SettingsView() {
        // 2. On les initialise dans le constructeur
        this.rootNode = new VBox(10);
        this.rootNode.setAlignment(javafx.geometry.Pos.CENTER);
        this.rootNode.setFillWidth(true);
        
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
        
        // On assemble le tout
        this.rootNode.getChildren().addAll(hboxVol, hboxfullscreen, resMenu, btnBack);
    }

    // 3. Et voici tous les Getters dont le Contrôleur et la MainPage ont besoin !
    public VBox getRootNode() { return rootNode; }
    public Slider getVolSlider() { return volSlider; }
    public Button getBtnMute() { return btnMute; }
    public Button getBtnBack() { return btnBack; }
    public Button getBtnFullscreen() { return btnFullscreen; }
    public MenuButton getResMenu() { return resMenu; }
    public MenuItem getItem1920() { return item1; }
    public MenuItem getItem1680() { return item2; }
    public MenuItem getItem1280() { return item3; }
}