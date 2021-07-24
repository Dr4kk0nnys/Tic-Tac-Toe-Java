package com.dr4kk0nnys.tic_tac_toe;

import java.util.Arrays;

public class Board {

    private String[] board = new String[9];

    public Board() {
        // Setting an empty string instead of null
        Arrays.fill(board, " ");
    }

    public String[] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i] + " | ");

            // Every time it hits 3 or 6, switch rows. (+ 1) since it is 0 index based.
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    // Usually for tests only
    public void populateFakeBoard() {
        String[] players = Player.getPlayers();

        for (int i = 0; i < board.length; i++) {
            board[i] = players[(int) (Math.random() * players.length)];
        }
    }

    // Returns true if play was successful, false if it wasn't
    public boolean play(String player, int index) throws Exception {

        // Changing from 0 ~ 8 index based to 1 ~ 9
        index--;

        if (!player.equals("X") && !player.equals("O")) {
            throw new Exception("Invalid player.");
        }

        if (index > 8 || index < 0) {
            throw new Exception("Invalid Index.");
        }

        if (isIndexEmpty(index)) {
            board[index] = player;
            return true;
        }

        throw new Exception("Invalid Index.");
    }

    private boolean isIndexEmpty(int index) {
        return board[index] == " ";
    }
}
