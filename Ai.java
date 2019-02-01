class Ai {

    private TicTacToe ticTacToe;

    Ai (TicTacToe ticTacToe) {

        this.ticTacToe = ticTacToe;

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

    private int eval (char[][] board) {

        for (int i = 0; i < board[0].length; i++) {

            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {

                if (board[i][0] == 'x') {

                    return 10;

                } else if (board[i][0] == 'o') {

                    return -10;

                }

            }

        }

        for (int i = 0; i < board[0].length; i++) {

            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {

                if (board[0][i] == 'x') {

                    return 10;

                } else if (board[0][i] == 'o') {

                    return -10;

                }

            }

        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {

            if (board[0][0] == 'x') {

                return 10;

            } else if (board[0][0] == 'o') {

                return -10;

            }

        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {

            if (board[0][2] == 'x') {

                return 10;

            } else if (board[0][2] == 'o') {

                return -10;

            }

        }

        return 0;

    }

    private int minimax (char[][] board, int depth, boolean isMax) {

        int score = eval(board);

        if (score == 10) {

            return score;

        }

        if (score == -10) {

            return score;

        }

        if (isMoves(board) == false) {

            return 0;

        }

        if (isMax) {

            int best = -1000;

            for (int i = 0; i < board.length; i++) {

                for (int j = 0; j < board[0].length; j++) {

                    if (board[i][j] == '-') {

                        board[i][j] = 'x';
                        best = Math.max(best, minimax(board, depth + 1, !isMax));

                        board[i][j] = '-';
                    }

                }

            }

            return best;

        } else {

            int best = 1000;

            for (int i = 0; i < board.length; i++) {

                for (int j = 0; j < board[0].length; j++) {

                    if (board[i][j] == '-') {

                        board[i][j] = 'o';
                        best = Math.min(best, minimax(board, depth + 1, !isMax));

                        board[i][j] = '-';
                    }

                }

            }

            return best;

        }

    }

    int[] bestMove (char[][] board) {

        int[] best = new int[2];
        best[0] = -1;
        best[1] = -1;
        int bestVal = -1000;

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '-') {

                    board[i][j] = 'x';
                    int val = minimax(board, 0, false);

                    board[i][j] = '-';

                    if (val > bestVal) {

                        best[0] = i;
                        best[1] = j;
                        bestVal = val;

                    }

                }

            }

        }

        return best;

    }

}
