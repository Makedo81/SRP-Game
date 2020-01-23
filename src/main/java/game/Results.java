package game;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final static String  SCISSORS = "SCISSORS";
    private final static String  PAPER = "PAPER";
    private final static String  ROCK = "ROCK";
    private final static String  DRAW = "DRAW";
    private final List<String> winnerPlayer = new ArrayList<>();
    private final List<String> winnerComputer = new ArrayList<>();
    private String result = "";

    public String showResults(String figureOne, String figureTwo){
    String winner = "";
    switch(figureOne){
        case PAPER:{
            switch(figureTwo){
                case SCISSORS:
                    winner =  SCISSORS;
                return winner;
                case ROCK:
                    winner=  PAPER;
                return winner;
            }
        }
        case SCISSORS:{
            switch(figureTwo){
                case ROCK:
                    winner = ROCK;
                    return winner;
                case PAPER:
                    winner= SCISSORS;
                    return winner;
            }
        }
        case ROCK:{
            switch(figureTwo){
                case PAPER:
                    winner = PAPER;
                    return winner;
                case SCISSORS:
                    winner= ROCK;
                    return winner;
            }
        }
    }
    if(figureOne.equals(figureTwo)){
        winner = DRAW;

    }return  winner;
}

    public String checkResults(String valuePlayer, String valueComputer, String player){
        Results results = new Results();
        String winner = results.showResults(valuePlayer, valueComputer);
        if (winner.equals(valuePlayer) && !winner.equals(DRAW)) {
            result = player;
            winnerPlayer.add(result);
        } else if (winner.equals(valueComputer) && !winner.equals(DRAW)) {
            result = "Computer";
            winnerComputer.add(result);
        } else result = DRAW;
        return result;
    }
}
