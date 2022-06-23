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
        Random random = new Random();
        int row;
        int col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (gameTable[row][col] != ' ');

        gameTable[row][col] = '0';
    }

    private static void makeUserMove(char[][] gameTable) {
        while (true) {
            System.out.println("Please type number between 1 and 9:");
            String string = (new Scanner(System.in)).nextLine();
            if (string.length() == 1) {
                char digit = string.charAt(0);
                if (digit >= '1' && digit <= '9' && makeUserMoveToCell(gameTable, digit)) {
                    return;
                }
            }
        }
    }

    private static boolean makeUserMoveToCell(char[][] gameTable, char digit) {
        char[][] mappingTable = new char[][]{{'7', '8', '9'}, {'4', '5', '6'}, {'1', '2', '3'}};
        for (int i = 0; i < mappingTable.length; ++i) {
            for (int j = 0; j < mappingTable[i].length; ++j) {
                if (mappingTable[i][j] == digit) {
                    if (gameTable[i][j] == ' ') {
                        gameTable[i][j] = 'X';
                        return true;
                    }
                    System.out.println("Can't make a move, because the cell is not free! Try again!");
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean userWin(char[][] gameTable) {
        return isWinner(gameTable, 'X');
    }

    private static boolean computerWin(char[][] gameTable) {
        return isWinner(gameTable, '0');
    }

    private static boolean isWinner(char[][] gameTable, char ch) {
        int i;
        for (i = 0; i < 3; ++i) {
            if (gameTable[i][0] == gameTable[i][1] && gameTable[i][0] == gameTable[i][2] && gameTable[i][0] == ch) {
                return true;
            }
        }

        for (i = 0; i < 3; ++i) {
            if (gameTable[0][i] == gameTable[1][i] && gameTable[0][i] == gameTable[2][i] && gameTable[0][i] == ch) {
                return true;
            }
        }

        if (gameTable[0][0] == gameTable[1][1] && gameTable[0][0] == gameTable[2][2] && gameTable[0][0] == ch) {
            return true;
        } else return gameTable[0][2] == gameTable[1][1] && gameTable[0][2] == gameTable[2][0] && gameTable[0][2] == ch;
    }

    private static boolean isDraw(char[][] gameTable) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (gameTable[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}