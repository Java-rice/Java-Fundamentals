import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PublicGuessingGame {
    // Static variables
    public static int lowerBound = 1;
    public static int upperBound = 100;
    public static int targetNumber;

    // Generate a random number between the lower and upper bounds
    public static void generateTargetNumber() {
        // random number generator
        Random random = new Random();
        targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    // Static method to play the guessing game
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        generateTargetNumber();
        int attempts = 0;
        int guess = -1;
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound);
        System.out.println("------------------------------------------");

        do {
            try {
                System.out.println("------------------------------------------");
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt(); // user input
                attempts++; // count attemps

                // checking loop
                if (guess < targetNumber) {
                    System.out.println("Try a higher number.");
                } else if (guess > targetNumber) {
                    System.out.println("Try a lower number.");
                } else {
                    System.out.println("\nCongratulations! You've guessed the correct number in " + attempts
                            + " attempts.");
                    System.out.println("The Correct Number is: " + targetNumber);
                }
            } catch (InputMismatchException e) { // catch Input Mismatch Error
                System.out.println("Invalid Input: Enter a valid number!");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        } while (guess != targetNumber);

        scanner.close();
    }

    // Main Method (Static)
    public static void main(String[] args) {
        // Call the playGame method to start the game
        playGame();
    }
}