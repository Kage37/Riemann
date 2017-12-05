import org.junit.Assert;
import org.junit.Test;


public class RiemannTest {

    @Test
    public void testGetWhere(){
        //do some code, get result
        int result = Riemann.getWhere("Foo");
        Assert.assertEquals("Expected UNKNOWN", Riemann.UNKNOWN, result);

        int midpointResult = Riemann.getWhere("Midpoint");
        Assert.assertEquals("Expected Right", Riemann.MIDPOINT, midpointResult);
    }


}
