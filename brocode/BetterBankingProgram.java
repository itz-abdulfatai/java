import java.util.Scanner;

public class BetterBankingProgram {
    static double balance = 1000.00;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to our bank!");

        while (true) {
            displayMenu();
            if (!followUp()) {
                break;
            }
        }

        System.out.println("Thank you, have a nice day!");
        scanner.close();
    }

    static void displayMenu() {
        System.out.println("\nHow can we help you?");
        System.out.println("1 - Show Balance");
        System.out.println("2 - Deposit");
        System.out.println("3 - Withdraw");
        System.out.println("4 - Exit");
        System.out.print("---> ");

        int choice = getValidInt();
        switch (choice) {
            case 1:
                showBalance();
                break;
            case 2:
                handleDeposit();
                break;
            case 3:
                handleWithdraw();
                break;
            case 4:
                System.out.println("Thanks, have a nice day!");
                System.exit(0);
            default:
                System.out.println("Invalid option.");
        }
    }

    static void handleDeposit() {
        System.out.print("Enter deposit amount: ");
        double amount = getValidDouble();
        deposit(amount);
    }

    static void handleWithdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = getValidDouble();
        withdraw(amount);
    }

    static int getValidInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next(); // discard invalid
        }
        int num = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return num;
    }

    static double getValidDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid amount. Enter a number: ");
            scanner.next(); // discard invalid
        }
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return amount;
    }

    static void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    static void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited.");
    }

    static void showBalance() {
        System.out.println("Your balance is: " + balance);
    }

    static boolean followUp() {
        System.out.print("Would you like to do anything else? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes");
    }
}
