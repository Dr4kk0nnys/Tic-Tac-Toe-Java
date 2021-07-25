package com.dr4kk0nnys.tic_tac_toe;

import java.util.Arrays;
import java.util.function.Function;

import com.dr4kk0nnys.tic_tac_toe.models.BoardTable;

public class Board {

    private BoardTable board = new BoardTable();

    public String[] getBoard() {
        return board.getBoard();
    }

    private boolean isIndexEmpty(int index) {
        return board.atIndex(index).equals(" ");
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board.atIndex(i) + " | ");

            /*
                * Every time it hits 3 or 6, switch rows.

                * + 1 since it's 0 index based.
            */
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    /* Usually for tests only */
    public void populateFakeBoard() {
        String[] players = Player.getPlayers();

        for (int i = 0; i < board.length; i++) {
            board.setAtIndex(i, players[(int) (Math.random() * players.length)]);
        }
    }

    /* Return true if play was successful, throws error if not. */
    private boolean play(String player, int index) throws Exception {

        // Changing from 0 ~ 8 index to 1 ~ 9
        index--;

        if (!Arrays.asList(Player.getPlayers()).contains(player)) {
            throw new Exception("Invalid player.");
        }

        if (index > 8 || index < 0 || !isIndexEmpty(index)) {
            throw new Exception("Invalid Index.");
        }

        board.setAtIndex(index, player);
        return true;
    }

    public Function<Integer, Void> observerFunction = (index) -> {
        try {
            play(Player.getPlayer(), index);
            printBoard();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    };
}
