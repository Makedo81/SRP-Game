package figures;

public class Rock implements Figure {

    public final static String  ROCK = "ROCK";

    @Override
    public String showFigureName(int number) {
        return ROCK;
    }
}
