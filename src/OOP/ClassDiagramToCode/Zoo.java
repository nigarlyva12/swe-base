package OOP.ClassDiagramToCode;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
	private String name;
	private String location;
	private List<Animal> animals = new ArrayList<>(); //there is composition
	Zoo(String name, String location){
		this.name = name;
		this.location = location; 
	}
	public void addAnimal(Animal animal) {
		/**
		 * relationship between zoo and animal is composition
		 * thus, we have to create a new animal inside this class 
		 * to make the dependency visible
		 * */
		animals.add(new Animal(animal.getSpecies(), animal.getAge())); 
	}
	public void open() {};
	public void close() {};
}
