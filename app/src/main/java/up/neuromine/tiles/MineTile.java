package up.neuromine.tiles;


import up.neuromine.map.Map;
import up.neuromine.mine.Mine;

public class MineTile extends Tile{
    
    private Mine mine;

    public MineTile(Map map , Mine mine){
        super(map);
        this.mine=mine;
    }

    public Mine getMine(){
        return this.mine;
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

    @Override
    public void uncovered(){
        if (this.isCovered()){
            this.covered = false;
            this.subMineCount(this.getMap());
        }
    }

    public void subMineCount(Map map){
        map.subDiscovered();
    }

    @Override
    public void reveal(){
        this.revealed = true;
        getMine().explode();
    }
}
