import java.util.Random;
import java.util.Scanner;

public class Rps {
    private static final String[] CHOICES = {"rock", "paper", "scissors"};
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            playRound();
        } while (playAgain());
        scanner.close();
    }

    private static void playRound() {
        String playerChoice = getPlayerChoice();
        String computerChoice = CHOICES[new Random().nextInt(CHOICES.length)];
        
        System.out.println("Computer picked: " + computerChoice);
        System.out.println(determineWinner(playerChoice, computerChoice));
    }

    private static String getPlayerChoice() {
        String choice;
        do {
            System.out.print("Pick one (rock, paper, scissors): ");
            choice = scanner.nextLine().trim().toLowerCase();
        } while (!isValidChoice(choice));
        return choice;
    }

    private static boolean isValidChoice(String choice) {
        for (String validChoice : CHOICES) {
            if (validChoice.equals(choice)) return true;
        }
        System.out.println("Invalid choice! Try again.");
        return false;
    }

    private static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) return "It's a tie!";
        
        return switch (playerChoice) {
            case "rock" -> computerChoice.equals("scissors") ? "You win!" : "You lose!";
            case "paper" -> computerChoice.equals("rock") ? "You win!" : "You lose!";
            case "scissors" -> computerChoice.equals("paper") ? "You win!" : "You lose!";
            default -> "Invalid game state";
        };
    }

    private static boolean playAgain() {
        System.out.print("Play again? (yes/no): ");
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }
}
