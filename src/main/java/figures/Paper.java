package figures;

public class Paper implements Figure {

    public final static String  PAPER = "PAPER";

    @Override
    public String showFigureName(int number) {
        return PAPER;
    }
}
