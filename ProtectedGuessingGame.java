import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class ProtectedGuessingGame {
    // protected class of the game
    static class GuessingGame {
        // protected static variables
        static int lowerBound = 1;
        static int upperBound = 100;
        static int targetNumber;

        // Static method to play the guessing game
        static void playGame() {
            generateTargetNumber(); // Call the static method to generate the target number
            Scanner scanner = new Scanner(System.in);
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
                    attempts++; // count attempts

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
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input: Enter a valid number!");
                    scanner.next(); // Consume the invalid input to avoid an infinite loop
                }
            } while (guess != targetNumber);

            scanner.close();
        }

        // Generate a random number between the lower and upper bounds
        static void generateTargetNumber() {
            // random number generator
            Random random = new Random();
            targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        }
    }

    // Main Method (Static)
    public static void main(String[] args) {
        GuessingGame.playGame();
    }
}