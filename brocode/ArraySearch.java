import java.util.Scanner;

public class ArraySearch {


    public static void main(String[] args) {
        
        int[] numbers = {1, 2, 4, 5, 6, 7, 8, 9, 10};
        int target;


        Scanner scanner = new Scanner(System.in);

        System.out.print("insert the number you are looking for: ");
        target = scanner.nextInt();
        scanner.nextLine();
        scanner.close();
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                System.out.println("target found at index " + i);
                return;
            }
        }

        System.out.println("match not found");
    }
}
