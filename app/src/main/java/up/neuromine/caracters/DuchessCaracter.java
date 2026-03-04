package up.neuromine.caracters;

public class DuchessCaracter extends BaseCaracter {

    public DuchessCaracter() {
        super("Duchess", 4, 2, 1);
    }

    /*Movements : adjacant by one or two tiles */
    @Override
    public void move() {
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    /*Attack : A quickslash that affects the front tile by dealing one damage */
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
