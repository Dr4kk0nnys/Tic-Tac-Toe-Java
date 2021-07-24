package com.dr4kk0nnys.tic_tac_toe.models;

import java.util.Arrays;

public class BoardTable {
    public int length = 9;
    private String[] board = new String[length];

    public BoardTable() {
        Arrays.fill(board, " ");
    }

    public String atIndex(int index) {
        return board[index];
    }

    public void setAtIndex(int index, String value) {
        board[index] = value;
    }

    public String[] getBoard() {
        return board;
    }
}
