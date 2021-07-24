package com.dr4kk0nnys.tic_tac_toe;

import java.util.Scanner;
import java.util.function.Function;

import com.dr4kk0nnys.tic_tac_toe.controllers.Input;

public class Main {

    private static Board board = new Board();

    public static void main(String[] args) {

        Input.subscribe(observerFunction);
        Input.subscribe(observerFunction2);
        Input.subscribe(observerFunction3);

        while (Game.gameStatus.equals("Unfinished")) {
            Input.capture();
        }

        Input.close();
    }

    private static Function<Integer, Void> observerFunction = (index) -> {
        try {
            board.play(Player.getPlayer(), index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    };

    private static Function<Integer, Void> observerFunction2 = (index) -> {
        board.printBoard();

        return null;
    };
    
    private static Function<Integer, Void> observerFunction3 = (index) -> {
        Game.checkAndUpdateStatus(board.getBoard(), Player.getPlayers()[0], Player.getPlayers()[1]);

        return null;
    };
}
