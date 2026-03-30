package exams;

public class Calculates {

    static class Adder {

        int add(int x, int y) {
            return x + y;
        }

    }

    public static void main(String[] args) {

        Calculates.Adder adder = new Calculates.Adder();
        int result = adder.add(2, 5);

        System.out.println(result);

    }

}
