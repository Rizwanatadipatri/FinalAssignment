package in.ineuron.in;

abstract class Animal {
	String name;

	abstract void sound();

	void setName(String name) {
		this.name = name;
	}

	void displayInfo() {
		System.out.println("Name: " + name);
	}
}

class Dog extends Animal {
	void sound() {
		System.out.println("Woof!");
	}
}

interface Vehicle {
	void start();

	void stop();
}

class Car implements Vehicle {
	public void start() {
		System.out.println("Car started.");
	}

	public void stop() {
		System.out.println("Car stopped.");
	}
}

class Bike implements Vehicle {
	public void start() {
		System.out.println("Bike started.");
	}

	public void stop() {
		System.out.println("Bike stopped.");
	}
}

public class AbstractVSinterface {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setName("Buddy");
		dog.displayInfo();
		dog.sound();
		Car car = new Car();
		car.start();
		car.stop();

		Bike bike = new Bike();
		bike.start();
		bike.stop();
	}
}
//Abstract classes are used when you want to provide a common base for subclasses with some default behavior and shared characteristics.
//  Interfaces are used when you want to define a contract between client and user.
//  Abstract classes can have both abstract and non-abstract methods, while interfaces can only have abstract methods.
// Abstract classes not provide the complete abstraction, where as interface
// gives 100% abstraction.
//  Classes can extend only one abstract class, but they can implement multiple interfaces.
//  Abstract classes can have instance variables, while interfaces cannot.
//  Abstract classes provide a way to reuse code through inheritance, while interfaces provide a way to achieve polymorphism by allowing objects of different classes to be treated interchangeably based on a common contract.