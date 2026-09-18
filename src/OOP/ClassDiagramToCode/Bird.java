package OOP.ClassDiagramToCode;

public class Bird extends Animal {
	public boolean canFly;
	
	Bird(String species, int age, boolean canFly){
		super(species, age);
		this.canFly = canFly;
	}
	
	public void chirp() {
		//implementation
	}
}
