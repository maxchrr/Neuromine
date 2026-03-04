package up.neuromine.caracters;

import up.neuromine.tiles.Tile;

public class KnightCaracter extends BaseCaracter{

    public KnightCaracter() {
        super("Knight", 4, 1, 1);
    }

    /*Movements : L shape (like in chess) */
    @Override
    public void move() {
        /*Observable needed */
    }

    /*Attack : A spear that deals one damage to the front Tile and two damages on the Tile after */
    @Override
    public void attack(Tile tile) {
        reveal(tile);
    }

    /*Special Capacity : */
    @Override
    public void speCapacity(Tile tile) {
        throw new UnsupportedOperationException("Unimplemented method 'speCapacity'");
    }

}
