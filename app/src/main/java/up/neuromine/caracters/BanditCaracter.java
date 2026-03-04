package up.neuromine.caracters;

public class BanditCaracter extends BaseCaracter{

    public BanditCaracter() {
        super("Bandit", 3, 1, 2);
    }

    /*Movements : diagonal or adjacant */
    @Override
    public void move() {
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    /*Attack : A leap forward by one or two Tiles dealing 2 damage on the selected Tile */
    @Override
    public void attack() {
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }

    /*Special Capacity : */
    @Override
    public void speCapacity() {
        throw new UnsupportedOperationException("Unimplemented method 'speCapacity'");
    }

}
