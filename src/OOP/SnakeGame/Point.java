package OOP.SnakeGame;
/*
 * just a point in the grid 
 * defined by row and col
 */
public class Point {
	int row;
	int col;
	
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
}
