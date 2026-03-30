import java.util.Random;
import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int numberOfDice;
        int total = 0;
        
        System.out.print("Enter the number of dice to roll: ");
        numberOfDice = scanner.nextInt();

        if (numberOfDice > 0) {
            for (int i = 0; i < numberOfDice; i++) {
                int roll = random.nextInt(1, 7); // Generates a random number between 1 and 6 (inclusive)
                printDie(roll);
                System.out.println("Dice " + (i + 1) + " rolled: " + roll);
                total += roll;
            }
        }

        System.out.println("Total of all dice rolled: " + total);


        scanner.close();
    }


    static void printDie(int roll) {
        String dice1 = """
                -------
                |     |
                |  *  |
                |     |
                -------
                """;

       

                System.out.println(dice1);

    }
}
