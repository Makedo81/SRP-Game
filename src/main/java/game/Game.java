package game;

import java.util.*;

public class Game {

    private MovesCreator movesCreator = new MovesCreator();
    private Map<Integer,String> resultsMap = new HashMap<>();
    private Results results = new Results();

    public void gameResult(int figureNumber, int gameNumber, String player) {
        movesCreator.createPersonMove(figureNumber,gameNumber);
        movesCreator.createComputerMove(gameNumber);
        showSingleResult(gameNumber,player,figureNumber);
        createResultMap(player,gameNumber,figureNumber);
    }

     public Map<Integer,String> createResultMap(String player, int gameNumber, int figureNumber){
         Map<Integer,String> computerResultMap = movesCreator.getResultComputer();
         Set keys = resultsMap.keySet();
         for (Object o : keys) {
             Integer key = (Integer) o;
             String valuePlayer = movesCreator.createPersonMove(figureNumber,gameNumber).get(key);
             String valueComputer = computerResultMap.get(key);
             results.checkResults(valuePlayer,valueComputer,player);
         }
         return resultsMap;
     }

     public void showScores(String player, int gamesNumber, int figureNumber){
         createResultMap(player,gamesNumber,figureNumber);
         System.out.println("\n" + " ************ Scores *********** ");
         System.out.println(" Games number in total :  " + gamesNumber);
         System.out.println(" Player  " + player.toUpperCase() + " " + countPersonWinningGames(player) + " of " + gamesNumber + " games won");
         System.out.println(" " + "COMPUTER " + countComputerWinningGames() + " of " + gamesNumber + " games won");
     }

    public void showAllTurnsResult(String player, int gameNumber, int number){
        showFinalResult(player,gameNumber,number);
    }

    private Map<Integer,String> showFinalResult(String player, int gameNumber, int figureNumber){
        Set keys = resultsMap.keySet();
        Map<Integer,String> computerResultsMap = movesCreator.getResultComputer();
        for (Object o : keys) {
            Integer key = (Integer) o;
            String valuePlayer = movesCreator.createPersonMove(figureNumber,gameNumber).get(key);
            String valueComputer = computerResultsMap.get(key);
            String result = results.checkResults(valuePlayer,valueComputer,player);
            System.out.println(("\n" + "                               " + key + ") " + player + " " + valuePlayer + " : " + " Computer " + valueComputer));
            System.out.println("\n" + "                                WINNER : " + result);
            resultsMap.put(gameNumber,result);
        }
        System.out.println("\n" + "                                ************** GAME WINNER IS : " + chooseWinner(player).toUpperCase()+ " *****************");
        return resultsMap;
    }

    private Map<Integer,String> showSingleResult(int gameNumber, String player, int number) {
        Map<Integer,String> computerResultsMap = movesCreator.getResultComputer();
        String valuePlayer = movesCreator.createPersonMove(number,gameNumber).get(gameNumber);
        String valueComputer = computerResultsMap.get(gameNumber);
        String result = results.checkResults(valuePlayer,valueComputer,player);
        resultsMap.put(gameNumber,result);
        System.out.println(("\n" + "                               " + gameNumber + " )  " + player + " " + valuePlayer + " : " + " Computer " + valueComputer)+
                            "\n" + "                                           WINNER : " + result+
                            "\n" + "                                Computer winning games : " + countComputerWinningGames()+   "  Your winning games : " + countPersonWinningGames(player));
        return resultsMap;
    }

    public long countPersonWinningGames(String player){
        Long playerWin = resultsMap.entrySet().stream()
                .filter(e->e.getValue().equals(player))
                .count();
        return playerWin;
    }

    public long countComputerWinningGames(){
        Long computerWin = resultsMap.entrySet().stream()
                .filter(e->e.getValue().equals("Computer"))
                .count();
        return computerWin;
    }

    public String chooseWinner(String player){
        String gameWinner;
        long playersScore = countPersonWinningGames(player);
        long computerScores = countComputerWinningGames();
        if(playersScore > computerScores){
            gameWinner = player;
        }else gameWinner = "Computer";
        return gameWinner;
    }

    public void clearAllResults(){
        resultsMap.clear();
    }
}


