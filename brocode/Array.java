import java.util.Arrays;
import java.util.Scanner;

public class Array {

    public static void main(String[] args) {
        String[] names;
        int size;

        Scanner scanner = new Scanner(System.in);

        System.out.print("how many names do you want to insert? ");
        size = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        names = new String[size];

        for(int i = 0; i<size; i++) {
            System.out.printf("insert user %d name: ", i + 1);
            names[i] = scanner.nextLine();
        }

        System.out.println(Arrays.toString(names));


scanner.close();
        // for (int i = 0; i < 10; i++) {
        //     names[i] = "Name " + (i + 1);
        // }

        // // for (String name: names) {
        // //     System.out.println(name);
        // // }
        // System.out.println("Length of the array: " + names.length);
        // System.out.println("Last element in the array: " + names[names.length - 1]);
        // System.out.println(names);

        // Arrays.sort(names);
        // System.out.println("Sorted array: " + Arrays.toString(names));
    }
}