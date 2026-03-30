package others;

public abstract class Shape {
	public String name() {
		return getClass().getName();
	}

	public abstract double area();

	public abstract double perimeter();
}

class Circle extends Shape {
	public double radius;

	public Circle(double r) {
		radius = r;
	}

	public double area() {
		return Math.PI * (radius * radius);
	}

	public double perimeter() {
		return (2.0 * Math.PI) * radius;
	}
}
