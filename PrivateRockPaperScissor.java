import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PrivateRockPaperScissor {
    private class RockPaperScissorGame {
        private int playerChoice;
        private int computerChoice;

        private void playGame() {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            System.out.println("-------------------------------------------------------");
            System.out.println("Let's play Rock, Paper, Scissors!");
            System.out.println("-------------------------------------------------------");
            System.out.println("Select your choice:");
            System.out.println("1. Rock\n2. Paper\n3. Scissors");

            // Get the player's choice
            while (true) {
                try {
                    System.out.println("-------------------------------------------------------");
                    System.out.print("Enter your choice (1 for Rock, 2 for Paper, 3 for Scissors): ");
                    playerChoice = scanner.nextInt();

                    if (playerChoice < 1 || playerChoice > 3) {
                        System.out.println("Invalid choice. Please select 1, 2, or 3.");
                        continue;
                    }

                    break; // Valid input, exit the loop
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input: Try Again");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            // Generate the computer's choice
            computerChoice = random.nextInt(3) + 1;

            // Display the choices
            System.out.println("-------------------------------------------------------");
            System.out.println("Player chose: " + getChoiceName(playerChoice));
            System.out.println("Computer chose: " + getChoiceName(computerChoice));

            // Determine the winner
            int result = determineWinner(playerChoice, computerChoice);

            if (result == 0) {
                System.out.println("Fair match! It's a tie!");
            } else if (result == 1) {
                System.out.println("Yeheyyyy! You win!");
            } else {
                System.out.println("Noooo Wayyyy! Computer wins!");
            }

            scanner.close();
        }

        private String getChoiceName(int choice) {
            switch (choice) {
                case 1:
                    return "Rock";
                case 2:
                    return "Paper";
                case 3:
                    return "Scissors";
                default:
                    return "Invalid Choice";
            }
        }

        private int determineWinner(int player, int computer) {
            // 0 for a tie, 1 for player wins, 2 for computer wins
            if (player == computer) {
                return 0;
            } else if ((player == 1 && computer == 3) || (player == 2 && computer == 1)
                    || (player == 3 && computer == 2)) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    public static void main(String[] args) {
        PrivateRockPaperScissor game = new PrivateRockPaperScissor();
        RockPaperScissorGame gameInstance = game.new RockPaperScissorGame();
        gameInstance.playGame();
    }
}
