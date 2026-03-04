package up.neuromine.mine;

import up.neuromine.caracters.BaseCaracter;

public class NormalMine extends Mine{
    
    public NormalMine(int rayonAction){
        super(rayonAction);
    }

    @Override
    public void explode(BaseCaracter cible){
        cible.takeDamage(20);
    }

}
