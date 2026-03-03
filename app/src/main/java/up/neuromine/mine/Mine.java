package up.neuromine.mine;

public abstract class Mine {
    protected int rayonAction;

    public Mine(int rayonAction){
        this.rayonAction = rayonAction;
    }

    public int getRayon(){
        return this.rayonAction;
    }

    public void explode(){
    }
}
