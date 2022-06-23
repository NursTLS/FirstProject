import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public TicTacToe() {
    }

    public static void main(String[] args) {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        printTableMaking();
        char[][] gameTable = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        if ((new Random()).nextBoolean()) {
            makeComputerMove(gameTable);
            printGameTable(gameTable);
            System.out.println("Computer made a move.");
        }

        while (true) {
            makeUserMove(gameTable);
            printGameTable(gameTable);
            if (userWin(gameTable)) {
                System.out.println("YOU WIN!");
                break;
            }

            if (isDraw(gameTable)) {
                System.out.println("SORRY, DRAW!");
                break;
            }

            makeComputerMove(gameTable);
            printGameTable(gameTable);
            System.out.println("Computer made a move.");
            if (computerWin(gameTable)) {
                System.out.println("COMPUTER WIN!");
                break;
            }

            if (isDraw(gameTable)) {
                System.out.println("SORRY, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER!");
    }

    private static void printTableMaking() {
        char[][] mappingTable = new char[][]{{'7', '8', '9'}, {'4', '5', '6'}, {'1', '2', '3'}};
        printGameTable(mappingTable);
    }

    private static void printGameTable(char[][] gameTable) {
        for (int i = 0; i < 3; ++i) {
            System.out.println("-------------");

            for (int j = 0; j < 3; ++j) {
                System.out.print("| " + gameTable[i][j] + " ");
            }

            System.out.println("|");
        }

        System.out.println("-------------");
    }

    private static void makeComputerMove(char[][] gameTable) {
    }

    private static void makeUserMove(char[][] gameTable) {
    }

    private static boolean userWin(char[][] gameTable) {
        return true;
    }

    private static boolean computerWin(char[][] gameTable) {
        return true;
    }

    private static boolean isDraw(char[][] gameTable) {
        return true;
    }
}
