package OOP.SnakeGame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private Grid grid;
	private Snake snake;
	private Food food;

	public GamePanel(Grid grid, Snake snake, Food food) {
	    this.grid = grid;
	    this.snake = snake;
	    this.food = food;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    int cellSize = 40; // each cell is 40x40 pixels

	    for (int i = 0; i < grid.getHeight(); i++) {
	        for (int j = 0; j < grid.getWidth(); j++) {
	            if (snake.isAt(i, j))
	                g.setColor(Color.GREEN);
	            else if (food.getPosition().getRow() == i && food.getPosition().getCol() == j)
	                g.setColor(Color.RED);
	            else
	                g.setColor(Color.BLACK);

	            g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
	        }
	    }
	}
}
