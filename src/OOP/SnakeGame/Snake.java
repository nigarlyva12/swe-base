package OOP.SnakeGame;

import java.util.LinkedList;

public class Snake {
	private LinkedList<Point> body;
	private Direction direction;
	
	Snake(int row, int col){
		body = new LinkedList<>();
		body.add(new Point(row, col));
		direction = Direction.RIGHT; //default
	}
	
	public void move() {
		grow();
		body.removeLast();
	}
	
	public void grow() {
		Point head = body.getFirst();
		
		int current_row = head.row;
		int current_col = head.col;
		
		switch(direction) {
			case UP : current_row--; break;
			case DOWN: current_row++; break;
			case LEFT: current_col--; break;
			case RIGHT: current_col++; break;
		}
		body.addFirst(new Point(current_row, current_col));
	}
	
	public boolean isAlive(Grid grid) {
		Point head = body.getFirst();
		
		if(grid.isOutOufBounds(head.row, head.col))
			return false;
		return true;
	}
	public Point getHead() {
		return body.getFirst();
	}
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
}
