package OOP.ClassDiagramToCode;

import java.util.ArrayList;
import java.util.List;

public class Owner {
	private String name;
	private String address;
	private List<Animal> animals = new ArrayList<>();
	
	Owner(String name, String address){
		this.name = name;
		this.address = address;
	}
	
	/**
	 * here the relationship is aggregation,
	 * thus we create the animal outside of this class
	 * and add it here to use
	 * */
	public void adopt(Animal animal) {
		animals.add(animal);
	}
}
