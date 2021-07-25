package com.dr4kk0nnys.tic_tac_toe;

import java.util.Scanner;
import java.util.function.Function;

import com.dr4kk0nnys.tic_tac_toe.controllers.Input;

public class Main {
    private static Board board = new Board();
    private static Game game = new Game(board);

    public static void main(String[] args) {

        Input.subscribe(board.observerFunction);
        Input.subscribe(game.observerFunction);

        while (game.gameStatus.equals("Unfinished")) {
            Input.capture();
        }

        Input.close();
    }
}
