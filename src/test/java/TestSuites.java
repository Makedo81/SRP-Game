import figures.Figure;
import figures.FiguresPicker;
import game.Results;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class TestSuites {

    @Test
    public void shouldReturnGameResult(){
        //Given
        String rock = "ROCK";
        String paper = "PAPER";
        String draw = "DRAW";

        Map<Integer,String> resultAll = new HashMap<>();
        resultAll.put(1,"domi");
        resultAll.put(2,"domi");
        resultAll.put(3,paper);
        //When
        Results results = new Results();
        String result = results.showResults(paper,rock);
        String result1 = results.showResults(rock,rock);
        //Then
        Assert.assertEquals(paper,result);
        Assert.assertEquals(draw,result1);
    }

    @Test
    public void shouldReturnWinner(){
        //Given
        String rock = "ROCK";
        String paper = "PAPER";
        String scissors = "SCISSORS";
        String player = "player";
        //When
        Results results = new Results();
        String winner = results.checkResults(rock,paper,player);
        String winner1 = results.checkResults(rock,scissors,player);
        //Then
        Assert.assertEquals("Computer",winner);
        Assert.assertEquals(player,winner1);
    }

    @Test
    public void shouldReturnFigures(){
        //Given
        String rock = "ROCK";
        String paper = "PAPER";
        String scissors = "SCISSORS";

        //When
        FiguresPicker figuresPicker = new FiguresPicker();
        Figure figure = figuresPicker.pickFigure(1);
        Figure figure1 = figuresPicker.pickFigure(2);
        Figure figure2 = figuresPicker.pickFigure(3);
        //Then
        Assert.assertEquals(paper,figure.showFigureName(1));
        Assert.assertEquals(rock,figure1.showFigureName(2));
        Assert.assertEquals(scissors,figure2.showFigureName(3));
    }
}
