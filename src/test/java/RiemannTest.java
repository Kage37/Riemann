import org.junit.Assert;
import org.junit.Test;
import riemann.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class RiemannTest {

    @Test
    public void testGetWhere(){
        //do some code, get result
        int result = Riemann.getWhere("Foo");
        assertEquals("Expected UNKNOWN", Riemann.UNKNOWN, result);

        int midpointResult = Riemann.getWhere("Midpoint");
        assertEquals("Expected Midpoint", Riemann.MIDPOINT, midpointResult);
    }

    @Test
    public void testRiemannWithSimpleEquation(){
        //inputs

        EquationData simplestProblem = new EquationData(
                "x",
                Riemann.MIDPOINT,
                0.0d,
                10.0d,
                10
        );

        Riemann solver = new Riemann();

        //results

        /*wont' compile until you create getSum method */
        double sum = solver.getSum(simplestProblem);

        Assert.assertEquals(50.0d, sum, 0.0001d);

        //assertTrue(false);
    }
    
   @Test
    public void testRiemannWithLeftEquation(){
        //inputs

        EquationData problem = new EquationData(
                "1-x^4+3x^2",
                Riemann.LEFT,
                -5.0d,
                10.0d,
                20
        );

        Riemann solver = new Riemann();

        //results

        double sum = solver.getSum(problem);

        Assert.assertEquals( -16260.310546875d, sum, 0.0001d);
   }
       
   @Test
    public void testRiemannWithRightEquation(){
        //inputs

        EquationData problem = new EquationData(
                "1-2x^4+5x^2",
                Riemann.RIGHT,
                -52.0d,
                17.0d,
                23
        );

        Riemann solver = new Riemann();

        //results

        double sum = solver.getSum(problem);

        Assert.assertEquals( -131613015d, sum, 0.0001d);
   }
   
       
   @Test
    public void testRiemannWithHardEquation(){
        //inputs

        EquationData problem = new EquationData(
                "2/3x^9-1/7x^8+23/4x^7-67x^6-1/3x^5+233x^4+7x^3-x^2-99/7x-100",
                Riemann.MIDPOINT,
                0d,
                1d,
                100
        );

        Riemann solver = new Riemann();

        //results

        double sum = solver.getSum(problem);

        Assert.assertEquals( -67.91467089d, sum, 0.0000001d);
   }
}
