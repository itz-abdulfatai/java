import java.util.Random;
public class Randoms {

public static void main(String[] args) {
    Random random = new Random();

    int number;
    double number2;
    boolean isHeads;

    number = random.nextInt(1,6); // Generates a random number between 1 and 5 (inclusive of 1, exclusive of 6)
    System.out.println( number);

    number2 = random.nextDouble(1,10); // Generates a random double between 1.0 (inclusive) and 10.0 (exclusive)
    System.out.println(number2);

    isHeads = random.nextBoolean(); // Generates a random boolean value (true or false)

    if (isHeads) {
        System.out.println("Heads");
    } else {
        System.out.println("Tails");
    }



}
}
