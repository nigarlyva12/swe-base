package OOP.ClassDiagramToCode;
//is-a relationship
public class Dog extends Animal{
	public String breed;
	Dog(String species, int age, String breed){
		super(species, age);
		this.breed = breed;
	}
	
	public void bark() {
		System.out.println("Wuf wuf");
	}
}
