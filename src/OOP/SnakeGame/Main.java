package OOP.SnakeGame;

public class Main {

	public static void main(String[] args) {

		Grid grid = new Grid(10, 6);
		grid.display();
		
		Snake snake = new Snake(3, 3);
		System.out.println(snake.getHead().row + ", " + snake.getHead().col);
		snake.setDirection(Direction.DOWN);
		snake.move();
		System.out.println(snake.getHead().row + ", " + snake.getHead().col);
	}

}
