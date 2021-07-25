package com.dr4kk0nnys.tic_tac_toe.controllers;

import java.util.*;
import java.util.function.Function;

import com.dr4kk0nnys.tic_tac_toe.models.*;

public class Game {
    public String gameStatus = "Unfinished";
    private Map<String, Integer> playersPoints = new HashMap<>();

    private Board board;

    public Game(Board boardTable) {
        board = boardTable;
    }

    public String checkStatus(String[] board, String[] players) {

        for (String player : players) {
            playersPoints.put(player, 0);

            // Horizontal check
            for (int i = 0; i < board.length; i++) {

                if (board[i].equals(player)) {
                    increasePlayerScore(player);
                }

                if (didPlayerWin(player)) return gameStatus = "Finished. " + player + " won.";

                if ((i + 1) % 3 == 0) {
                    resetPlayersScore();
                }
            }

            // Vertical check
            for (int i = 0; i < board.length / 3; i++) {

                for (int j = 0; j < board.length; j += 3) {
                    if (board[i + j].equals(player)) {
                        increasePlayerScore(player);
                    }
                }

                if (didPlayerWin(player)) return gameStatus = "Finished. " + player + " won.";

                resetPlayersScore();
            }

            /*
                * Crossed check.

                * Checking at spot [4] first, since it is impossible to have any crossed
                marks without the middle one being marked.
            */
            if (board[4].equals(player)) {
                if (board[0].equals(player) && board[8].equals(player)) return gameStatus = "Finished. " + player + " won.";
                if (board[2].equals(player) && board[6].equals(player)) return gameStatus = "Finished. " + player + " won.";
            }
        }

        return gameStatus;
    }

    private void increasePlayerScore(String player) {
        playersPoints.put(player, playersPoints.get(player) + 1);
    }

    private void resetPlayersScore() {
        for (String key : playersPoints.keySet()) {
            playersPoints.put(key, 0);
        }
    }

    private boolean didPlayerWin(String player) {
        return playersPoints.get(player) >= 3;
    }

    public Function<Integer, Void> observerFunction = (index) -> {
        checkStatus(board.getBoard(), Player.getPlayers());

        return null;
    };
}
