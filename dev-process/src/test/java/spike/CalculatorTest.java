package spike;

import junit.framework.Assert;
import org.junit.Test;

public class CalculatorTest
{
    @Test
    public void sum()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(7L, calculator.sum(2, 5));
    }
}
