package DesignPatterns.SingletonPattern;

public class ClassSingleton {
	private static ClassSingleton instance;
	
	private ClassSingleton() {
		
	}
	
	public synchronized static ClassSingleton getInstance() {
		if(instance == null) {
			instance = new ClassSingleton();
		}
		return instance;
	}
}
