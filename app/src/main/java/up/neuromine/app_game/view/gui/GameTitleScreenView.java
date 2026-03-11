package up.neuromine.app_game.view.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameTitleScreenView extends Application {

    @Override
	public void start(Stage primaryStage){

        StackPane root = new StackPane();

        VBox mid = new VBox(10);

        Button sng = new Button("single player");
        Button mltp = new Button("multiplayer");
        Button quitButton = new Button("Quit");
            quitButton.setOnAction(event -> {
                Platform.exit();
        });
        Button settings = new Button("settings");

        mid.getChildren().addAll(sng,mltp);

        mid.setAlignment(Pos.CENTER);
        StackPane.setAlignment(quitButton, Pos.TOP_LEFT);
        StackPane.setAlignment(settings, Pos.BOTTOM_RIGHT);

        Image bgImage = new Image("file:bbbb.jpeg");
        ImageView background = new ImageView(bgImage);

        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty()); 

        root.getChildren().addAll(background,mid,quitButton,settings);


        sng.setOnMouseEntered(e -> sng.setStyle("-fx-background-color: #ff0000; -fx-text-fill: white;"));
        sng.setOnMouseExited(e -> sng.setStyle(""));
        mltp.setOnMouseEntered(e -> mltp.setStyle("-fx-background-color: #ff0000; -fx-text-fill: white;"));
        mltp.setOnMouseExited(e -> mltp.setStyle(""));
        quitButton.setOnMouseEntered(e -> quitButton.setStyle("-fx-background-color: #ff0000; -fx-text-fill: white;"));
        quitButton.setOnMouseExited(e -> quitButton.setStyle(""));
        settings.setOnMouseEntered(e -> settings.setStyle("-fx-background-color: #02f322ff; -fx-text-fill: white;"));
        settings.setOnMouseExited(e -> settings.setStyle(""));




        Scene scene = new Scene(root,300,200);

	    primaryStage.setScene(scene);

	    primaryStage.show();

	}

}

