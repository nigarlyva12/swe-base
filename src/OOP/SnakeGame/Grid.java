package OOP.SnakeGame;

public class Grid {
	private int width;
	private int height;
	
	Grid(int width, int height){
		this.width=width;
		this.height = height;
	}
	void display() {
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
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
}
