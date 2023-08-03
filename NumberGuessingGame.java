import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int totalRounds = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.printf("I am thinking of a number between %d and %d.%n", minNumber, maxNumber);

        while (playAgain) {
            int targetNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int attempts = 0;
            totalRounds++;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (guess == targetNumber) {
                    System.out.printf("Congratulations! You guessed the correct number %d in %d attempts.%n", targetNumber, attempts);
                    totalAttempts += attempts;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.printf("Sorry, you've reached the maximum number of attempts. The number was %d.%n", targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().toLowerCase();
            playAgain = playAgainInput.equals("yes") || playAgainInput.equals("y");
        }

        double averageAttempts = (double) totalAttempts / totalRounds;
        System.out.printf("%nGame Over. Your final score based on average attempts per round: %.2f%n", averageAttempts);
    
    // Close the scanner
    scanner.close();}
    
}
