package up.javafx.core.level;

import up.javafx.core.level.cells.Cell;

public class Grid {

    private final int rows;
    private final int cols;
    private final Cell[][] cells;

    public Grid(int rows, int cols) {
        this.rows  = rows;
        this.cols  = cols;
        this.cells = new Cell[rows][cols];
    }

    public boolean isInside(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public Cell getCell(int row, int col)            { return cells[row][col]; }
    public void setCell(int row, int col, Cell cell) { cells[row][col] = cell; }
    public int  getRows()                            { return rows; }
    public int  getCols()                            { return cols; }
}
