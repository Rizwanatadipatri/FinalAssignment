package in.ineuron.in;

class Parent {
	// we are using default or no argument constructor
	public Parent() {
		System.out.println("Parent ");
	}
}

class Child extends Parent {
	// creating the child constructor also in order to call parent constructor
	public Child() {
		// by using the super method we can invoke the parent class constructor into
		// child class
		super();
		System.out.println("Calling child class");
	}
}

public class Construc {

	public static void main(String[] args) {
		Child c = new Child();

	}

}
