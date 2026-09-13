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
	/**
	 * this method moves the snake by 
	 * adding a new point to the head of snake
	 * and removing the tail to keep the size consistent
	 */
	public void move() {
		grow();
		body.removeLast();
	}
	
	/**
	 * this method helps to grow the size of the snake
	 */
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
	
	/**
	 * the snake is alive when it is
	 * inside the grid boundaries
	 * and when it is not trying to eat itself :D
	 * @param grid
	 * @return
	 */
	public boolean isAlive(Grid grid) {
		Point head = body.getFirst();
		
		if(grid.isOutOufBounds(head.row, head.col))
			return false;
		
		for(int i=1; i<body.size(); i++) {
			if(body.get(i).getCol() == head.getCol() && body.get(i).getRow() == head.getRow()) {
				return false;
			}
		}
		return true;
	}
	/**
	 * this method helps us to define the current 
	 * location of the snake
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isAt(int row, int col) {
		for(int i=0; i<body.size(); i++) {
			if(body.get(i).getCol() == col && body.get(i).getRow() == row) {
				return true;
			}
		}
		return false;
	}
	public Point getHead() {
		return body.getFirst();
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction newDirection) {
		if(newDirection == Direction.DOWN && this.direction == Direction.UP)
			return;
		else if(newDirection == Direction.UP && this.direction == Direction.DOWN) 
			return;
		else if (newDirection == Direction.LEFT && this.direction == Direction.RIGHT)
			return;
		else if(newDirection == Direction.RIGHT && this.direction == Direction.LEFT);
		this.direction = newDirection;
	}
	public LinkedList<Point> getBody() {
		return body;
	}
	public void setBody(LinkedList<Point> body) {
		this.body = body;
	}
	
}
