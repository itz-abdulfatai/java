import java.util.Random;
import java.util.Scanner;

public class Slot {
    static String[] rows = {"♥️","🔔","💿","📀","🍕","🍉"};
    static String[] selections = new String[3];
    static double balance = 100.00;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        
        System.out.println("🎰 Welcome to the Slot Machine! 🎰");
        System.out.println("Your current balance: $" + balance);
        
        
        
        do {
            if (balance < 0) {
                System.out.println("your balance is too low");
                return;
            }
            play();
        } while(playAgain().equalsIgnoreCase("yes"));
        
        // A slot machine (fruit machine) typically has:
        // 1. Multiple reels (usually 3-5) that spin independently
        // 2. Each reel has various symbols (fruits, numbers, special icons)
        // 3. Player pulls lever/presses button to spin all reels
        // 4. Reels stop randomly on symbols
        // 5. Specific combinations of symbols result in wins
        // 6. Higher value symbols or rarer combinations pay more
        // 7. Modern machines use RNG (Random Number Generator) for fairness
    }
    static void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter your bet: ");
        double bet = scanner.nextDouble();
        scanner.nextLine();

        if (bet == 0) {
            System.out.println("Please enter a valid bet amount greater than 0!");
        } else if (bet > balance) {
            System.out.println("Insufficient funds! Your balance is $" + balance);
        } else if (bet < 0) {
            System.out.println("Invalid bet! Please enter a positive amount.");
        } else {
            balance -= bet;
            System.out.println("Placing bet of $" + bet);
            System.out.println("Remaining balance: $" + balance);
        }

        for(int i = 0; i<3; i++) {
            Random random = new Random();
            int index = random.nextInt(rows.length);

            selections[i] = rows[index];

            
        }
        
        for(int j = 0; j<3; j++) {
            System.out.println(selections[j]);
        }



        
scanner.close();        
} 

static String playAgain() {
    System.out.println("Would you like to play again? (yes/no)");
    String a = scanner.nextLine();
    return a;
}
}