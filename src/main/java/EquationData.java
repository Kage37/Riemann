public class EquationData {

    private final String equation;
    private final int where;
    private final double leftBound;
    private final double rightBound;
    private final int rectangles;

    public EquationData(String equation, int where, double leftBound, double rightBound, int rectangles) {
        this.equation = equation;
        this.where = where;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.rectangles = rectangles;}
    
    //Methods
    public String eqxn(){
      return equation;}
    public int where(){
      return where;}
    public double leftB(){
      return leftBound;}
    public double rightB(){
      return rightBound;}
    public int rect(){
      return rectangles;}
    }
