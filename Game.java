package Problems.java.TicTacToe;

import java.util.HashMap;
import java.util.Map;

public class Game {
    public static String gameStatus = "Unfinished";
    private static Map<String, Integer> playersPoints = new HashMap<>();

    public static String checkAndUpdateStatus(String[] board, String player1, String player2) {

        playersPoints.put(player1, 0);
        playersPoints.put(player2, 0);

        // Horizontal check
        for (int i = 0; i < board.length; i++) {

            if (board[i].equals(player1)) {
                increasePlayerScore(player1);
            }

            if (board[i].equals(player2)) {
                increasePlayerScore(player2);
            }

            if (didPlayerWin(player1)) return gameStatus = "Finished. " + player1 + " won.";
            if (didPlayerWin(player2)) return gameStatus = "Finished. " + player2 + " won.";

            if ((i + 1) % 3 == 0) {
                resetPlayersScore();
            }
        }

        resetPlayersScore();

        // Vertical check
        for (int i = 0; i < board.length / 3; i++) {

            for (int j = 0; j < board.length; j += 3) {
                if (board[i + j].equals(player1)) {
                    increasePlayerScore(player1);
                }
    
                if (board[i + j].equals(player2)) {
                    increasePlayerScore(player2);
                }
            }

            if (didPlayerWin(player1)) return gameStatus = "Finished. " + player1 + " won.";
            if (didPlayerWin(player2)) return gameStatus = "Finished. " + player2 + " won.";

            resetPlayersScore();
        }

        /*
            * Crossed check.

            * Checking at spot [4] first, since it is impossible to have any crossed
            marks without the middle one being marked.
        */
        if (board[4].equals(player1)) {
            if (board[0].equals(player1) && board[8].equals(player1)) return gameStatus = "Finished. " + player1 + " won.";
        }

        // Crossed check
        if (board[4].equals(player2)) {
            if (board[0].equals(player2) && board[8].equals(player2)) return gameStatus = "Finished. " + player2 + " won.";
        }

        return gameStatus;
    }

    private static void increasePlayerScore(String player) {
        playersPoints.put(player, playersPoints.get(player) + 1);
    }

    private static void resetPlayersScore() {
        for (String key : playersPoints.keySet()) {
            playersPoints.put(key, 0);
        }
    }

    private static boolean didPlayerWin(String player) {
        return playersPoints.get(player) >= 3;
    }
}
