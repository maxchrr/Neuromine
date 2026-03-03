package up.neuromine.tiles;

public class NumberTile extends Tile{
    private int number;

    public NumberTile(Map map,int n){
        super(map);
        this.number = n;
    }
}
