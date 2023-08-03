import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame {
    public static void main(String[] args) {
        int min = 1;
        int max = 100;

        // Create a Random object
        Random random = new Random();

        // Generate a random number within the specified range
        int randomNumber = random.nextInt(max - min + 1) + min;

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Random Number Guessing Game!");
        System.out.println("Guess the random number between " + min + " and " + max + ":");

        // Read the user's guess
        int userGuess = scanner.nextInt();

        // Check if the guess is correct
        if (userGuess == randomNumber) {
            System.out.println("Congratulations! Your guess is correct.");
        } else if (userGuess < randomNumber) {
            System.out.println("Sorry, your guess is too low. The correct number was: " + randomNumber);
        } else {
            System.out.println("Sorry, your guess is too high. The correct number was: " + randomNumber);
        }

        // Close the scanner
        scanner.close();
    }
}