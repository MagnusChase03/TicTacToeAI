import java.util.Scanner;

public class TicTacToe {

    private char[][] board;
    private Ai ai;

    private TicTacToe () {

        board = new char[3][3];
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                board[i][j] = '-';

            }

        }

        this.ai = new Ai(this);

        play();

    }

    private void play () {

        Scanner scanner = new Scanner(System.in);

        showBoard();

        while (isMoves(board)) {


            System.out.print("Row: ");
            int row = scanner.nextInt();
            System.out.print("Col: ");
            int col = scanner.nextInt();

            board[row - 1][col - 1] = 'o';

            System.out.println();
            showBoard();
            System.out.println();

            if (checkwin()) {

                break;

            }

            int[] best = ai.bestMove(board.clone());
            if (best[0] > -1 && best[1] > -1) {

                board[best[0]][best[1]] = 'x';

            }

            System.out.println();
            showBoard();
            System.out.println();

            if (checkwin()) {

                break;

            }

        }

        showBoard();
    }

    private void showBoard () {

        for (char[] chars : board) {

            for (char chara : chars) {

                System.out.print(chara + " ");

            }

            System.out.println();

        }

    }

    private boolean checkwin () {

        for (int i = 0; i < board[0].length; i++) {

            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {

                if (board[i][0] != '-') {

                    return true;

                }

            }

        }

        for (int i = 0; i < board[0].length; i++) {

            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {

                if (board[0][i] != '-') {

                    return true;

                }

            }

        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {

            if (board[0][0] != '-') {

                return true;

            }

        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {

            if (board[0][2] != '-') {

                return true;

            }

        }

        return false;

    }

    private boolean isMoves (char[][] board) {

        for (char[] chars : board) {

            for (char chara : chars) {

                if (chara == '-') {

                    return true;

                }

            }

        }

        return false;

    }

    public static void main (String[] args) {

        new TicTacToe();

    }

}

