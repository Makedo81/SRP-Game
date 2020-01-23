import game.Game;
import game.GameRules;
import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            Game game = new Game();
            GameRules gameRules = new GameRules();
            gameRules.showGamesRules();
            int number;
            boolean end;
            int turnsNumber;
            boolean newGame;
            System.out.println("Type you name : ");
            String player = sc.next();
            do {
                int counter = 1;
                System.out.println("Type number wining turns : ");
                turnsNumber = sc.nextInt();

                do {
                    System.out.println("\n" + "Game number: " + counter++ + ") Choose figure");
                    number = sc.nextInt();
                    game.gameResult(number, counter - 1, player);
                    game.countComputerWinningGames();
                    game.countPersonWinningGames(player);
                    if (game.countComputerWinningGames() == turnsNumber || game.countPersonWinningGames(player) == turnsNumber) {
                        end = true;
                    } else end = false;
                } while (!end);
                game.showScores(player, counter - 1, number);
                game.showAllTurnsResult(player, counter - 1, number);

                System.out.println("Do you want to finish?");
                game.clearAllResults();
                if (sc.nextLine().equals("x")) {
                newGame = true;
                } else newGame=false;

            } while (!sc.next().equals("x") && !newGame );
            System.out.println("Do you want to start new game?");
        } while (!sc.next().equals("x"));
    }
}
