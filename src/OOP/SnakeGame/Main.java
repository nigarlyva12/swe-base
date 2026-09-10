package OOP.SnakeGame;

public class Main {

	public static void main(String[] args) {

		Grid grid = new Grid(10, 6);
		grid.display();
		
		System.out.println(grid.isOutOufBounds(9, 5));
	}

}
