package up.javafx.core.level;

public enum Direction {

	UP(-1, 0),
	DOWN(1, 0),
	LEFT(0, -1),
	RIGHT(0, 1);

	private final int dx;
	private final int dy;

	Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public int dx() {
		return dx;
	}

	public int dy() {
		return dy;
	}
}
