public class TicTacToe {
    private static int ORDER = 3; // Assuming tic tac toe board is a square matrix of order 3

    private char[][] board;

    public TicTacToe() {
        board = new char[ORDER][ORDER];
        initializeBoard();
    }

    public void initializeBoard() {
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                board[row][column] = '-';
            }
        }
    }

    public void printBoard() {
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    public void updateBoardWithMarker(char marker, int row, int column) {
        board[row][column] = marker;
    }

    public boolean checkForWin(char marker, int row, int column) {
        if (checkForRowWin(marker, row) || checkForColumnWin(marker, column) || checkForDiagonalWin(marker, row, column))
            return true;

        return false;
    }

    public boolean checkForRowWin(char marker, int row) {
        int column = 0;

        if ((board[row][column] == marker) && (board[row][column + 1] == marker) && (board[row][column + 2] == marker))
            return true;

        return false;
    }

    public boolean checkForColumnWin(char marker, int column) {
        int row = 0;

        if ((board[row][column] == marker) && (board[row + 1][column] == marker) && (board[row + 2][column] == marker))
            return true;

        return false;
    }

    public boolean checkForDiagonalWin(char marker, int row, int column) {
        boolean win = false;

        if (row == column) {
            win = (board[0][0] == marker) && (board[1][1] == marker) && (board[2][2] == marker);
        }

        if (row + column == ORDER - 1) {
            int i = 0, j = ORDER - 1;
            win = (board[i][j] == marker)  && (board[i+1][j-1] == marker) && (board[i+2][j-2] == marker);
        }

        return win;
    }

    public boolean checkForDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '-') return false;
        return true;
    }

}
