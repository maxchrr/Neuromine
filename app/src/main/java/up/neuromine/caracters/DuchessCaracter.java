package up.neuromine.caracters;

import up.neuromine.tiles.Tile;

public class DuchessCaracter extends BaseCaracter {

    public DuchessCaracter() {
        super("Duchess", 4, 2, 1);
    }

    /*Movements : adjacant by one or two tiles */
    @Override
    public void move() {
        /*Observable needed */
    }

    /*Attack : A quickslash that affects the front tile by dealing one damage */
    @Override
    public void attack(Tile tile) {
        reveal(tile);
        /*deals damage if there is an enemy */
    }

    /*Special Capacity : */
    @Override
    public void speCapacity(Tile tile) {
        throw new UnsupportedOperationException("Unimplemented method 'speCapacity'");
    }

}
