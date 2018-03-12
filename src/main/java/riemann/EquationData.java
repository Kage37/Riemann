package riemann;

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
    public String getEqxn(){
      return equation;}
    public int getWhere(){
      return where;}
    public double getLeftB(){
      return leftBound;}
    public double getRightB(){
      return rightBound;}
    public int getRect(){
      return rectangles;}

    public String getReadableWhere(){
      switch(this.where){
        case 0: return "Left";
        case 1: return "Midpoint";
        case 2: return "Right";
      }
        return "UNKOWN";}
  }
}