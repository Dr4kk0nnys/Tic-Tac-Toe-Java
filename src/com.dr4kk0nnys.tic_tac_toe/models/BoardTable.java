package com.dr4kk0nnys.tic_tac_toe.models;

import java.util.Arrays;

public class BoardTable {
    private String[] board = new String[9];

    public Board() {
        Arrays.fill(board, " ");
    }

    public String atIndex(Integer index) {
        return board[index];
    }

    public void setAtIndex(Integer index, String value) {
        board[index] = value;
    }
}
