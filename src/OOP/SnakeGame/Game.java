package OOP.SnakeGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Game {
	private Grid grid;
	private Snake snake;
	private Food food;
	private Timer timer;
	private JFrame frame;
	
	public Game() {
		grid = new Grid(10,8);
		snake = new Snake(3,3);
		food = new Food(new Point(2,2));
		frame = new JFrame("Snake");
		frame.setVisible(true);
	}
	public void start() {
		timer = new Timer(300, e -> {
			snake.move();
			grid.display(snake, food);
			System.out.print("\033[H\033[2J");
			System.out.flush();
		});
		timer.start();
		
		frame.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP)
					snake.setDirection(Direction.UP);
				else if(e.getKeyCode() == KeyEvent.VK_DOWN)
					snake.setDirection(Direction.DOWN);
				else if(e.getKeyCode() == KeyEvent.VK_LEFT)
					snake.setDirection(Direction.LEFT);
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
					snake.setDirection(Direction.RIGHT);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
