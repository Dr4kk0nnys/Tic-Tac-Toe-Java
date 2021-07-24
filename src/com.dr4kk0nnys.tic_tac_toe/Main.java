package com.dr4kk0nnys.tic_tac_toe;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Board board = new Board();
    static String[] players = Player.getPlayers();

    public static void main(String[] args) {

        // board.populateFakeBoard();

        while (Game.gameStatus.equals("Unfinished")) {
            System.out.print("[1 ~ 9]: ");
            int index = scanner.nextInt();

            try {
                board.play(Player.getPlayer(), index);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            board.printBoard();

            Game.checkAndUpdateStatus(board.getBoard(), players[0], players[1]);
        }

        System.out.println(Game.gameStatus);

        scanner.close();
    }
    
}
