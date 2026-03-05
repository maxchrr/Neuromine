package up.neuromine.caracters;

import up.neuromine.tiles.Tile;

public class PaladinCaracter extends BaseCaracter {

    public PaladinCaracter() {
        super("Paladin", 5, 2, 1);
    }

    /*Movements : adjacant by one tile */
    @Override
    public void move() {
        /*Observable needed */
    }

    /*Attack : A slash that affects the 3 front tiles, 1 damage each */
    @Override
    public void attack(Tile tile) {
        reveal(tile); /*And the 2 other on its side */
    }

    /*Special Capacity : */
    @Override
    public void speCapacity(Tile tile) {
        throw new UnsupportedOperationException("Unimplemented method 'speCapacity'");
    }

    
}
