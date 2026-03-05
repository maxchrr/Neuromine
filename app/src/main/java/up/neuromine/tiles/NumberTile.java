package up.neuromine.tiles;

import up.neuromine.map.Map;

public class NumberTile extends Tile{
    private int number;

    public NumberTile(Map map,int n){
        super(map);
        this.number = n;
    }
}
