package up.javafx.game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application {

	private GridPane board = new GridPane();
	private TextField inputN = new TextField();

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox(15);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-padding: 20;");

		Label label = new Label("Taille de la map (N) :");
		inputN.setMaxWidth(100);
		Button btnSolve = new Button("Afficher la map");
		board.setAlignment(Pos.CENTER);

		root.getChildren().addAll(label, inputN, btnSolve, board);

		btnSolve.setOnAction(e -> {
			try {
				int n = Integer.parseInt(inputN.getText());
				drawBoard(n);
			} catch (NumberFormatException ex) {
				System.out.println("Entrez un nombre valide");
			}
		});

		Scene scene = new Scene(root, 400, 300);
		primaryStage.setTitle("Neuromine");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void drawBoard(int n) {
		board.getChildren().clear();
		int cellSize = 40; // Reduced size slightly to fit larger grids

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				Rectangle rect = new Rectangle(cellSize, cellSize);
				rect.setFill(Color.LIGHTCORAL);
				rect.setStroke(Color.BLACK);
				rect.setVisible(false); 

				Button button = new Button();
				button.setPrefSize(cellSize, cellSize);

				button.setOnAction(e -> {
					rect.setVisible(true);
					button.setVisible(false);
				});

				StackPane cell = new StackPane(rect, button);

				board.add(cell, col, row);
			}
		}
	}

}
