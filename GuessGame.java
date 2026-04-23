import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int roundsWon = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            roundsPlayed++;
            int target = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            int attempts = 0;
            boolean correct = false;

            System.out.printf("%nI'm thinking of a number between %d and %d.%n", MIN_VALUE, MAX_VALUE);
            System.out.printf("You have %d attempts to guess it.%n", MAX_ATTEMPTS);

            while (attempts < MAX_ATTEMPTS) {
                attempts++;
                System.out.printf("Attempt %d: Enter your guess: ", attempts);

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid whole number.");
                    scanner.next(); // consume invalid input
                    attempts--;
                    continue;
                }

                int guess = scanner.nextInt();
                if (guess < target) {
                    System.out.println("Too low.");
                } else if (guess > target) {
                    System.out.println("Too high.");
                } else {
                    System.out.printf("Correct! You guessed the number in %d attempt(s).%n", attempts);
                    correct = true;
                    break;
                }
            }

            if (!correct) {
                System.out.printf("Out of attempts. The number was %d.%n", target);
            } else {
                roundsWon++;
            }

            totalAttempts += attempts;
            int score = roundsWon * 10 - (totalAttempts - roundsWon);

            System.out.printf("%nScore summary after %d round(s):%n", roundsPlayed);
            System.out.printf("  Rounds won: %d%n", roundsWon);
            System.out.printf("  Total attempts: %d%n", totalAttempts);
            System.out.printf("  Score: %d%n", score);

            System.out.print("Play again? (y/n): ");
            String answer = scanner.next().trim().toLowerCase();
            playAgain = answer.equals("y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}