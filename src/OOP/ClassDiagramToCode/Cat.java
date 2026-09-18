package OOP.ClassDiagramToCode;

public class Cat extends Animal{
	public String color;
	
	Cat(String species, int age, String color){
		super(species, age);
		this.color = color;
	}
	
	public void meow() {
		System.out.println("Meow meow");
	}
}
