package exams;

interface Shapes {
    void draw();
}

class Circle implements Shapes {

    public void draw() {
        System.out.println("Drawing a circle");
    }

}

class Rectangle implements Shapes {

    public void draw() {
        System.out.println("Drawing a rectangle");
    }

}

public class Shape {
    public static void main(String[] args) {

        Shapes rect = new Rectangle();
        Shapes circle = new Circle();

        rect.draw();
        circle.draw();

    }

}
