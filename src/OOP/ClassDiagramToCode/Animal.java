package OOP.ClassDiagramToCode;

public class Animal {
	private String species;
	private int age;
	
	Animal(String species,int age){
		this.species = species;
		this.age = age;
	}
	
	public void makeSound() {};
	public void move() {}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	};
	
}
