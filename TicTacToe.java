import java.util.InputMismatchException;
import java.util.Scanner;

class Game {
    void play() {
        System.out.println("Let's Play a generic game");
    }

    void play(String gameName) {
        System.out.println("Let's Play " + gameName);
    }
}

class TicTac extends Game {
    @Override

    // Method overriding: Overrides the play() method in the parent class to provide
    // a specific implementation for playing Tic-Tac-Toe
    void play() {
        System.out.println("Let's Play Tic-Tac-Toe");
    }

    // Method overloading: Defines a new version of the play() method that takes an
    // integer parameter to specify the number of players
    void play(int numberOfPlayers) {
        System.out.println("Let's Play Tic-Tac-Toe with " + numberOfPlayers + " players");
    }

    // Method overloading: Defines another version of the play() method that takes
    // two player names as parameters
    void play(String player1, String player2) {
        System.out.println("Let's Play Tic-Tac-Toe between " + player1 + " and " + player2);
    }

    // main game loop
    void startGame() {
        Scanner enter = new Scanner(System.in);
        char[][] board = new char[3][3];
        boolean isPlayer1 = true;

        // loops until the board is full or one player wins
        while (true) {
            printBoard(board);
            int row = -1, col = -1;

            // Iterate to to let players do a move
            do {
                try {
                    System.out.print(isPlayer1 ? "Player 1 (X): " : "Player 2 (O): ");
                    row = enter.nextInt();
                    col = enter.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter valid row and column numbers.\n");
                    enter.next(); // Consume the invalid input
                    continue;
                }

                if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '\0') {
                    System.out.println("Invalid move. Please try again.\n");
                }
            } while (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '\0');

            board[row][col] = isPlayer1 ? 'X' : 'O';
            isPlayer1 = !isPlayer1;

            if (checkWin(board, 'X')) {
                printBoard(board);
                System.out.println("YEHEEEYY Player 1 (X) wins!");
                break;
            } else if (checkWin(board, 'O')) {
                printBoard(board);
                System.out.println("\n\nYEHEEEYY Player 2 (O) wins!");
                break;
            } else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("\n\nNOOOO It's a draw!");
                break;
            }
        }
        enter.close();
    }

    // prints the board
    void printBoard(char[][] board) {
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("Current Board:");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print("  | ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("---------");
            }
        }
    }

    // checks the winning combinations
    boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Horizontal win
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Vertical win
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Diagonal win (top-left to bottom-right)
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Diagonal win (top-right to bottom-left)
        }
        return false;
    }

    // function to check if the board is full (If full, sign of draw)
    boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
}

public class TicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String player1, player2;
        Game genericGame = new Game();

        System.out.println("--------------------------------------------------------------------");
        System.out.println("Welcome!!\n");

        System.out.print("Enter the name player 1: ");
        player1 = input.nextLine();
        System.out.print("Enter the name player 2: ");
        player2 = input.nextLine();

        // Show how overloading works
        genericGame.play();
        genericGame.play("TicTacToe");

        TicTac ticTacToe = new TicTac();
        ticTacToe.play(); // Play Tic-Tac-Toe (no arguments)
        ticTacToe.play(2); // Play Tic-Tac-Toe with a specified number of players
        ticTacToe.play(player1, player2); // Play Tic-Tac-Toe between two specified players

        // start the game
        ticTacToe.startGame();
        input.close();
    }
}
