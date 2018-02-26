import org.junit.Assert;
import org.junit.Test;

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

        // wont' compile until you create getSum method double sum = solver.getSum(simplestProblem);

        double sum = solver.getSum(simplestProblem);

        assertEquals(50.0d, sum, 0.0001d);


    }


}
