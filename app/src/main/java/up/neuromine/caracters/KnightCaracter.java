package up.neuromine.caracters;

public class KnightCaracter extends BaseCaracter{

    public KnightCaracter() {
        super("Knight", 4, 1, 1);
    }

    /*Movements : L shape (like in chess) */
    @Override
    public void move() {
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    /*Attack : A spear that deals one damage to the front Tile and two damages on the Tile after */
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
