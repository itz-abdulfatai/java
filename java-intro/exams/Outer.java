package exams;

public class Outer {

    private int x = 10;

    class Inner {

        void display() {
            System.out.println(x);
        }

    }

    public static void main(String[] args) {
        Outer outer = new Outer();

        Outer.Inner innter = outer.new Inner();

        innter.display();

    }

}
