import java.util.*;
  

public class Riemann{

  public static final int LEFT = 0;
  public static final int MIDPOINT = 1;
  public static final int RIGHT = 2;
  public static final int UNKNOWN = -1;

  //Finds Value of Y Given the Equation and the current X Value
    public static double calculateY(String equation, double xval){
      int curIndex = 0;
      int endIndex = 0;
      double yval = 0;
      
      // Accomodates for the +1 in the Term for loop if polynomial is 1 character long
      if(!equation.substring(0,1).equals("-")){
        equation = "+"+equation;}
      
      for(int lcv = 0; lcv < equation.length(); lcv = curIndex){
      //Resets Values for Next Term
      String term = "";
      double coef = 0;
      int xIndex = -1;
      double xpower = 1;
      

      //Determines where the Term Is
       for(int i = curIndex+1; i<equation.length(); i++){
        if(equation.substring(i,i+1).equals("+") || equation.substring(i,i+1).equals("-")){
          endIndex = i;
          term = equation.substring(curIndex,endIndex);
          i = equation.length();}
        else{
          term = equation.substring(curIndex);}
        }

      //Checks the location of X and value of Coefficient
      for(int i = 0; i < term.length(); i++){
         if(term.substring(0,1).equals("x")){
          coef = 1;
          xIndex = 0;}
         else{
        if(term.substring(i,i+1).equals("x") && (term.substring(0,i).length() > 0)){
          if(term.substring(0,i).equals("+") || term.substring(0,i).equals("-")){ //Incase no proper number is present
            coef = Double.parseDouble(term.substring(0,1)+"1");
             }
          else{
            // Accomodates for Fractional Coefficients
            if(term.substring(0,i).indexOf("/")>-1){
              coef =  Double.parseDouble(term.substring(0,term.indexOf("/"))) / Double.parseDouble(term.substring(term.indexOf("/")+1,i));}
            else{
              coef = Double.parseDouble(term.substring(0,i));}}
          xIndex = i;}
         }}

      //Checks if ^ is used to indicate a higher power and adds to total value
      if(xIndex != -1 && xIndex+2 < term.length() && term.substring(xIndex+1,xIndex+2).equals("^")){
        for(int exp = 0; exp<Integer.parseInt(term.substring(xIndex+2)); exp++){ //x^n, n>1
          xpower *= xval;
        }
          yval += xpower*coef;}
      else{
        if(term.length()-1 == xIndex){ // x^1
          yval += coef*xval;
        }
        else{
          coef = Double.parseDouble(term); //x^0
          yval += coef;
        }}
      
      //Prepare for Next Term or End
      if(curIndex != endIndex){
        curIndex = endIndex;}

      else{
        curIndex = equation.length();}
      }
    return yval;}
    
    
    // Main Method
    public static void main(String[]args){
      System.out.println("Welcome to Kage's Riemann Sum Calculator!");
      int where = getRiemannLocation();


      //Sets Values of the Equation, Bounds, and Step
      System.out.println("What equation are you calculating Riemann Sums for? (Format as a polynomial: 3x^2+2/3x-1.2)");
      System.out.print("F(x) = ");
      Scanner eqScan = new Scanner(System.in);
      String equation = eqScan.nextLine();
      
      System.out.print("With the Left Bound as: ");
      Scanner leftb = new Scanner(System.in);
      double leftbound = leftb.nextDouble();
      
      System.out.print("And the Right Bound as: ");
      Scanner rightb = new Scanner(System.in);
      double rightbound = rightb.nextDouble();
      
      System.out.print("How many rectangles will be used to calculate? ");
      Scanner stepp = new Scanner(System.in);
      int rectan = stepp.nextInt();
      double step = (rightbound-leftbound)/rectan;
      
      double currentx = 0;
      
      //Puts all X-Values to be used in an Array
      double[][] xychart = new double[2][rectan];
      if(where == LEFT){
        currentx = leftbound;}
      if(where == MIDPOINT){
        currentx = leftbound + step/2;}
      if(where == RIGHT){
        currentx = leftbound + step;}
      for(int i = 0; i<rectan; i++){
        xychart[0][i] = currentx;
        currentx += step;}
      
      //Puts Y Values into the Array
      for(int i = 0; i<rectan; i++){
        xychart[1][i] = calculateY(equation, xychart[0][i]);}
      
      double sum = 0;
      for(int i = 0; i<rectan; i++){
        sum += xychart[1][i]*step;}
      System.out.println(sum); // Final Value Printed
    }

   static int getRiemannLocation() {
    //Sets a Value to where Riemanns will be Calculated
    boolean loc = true;
    int where = UNKNOWN;
    while(loc){
    System.out.println("Would you like to do [Left], [Right], or [Midpoint] Riemann Sums?");
    Scanner lrmScan = new Scanner(System.in);
    String lrm = lrmScan.nextLine();
      where = getWhere(lrm);
    loc = false;
    if(where == -1){
      System.out.println("Invalid Input - Try Again");
      loc = true;
    }}
    return where;
  }

  static int getWhere(String lrm) {
      int where = UNKNOWN;
      if(lrm.equalsIgnoreCase("Left")){
      where = LEFT;}
    if(lrm.equalsIgnoreCase("Midpoint")){
      where = MIDPOINT;}
    if(lrm.equalsIgnoreCase("Right")){
      where = RIGHT;}
    return where;
  }
}
