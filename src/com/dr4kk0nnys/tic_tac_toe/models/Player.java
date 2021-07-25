package com.dr4kk0nnys.tic_tac_toe.models;

public class Player {
    private static String[] players = new String[] { "X", "O" };
    private static int playerCount = 0;

    public static String[] getPlayers() {
        return players;
    }

    public static String getPlayer() {
        return players[playerCount++ % 2];
    }
}
