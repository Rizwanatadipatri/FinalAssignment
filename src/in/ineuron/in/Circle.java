package in.ineuron.in;

import java.util.Scanner;

interface Shapes {
	float pi = 3.14f;
	int base = 3;
	int height = 4;
	int side = 20;
	int side1 = 20;

	public void calculateArea();

	public void calculatePerimeter();

}

class Triangles implements Shapes {

	@Override
	public void calculateArea() {

		int area = (base * height) / 2;
		System.out.println("Area of triangle is" + area);
	}

	@Override
	public void calculatePerimeter() {
		int perimeter = base + side + side1;
		System.out.println("Perimeter of triangle is" + perimeter);

	}

}

public class Circle implements Shapes {
	@Override
	public void calculateArea() {

		int r = 10;
		float area1 = 2 * pi * r * r;
		System.out.println("Area of a circle is" + area1);
	}

	@Override
	public void calculatePerimeter() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius of the circle");
		int r = sc.nextInt();
		float perimeter = 2 * pi * r;
		System.out.println("Perimeter of the circle is" + perimeter);

	}

	public static void main(String[] args) {
		Shapes s = new Circle();
		Shapes t = new Triangles();
		s.calculateArea();
		s.calculatePerimeter();
		t.calculateArea();
		t.calculatePerimeter();

	}

}
