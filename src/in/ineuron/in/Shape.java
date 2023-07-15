package in.ineuron.in;

public interface Shape {
	float pi = 3.14f;

	public void calculateArea();

	public void calculatePerimeter();

}

class Circles implements Shape {

	@Override
	public void calculateArea() {
		int r = 10;
		float area = 2 * pi * r * r;
		System.out.println("Area of a circle is" + area);

	}

	@Override
	public void calculatePerimeter() {

		int r = 20;
		float perimeter = 2 * pi * r;
		System.out.println("Perimeter of the circle is" + perimeter);
	}

	public static void main(String[] args) {
		Shape s = new Circles();
		s.calculateArea();
		s.calculatePerimeter();
	}
}
