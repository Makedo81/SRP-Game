package game;

import figures.Figure;
import figures.FiguresPicker;
import java.util.*;

public class MovesCreator {

    private FiguresPicker figuresPicker = new FiguresPicker();
    private final Map<Integer,String> resultPlayer = new HashMap<>();
    private final Map<Integer,String> resultComputer = new HashMap<>();

    public Map<Integer,String> createComputerMove(int game){
        Random computerMove = new Random();
        int figureNumber = computerMove.nextInt(4);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Figure figure = figuresPicker.pickFigure(figureNumber);
        if(figureNumber==0){
            figure = figuresPicker.pickFigure(figureNumber+1);
        }
        if(figureNumber==4){
            figure = figuresPicker.pickFigure(figureNumber-1);
        }
        resultComputer.put(game,figure.showFigureName(figureNumber));
        return resultComputer;
    }

    public Map<Integer,String> createPersonMove(int chosenFigure,int gameNumber){
        Figure figure = figuresPicker.pickFigure(chosenFigure);
        resultPlayer.put(gameNumber,figure.showFigureName(chosenFigure));
        return resultPlayer;
    }

    public Map<Integer, String> getResultComputer() {
        return resultComputer;
    }
}
