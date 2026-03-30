package others;

import java.util.Scanner;

public class Another {
    public static void main(String a[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("type your input below");
        // String message = input.nextLine();
        // System.out.println("You typed: " + message);

        System.out.println("type your first number");
        int num1 = input.nextInt();
        System.out.println("type your  Second number");
        int num2 = input.nextInt();

        System.out.println("sum :" + (num1 + num2));

        input.close();
    }
}
