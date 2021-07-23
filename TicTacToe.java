package Problems.java.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Board board = new Board();
        String player1 = Player.getPlayers()[0];
        String player2 = Player.getPlayers()[1];
        
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

            Game.checkAndUpdateStatus(board.getBoard(), player1, player2);
        }

        System.out.println(Game.gameStatus);

        scanner.close();
    }
    
}
