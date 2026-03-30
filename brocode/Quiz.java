import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        int score = 0;
        String[] questions = {"1. What is the capital of France?",
                              "2. Which data type is used to store text in Java?",
                              "3. Who developed the theory of relativity?",
                             "4. What is the result of 5 + 3 * 2?"};


        String[][] options = {
            {"1) Berlin", "2) Madrid", "3) Paris", "4) Rome"},
            {"1) int", "2) String", "3) char", "4) float"},
            {"1) Isaac Newton", "2) Nikola Tesla", "3) Albert Einstein", "4) Galileo Galilei"},
            {"1) 16", "2) 11", "3) 13", "4) 10"}
        };

        int[] answers = {3, 2, 3, 2};

        Scanner scanner = new Scanner(System.in);
        System.out.println("select the appropriate answer");
        for(int i =0; i<questions.length; i++) {
            System.out.println(questions[i] + " ");
            for(int j = 0; j<options[i].length; j++) {
                System.out.println(options[i][j]);
            }
            System.out.print("Enter your answer: ");
            int ans = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            if (ans == answers[i]) {
                score++;
            }
        }

        System.out.printf("you scored %d out of %d", score, questions.length);
        System.out.println();

        System.out.println("\nCorrect Answers:");
        for (int i = 0; i < questions.length; i++) {
            System.out.printf("%s -> %s\n", questions[i], options[i][answers[i] - 1]);
            System.out.println();
        }

        scanner.close();

    }
}
