package OOP.SnakeGame;

import java.awt.Color;
import java.awt.Font;
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
	    int cellSize = 40; 
	    
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
	    if (!snake.isAlive(grid)) {
	        g.setColor(Color.RED);
	        g.setFont(new Font("Arial", Font.BOLD, 40));
	        g.drawString("GAME OVER", 60, grid.getHeight() * 40 / 2);
	    }
	}
}
