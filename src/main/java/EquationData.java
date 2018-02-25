public class EquationData {

    public final String equation;
    public final int where;
    public final double leftBound;
    public final double rightBound;
    public final int rectangles;

    public EquationData(String equation, int where, double leftBound, double rightBound, int rectangles) {
        this.equation = equation;
        this.where = where;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.rectangles = rectangles;
    }

}
