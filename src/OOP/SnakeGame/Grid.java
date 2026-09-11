package OOP.SnakeGame;

public class Grid {
	private int width;
	private int height;
	
	Grid(int width, int height){
		this.width=width;
		this.height = height;
	}
	
	void display(Snake snake, Food food) {
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(snake.isAt(i, j))
					System.out.print("# ");	
				else if(food.getPosition().getRow()==i && food.getPosition().getCol()==j)
					System.out.print("* ");	
				else 
					System.out.print(". ");
			}
			System.out.println();
		}
	}
	
	public boolean isOutOufBounds(int row, int col) {
		if(row>0 && row<=height && col>0 && col<=width)
			return false;
		return true;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
