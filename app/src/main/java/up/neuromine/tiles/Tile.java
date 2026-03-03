package up.neuromine.tiles;

public abstract class Tile {
    private Map map;
    private Boolean revealed = false;
    private Boolean covered = false;


    public Tile(Map map){
        this.map = map;
    }

    public Map getMap(){
        return this.map;
    }

    public void Reveal(){
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
