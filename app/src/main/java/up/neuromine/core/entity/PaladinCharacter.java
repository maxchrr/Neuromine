package up.neuromine.core.entity;

import up.neuromine.core.level.cells.Cell;

public class PaladinCharacter extends Player {

	public PaladinCharacter(String name, PlayerProfile profile, int x, int y) {
		super(name, profile, x, y);
	}

	@Override
	public void move(Cell target) {
		throw new UnsupportedOperationException("Unimplemented method 'move'");
	}

	/*
	 * Attack : A slash that affects the 3 front tiles, 1 damage each
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
