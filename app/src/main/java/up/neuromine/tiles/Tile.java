package up.neuromine.tiles;

import up.neuromine.map.Map;

public abstract class Tile {
    private Map map;
    protected Boolean revealed = false;
    protected Boolean covered = false;


    public Tile(Map map){
        this.map = map;
    }

    public Map getMap(){
        return this.map;
    }

    public void reveal(){
        this.revealed = true;
    }

    public void coverWithFlag(){
        this.covered = true;
    }

    public void uncovered(){
        this.covered = false;
    }

    public Boolean isCovered(){
        return this.covered;
    }

    public Boolean isRevealed(){
        return this.revealed;
    }

}
