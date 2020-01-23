package figures;

public class Scissors implements Figure {

    public final static String  SCISSORS = "SCISSORS";

    @Override
    public String showFigureName(int number) {
        return SCISSORS;
    }
}
