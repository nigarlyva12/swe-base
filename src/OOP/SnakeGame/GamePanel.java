package OOP.SnakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Grid grid;
	private Snake snake;
	private Food food;
	private Image backgroundImage;
	private Image foodImage;
	
	public GamePanel(Grid grid, Snake snake, Food food) throws IOException {
	    this.grid = grid;
	    this.snake = snake;
	    this.food = food;
	    
	    backgroundImage = ImageIO.read(new File("imgs/background.png"));
	    foodImage = ImageIO.read(new File("imgs/apple.png"));
	    
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
		
	    int cellSize = 40; 
	    
	    for (int i = 0; i < grid.getHeight(); i++) {
	        for (int j = 0; j < grid.getWidth(); j++) {
	            if (snake.isAt(i, j)) {
	                g.setColor(Color.BLACK);
	            	g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
	            }
	            else if (food.getPosition().getRow() == i && food.getPosition().getCol() == j)
	            	g.drawImage(foodImage, j * cellSize, i * cellSize, cellSize, cellSize, null);
	            else continue;

	        }
	    }
	    if (!snake.isAlive(grid)) {
	        g.setColor(Color.RED);
	        g.setFont(new Font("Arial", Font.BOLD, 40));
	        g.drawString("GAME OVER", grid.getWidth()*30/2, grid.getHeight() * 40 / 2);
	    }
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
}
