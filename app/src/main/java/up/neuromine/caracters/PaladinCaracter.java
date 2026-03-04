package up.neuromine.caracters;

public class PaladinCaracter extends BaseCaracter {

    public PaladinCaracter() {
        super("Paladin", 5, 2, 1);
    }

    /*Movements : adjacant by one tile */
    @Override
    public void move() {
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    /*Attack : A slash that affects the 3 front tiles, 1 damage each */
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
