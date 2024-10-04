package exercises.calculator;
import org.junit.Assert;

public class CalculatorTest {
    @org.junit.Test
    public void calculatorTest1(){
        Calculator calculator1 = new Calculator();
        Assert.assertEquals(calculator1.calculate("1+2"), 3);
    }
    @org.junit.Test
    public void calculatorTest2(){
        Calculator calculator2 = new Calculator();
        Assert.assertEquals(calculator2.calculate("1+2*5"), 11);
    }

}
