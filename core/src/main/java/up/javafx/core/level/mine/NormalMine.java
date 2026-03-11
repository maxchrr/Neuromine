package up.javafx.core.level.mine;

import up.javafx.core.entity.player.Player;
import up.javafx.core.level.cells.Cell;

public class NormalMine implements Mine {

	private boolean active = true;
	private Cell cell;
	private final int damage;

	public NormalMine(int damage) {
		this.damage = damage;
	}

	@Override
	public void trigger(Player player) {
		if (!active)
			return;
		System.out.println("Mine detonated! Player takes " + damage + " damage.");
		player.takeDamage(damage);
		active = false;
		if (cell != null)
			cell.reveal();
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setCell(Cell cell) {
		this.cell = cell;
	}

	@Override
	public Cell getCell() {
		return cell;
	}

}
