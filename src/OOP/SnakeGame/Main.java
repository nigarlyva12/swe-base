package OOP.SnakeGame;

public class Main {

	public static void main(String[] args) {
		start();
	}
	public static void start() {
		Grid grid = new Grid(10, 8);
		Snake snake = new Snake(3, 1);
		Point point = new Point(2,2); //food position
		Food food = new Food(point);
		grid.display(snake, food);
	}

}
