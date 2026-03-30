import java.util.Scanner;
public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String item ;
        double price;
        double total;
        int quantity;
        char currency = '$';

        System.out.print("Enter the item name:");
        item = scanner.nextLine();

        System.out.print("Enter the price for each:");
        price = scanner.nextDouble();

        System.out.print("Enter the quantity of the item:");
        quantity = scanner.nextInt();

        total = price * quantity;

        System.out.println("You HAVE bought " + quantity + " " + item + "(s) at " + currency + total + " in total.");

        scanner.close();
    }
}
