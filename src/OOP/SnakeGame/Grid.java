package OOP.SnakeGame;

public class Grid {
	private int width;
	private int height;
	
	Grid(int width, int height){
		this.width=width;
		this.height = height;
	}
	
	public boolean isOutOufBounds(int row, int col) {
		if(row>=0 && row<height && col>=0 && col<width)
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
