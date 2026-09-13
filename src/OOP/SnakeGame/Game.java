package OOP.SnakeGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game {
	private Grid grid;
	private Snake snake;
	private Food food;
	private Timer timer;
	private JFrame frame;
	private GamePanel panel;
	private JButton resetButton;
	
	public Game() {
		grid = new Grid(20,16);
		snake = new Snake(3,3);
		food = new Food(new Point(2,2));
		panel = new GamePanel(grid, snake, food);
		resetButton = new JButton("Play Again");
		resetButton.setVisible(false);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
	    frame = new JFrame("Snake");
	    frame.add(panel, BorderLayout.CENTER);
	    frame.add(resetButton, BorderLayout.SOUTH);
	    panel.setPreferredSize(new Dimension(800, 640));
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	
	public void start() {
		timer = new Timer(300, e -> {
			snake.move();
			if (!snake.isAlive(grid)) {
				timer.stop();
				resetButton.setVisible(true);
			}
			if(snake.isAt(food.getPosition().getRow(), food.getPosition().getCol())) {
				snake.grow();
				food.respawn(grid);
			}
			panel.repaint();
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
    /**
     * the game will be reset here
     * snake and food should be recreated and sent to GamePanel
     * and resetButton should also invisible
     * at last, we reset the timer
     */
	public void reset() {
		timer.stop();
		snake = new Snake(3,3);
		food = new Food(new Point(2,2));
		panel.setSnake(snake);
		panel.setFood(food);
		resetButton.setVisible(false);
		timer.restart();	
		frame.requestFocusInWindow();
	}
	
}
