package up.javafx.game.fx.view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import up.javafx.core.level.cells.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CellView extends StackPane {

    static final int SIZE = 40;

    private static final Image IMG_FLAG = new Image(CellView.class.getResourceAsStream("/flag.png"));
    private static final Image IMG_MINE = new Image(CellView.class.getResourceAsStream("/mineSpe1.png"));

    public CellView(Cell cell, boolean isPlayer) {
        Rectangle rect = new Rectangle(SIZE, SIZE);
        rect.setStroke(Color.GRAY);
        rect.setStrokeWidth(0.5);
        
        getChildren().add(rect);

        if (isPlayer) {
            rect.setFill(Color.DODGERBLUE);
            Text playerText = new Text("@");
            playerText.setFill(Color.WHITE);
            playerText.setFont(Font.font("System", FontWeight.BOLD, 18));
            getChildren().add(playerText);
            
        } else if (!cell.isRevealed()) {
            rect.setFill(cell.isFlagged() ? Color.YELLOW : Color.DARKGRAY);
            if (cell.isFlagged()) {
                getChildren().add(new Text("F"));
            }
            
        } else {
            rect.setFill(FxRenderer.colorForType(cell.getType()));
            
            if (cell.isFlagged()) {
                ImageView flagView = new ImageView(IMG_FLAG);
                flagView.setFitWidth(30);
                flagView.setFitHeight(30);
                getChildren().add(flagView);
            } else if (cell.getType() == CellType.NUMBER) {
                NumberCell nc = (NumberCell) cell;
                
                HBox hbox = new HBox(4);
                hbox.setAlignment(Pos.CENTER);
                
                if (nc.getAdjacentMines() > 0) {
                    Text mineText = new Text(String.valueOf(nc.getAdjacentMines()));
                    mineText.setFill(Color.RED);
                    mineText.setFont(Font.font("System", FontWeight.BOLD, 14));
                    hbox.getChildren().add(mineText);
                }
                
                if (nc.getAdjacentMonsters() > 0) {
                    Text monsterText = new Text(String.valueOf(nc.getAdjacentMonsters()));
                    monsterText.setFill(Color.PURPLE);
                    monsterText.setFont(Font.font("System", FontWeight.BOLD, 14));
                    hbox.getChildren().add(monsterText);
                }
                
                getChildren().add(hbox);
                
            } else if (cell.getType() == CellType.MINE) {
                ImageView mineView = new ImageView(IMG_MINE);
                mineView.setFitWidth(30);
                mineView.setFitHeight(30);
                getChildren().add(mineView);
            } else {
                Text content = new Text(switch (cell.getType()) {
                    case MONSTER -> {
                        EnemyCell ec = (EnemyCell) cell;
                        yield ec.getEnemy().isAlive() ? "M" : "Dead"; 
                    }
                    case WALL    -> "▪";
                    default      -> "";
                });
                
                if (cell.getType() == CellType.MONSTER && !((EnemyCell) cell).getEnemy().isAlive()) {
                    content.setFill(Color.DARKGRAY);
                }
                
                getChildren().add(content);
            }
        }
    }
}