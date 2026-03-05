package up.neuromine.core.entity;

import up.neuromine.core.level.cells.Cell;

public class BanditCharacter extends Player {

	public BanditCharacter(String name, PlayerProfile profile, int x, int y) {
		super(name, profile, x, y);
	}

	@Override
	public void move(Cell target) {
		throw new UnsupportedOperationException("Unimplemented method 'move'");
	}

	/*
	 * Attack : A leap forward by one or two Tiles dealing 2 damage on the selected
	 * Tile
	 */
	@Override
	public void attack(Cell target) {
		reveal(target);
	}

	@Override
	public void speCapacity(Cell target) {
		throw new UnsupportedOperationException("Unimplemented method 'speCapacity'");
	}

}
