package up.neuromine.core.entity;

import up.neuromine.core.level.cells.Cell;

public class KnightCharacter extends Player {

	public KnightCharacter(String name, PlayerProfile profile, int x, int y) {
		super(name, profile, x, y);
	}

	/*
	 * Movements : L shape (like in chess)
	 */
	@Override
	public void move(Cell target) {
		throw new UnsupportedOperationException("Unimplemented method 'move'");
	}

	/*
	 * Attack : A spear that deals one damage to the front Tile and two damages on
	 * the Tile after
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
