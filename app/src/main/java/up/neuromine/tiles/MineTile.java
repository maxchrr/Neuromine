package up.neuromine.tiles;

import java.util.Map;

public class MineTile extends Tile{
    
    private Mine mine;

    public MineTile(Map map , Mine mine){
        super(map);
        this.mine=mine;
    }

    @Override
    public void coverWithFlag(){
        if (!this.isCovered()){
            this.covered = true;
            this.addMineCount(this.getMap());
        }
        
    }
    
    public void addMineCount(Map map){
            map.addDiscovered();
    }

    public void uncovered(){
        if (this.isCovered()){
            this.covered = false;
            this.subMineCount(this.getMap());
        }
    }

    public void subMineCount(Map map){
        map.subDiscovered();
    }
}
