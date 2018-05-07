public class Main {
    private static final char PLAYER_1_MARKER='X';
    private static final char PLAYER_2_MARKER='O';

    private static int row;
    private static int column;

    public static void main(String[] args) {
        System.out.println("Tic Tac Toe 3X3 ...");
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.printBoard();
        System.out.println("Let's start playing the game....");

        String player = "Player 1";
        char marker = PLAYER_1_MARKER;
        boolean isWin, isDraw, stopPlaying;

        do {
            acceptMarkerPosition(player);
            ticTacToe.updateBoardWithMarker(marker, row, column);
            ticTacToe.printBoard();

            isWin = ticTacToe.checkForWin(marker, row, column);
            isDraw = ticTacToe.checkForDraw();
            stopPlaying = isWin || isDraw;

            if (stopPlaying) {
                String message = isWin ? player + ", Congratulations you won the game !!!" : "Its a draw !!!";
                System.out.println(message);
            } else {
                player = player.equals("Player 1") ? "Player 2" : "Player 1";
                marker = (marker == PLAYER_1_MARKER) ? PLAYER_2_MARKER : PLAYER_1_MARKER;
            }
        } while (!stopPlaying);
    }

    public static void acceptMarkerPosition(String player) {
        row = Utility.prompt(player + ": Enter row");
        column = Utility.prompt(player + ": Enter column");
    }
}