
// TicTacToe V3 I guess... written in Java.
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class App {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_WHITE = "\u001B[37m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_PURPLE = "\033[0;35m";
    static final String ANSI_BOLD_YELLOW = "\033[1;33m";
    static final String CHOOSE_A_NUMBER = ANSI_BOLD_YELLOW + "Choose a number from 1 - 9" + ANSI_RESET;
    static final String YOUR_TURN = ANSI_PURPLE + "Your turn: " + ANSI_RESET;
    static final String INVALID_INPUT = ANSI_RED + "Invalid Input..." + ANSI_RESET;
    static final String emptyValue = ANSI_WHITE + "-" + ANSI_RESET;
    static final String userValue = ANSI_RED + "X" + ANSI_RESET;
    static final String computerValue = ANSI_CYAN + "O" + ANSI_RESET;
    static HashMap<Integer, String> boards = new HashMap<Integer, String>();
    static boolean gameRunning = true;
    static int boardsLength = 9;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i <= boardsLength; i++) {
            boards.put(i, emptyValue);
        }
        System.out.printf("Welcome to TicTacToe!\n");
        playGame();
    }

    public static void displayBoard() {
        System.out.printf("%s | %s | %s         1 | 2 | 3\n", boards.get(1), boards.get(2), boards.get(3));
        System.out.printf("%s | %s | %s         4 | 5 | 6\n", boards.get(4), boards.get(5), boards.get(6));
        System.out.printf("%s | %s | %s         7 | 8 | 9\n", boards.get(7), boards.get(8), boards.get(9));
    }

    public static void playGame() throws Exception {
        displayBoard();

        Scanner sc = new Scanner(System.in);
        while (gameRunning) {
            System.out.println(YOUR_TURN);
            System.out.println(CHOOSE_A_NUMBER);
            int userInput = sc.nextInt();

            if (userInput == 1 && boards.get(1).equals(emptyValue)) {
                boards.put(1, userValue);
            } else if (userInput == 2 && boards.get(2).equals(emptyValue)) {
                boards.put(2, userValue);
            } else if (userInput == 3 && boards.get(3).equals(emptyValue)) {
                boards.put(3, userValue);
            } else if (userInput == 4 && boards.get(4).equals(emptyValue)) {
                boards.put(4, userValue);
            } else if (userInput == 5 && boards.get(5).equals(emptyValue)) {
                boards.put(5, userValue);
            } else if (userInput == 6 && boards.get(6).equals(emptyValue)) {
                boards.put(6, userValue);
            } else if (userInput == 7 && boards.get(7).equals(emptyValue)) {
                boards.put(7, userValue);
            } else if (userInput == 8 && boards.get(8).equals(emptyValue)) {
                boards.put(8, userValue);
            } else if (userInput == 9 && boards.get(9).equals(emptyValue)) {
                boards.put(9, userValue);
            } else {
                System.out.println(INVALID_INPUT);
                playGame();
            }
            displayBoard();
            winLogic();
            if (!gameRunning) {
                break;
            }
            TimeUnit.SECONDS.sleep(1);
            System.out.println("\nIt is the computers turn...\n");
            TimeUnit.SECONDS.sleep(1);
            flipPlayer();
        }
        sc.close();
    }

    public static void flipPlayer() {
        while (true) {
            int computerTurn = ThreadLocalRandom.current().nextInt(1, 10);
            if (boards.get(computerTurn).equals(emptyValue)) {
                boards.put(computerTurn, computerValue);
                displayBoard();
                winLogic();
                break;
            }
        }
    }

    public static void winLogic() {
        if (boards.get(1).equals(userValue) && boards.get(2).equals(userValue) && boards.get(3).equals(userValue)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (boards.get(1).equals(userValue) && boards.get(5).equals(userValue)
                && boards.get(9).equals(userValue)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (boards.get(1).equals(userValue) && boards.get(4).equals(userValue)
                && boards.get(7).equals(userValue)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (boards.get(4).equals(userValue) && boards.get(5).equals(userValue)
                && boards.get(6).equals(userValue)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (boards.get(7).equals(userValue) && boards.get(8).equals(userValue)
                && boards.get(9).equals(userValue)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (boards.get(7).equals(userValue) && boards.get(5).equals(userValue)
                && boards.get(3).equals(userValue)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (boards.get(3).equals(userValue) && boards.get(6).equals(userValue)
                && boards.get(9).equals(userValue)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (boards.get(2).equals(userValue) && boards.get(5).equals(userValue)
                && boards.get(8).equals(userValue)) {
            System.out.println("You have won!");
            gameRunning = false;
            // Computers turn
        } else if (boards.get(1).equals(computerValue) && boards.get(2).equals(computerValue)
                && boards.get(3).equals(computerValue)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (boards.get(1).equals(computerValue) && boards.get(5).equals(computerValue)
                && boards.get(9).equals(computerValue)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (boards.get(1).equals(computerValue) && boards.get(4).equals(computerValue)
                && boards.get(7).equals(computerValue)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (boards.get(4).equals(computerValue) && boards.get(5).equals(computerValue)
                && boards.get(6).equals(computerValue)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (boards.get(7).equals(computerValue) && boards.get(8).equals(computerValue)
                && boards.get(9).equals(computerValue)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (boards.get(7).equals(computerValue) && boards.get(5).equals(computerValue)
                && boards.get(3).equals(computerValue)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (boards.get(3).equals(computerValue) && boards.get(6).equals(computerValue)
                && boards.get(9).equals(computerValue)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (boards.get(2).equals(computerValue) && boards.get(5).equals(computerValue)
                && boards.get(8).equals(computerValue)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (boards.get(1).equals(emptyValue) && boards.get(2).equals(emptyValue)
                && boards.get(3).equals(emptyValue) && boards.get(
                        4).equals(emptyValue)
                && boards.get(5).equals(emptyValue) && boards.get(6).equals(emptyValue)
                && boards.get(7).equals(emptyValue) && boards.get(8).equals(emptyValue)
                && boards.get(9).equals(emptyValue)) {
            System.out.println("It was a tie...");
            gameRunning = false;
        }
    }
}
