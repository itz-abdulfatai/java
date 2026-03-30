import java.util.Scanner;

public class BankingProgram {
    static double balance = 1000.00;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("welcome to our bank what can we do for you today");
        // display menu
        displayMenu();

    }

    static void displayMenu() {
        String intent;
        int choice;

        System.out.println("how can we be of help? ");
        System.out.println("select 1 to show balance");
        System.out.println("select 2 to deposit");
        System.out.println("select 3 to withdraw");
        System.out.println("select 4 to exit");

        System.out.print("--->");
        if (!scanner.hasNextInt()) {
            System.out.println("invalid input");
            scanner.close();
            return;
        } else {
            choice = scanner.nextInt();
        }

        intent = choice == 1 ? "show balance"
                : choice == 2 ? "deposit" : choice == 3 ? "withdraw" : choice == 4 ? "exit" : "leave";

        switch (intent) {
            case "show balance":
                showBalance();
                break;
            case "deposit":
                double amount;
                System.out.print("input deposit ammount: ");
                if (scanner.hasNextDouble()) {
                    amount = scanner.nextDouble();
                } else {
                    System.out.println("invalid deposit ammount");
                    scanner.close();
                    return;
                }
                deposit(amount);
                break;

            case "withdraw":

                System.out.print("input ammount to withdraw: ");
                if (scanner.hasNextDouble()) {
                    amount = scanner.nextDouble();
                } else {
                    System.out.println("invalid deposit ammount");
                    scanner.close();
                    return;
                }
                withdraw(amount);
                break;

            case "exit":
                System.out.println("thanks have a nice day");
                scanner.close();
                return;
                
            default:
                System.out.println("invalid input");
                displayMenu();
                break;
        }

        System.out.println("thanks for banking with us.. ");
        System.out.println("is there any other thing we can do for you? (input yes or no)");

        followUp();

        scanner.close();
    }

    static void withdraw(double ammount) {
        if (ammount < balance) {
            balance -= ammount;
            System.out.println(ammount + " withdrawn");
        } else {
            System.out.println("insuficient funds");
        }

    }

    static void deposit(double ammount) {
        balance += ammount;
        System.out.println(ammount + " deposited");

    }

    static void showBalance() {
        System.out.println("your balance is " + balance);

    }

    static void followUp() {
        switch (scanner.nextLine().toLowerCase()) {
            case "yes":
                displayMenu();

                break;

            case "no":
                System.out.println("thank you have a nice day");
                scanner.close();
                return;

            default:
                followUp();
                break;
        }
    }

}
