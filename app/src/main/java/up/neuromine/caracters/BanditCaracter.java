package up.neuromine.caracters;

import up.neuromine.tiles.Tile;

public class BanditCaracter extends BaseCaracter{

    public BanditCaracter() {
        super("Bandit", 3, 1, 2);
    }

    /*Movements : diagonal or adjacant */
    @Override
    public void move() {
        /*Observable needed */
    }

    /*Attack : A leap forward by one or two Tiles dealing 2 damage on the selected Tile */
    @Override
    public void attack(Tile tile) {
        reveal(tile); /*setCharacter on the coordonates selected */
        /*call move */
    }

    /*Special Capacity : */
    @Override
    public void speCapacity(Tile tile) {
        throw new UnsupportedOperationException("Unimplemented method 'speCapacity'");
    }

}
