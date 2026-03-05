package up.neuromine.core.entity;

import up.neuromine.core.level.cells.Cell;

public class DuchessCharacter extends Player {

	public DuchessCharacter(String name, PlayerProfile profile, int x, int y) {
		super(name, profile, x, y);
	}

	/*
	 * Movements : adjacent by one or two tiles
	 */
	@Override
	public void move(Cell target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'move'");
	}

	/*
	 * Attack : A quickslash that affects the front tile by
	 * dealing one damage
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
