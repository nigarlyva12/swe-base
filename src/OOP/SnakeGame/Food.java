package OOP.SnakeGame;

public class Food {
	private Point position;
	
	Food(Point position){
		this.position = position;
	}
	
	public boolean isEaten(Snake snake) {
		return snake.getHead().getRow()==position.getRow() && snake.getHead().getCol() == position.getCol();
	}
	
	public void respawn(Grid grid) {
		int lower_bound = 1;
		int random_col = (int) (Math.random()*(grid.getWidth()-2)+lower_bound);
		int random_row = (int) (Math.random()*(grid.getHeight()-2)+lower_bound);
		
		position = new Point(random_row, random_col);
	}

	public Point getPosition() {
		return position;
	}
	
}
