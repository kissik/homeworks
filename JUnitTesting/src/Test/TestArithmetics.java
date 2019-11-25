package Test;

import Calculation.Arithmetics;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeoutException;

public class TestArithmetics {

    private static Arithmetics a;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @Rule
    public Timeout time = new Timeout(1000);

    @BeforeClass
    public static void runTest() {
        a = new Arithmetics();
    }
//
//    @After
//    public void finishTest(){
//        a = null;
//    }

    @Test
    public void testAdd() {
        double res = a.add(3.0, 7.0);
        Assert.assertTrue(res == 10.0);
        //Assert.assertEquals(10.0, res);
        //Assert.assertNotNull(a);
        //Assert.assertNull(a);
        //Assert.assertFalse(res != 10);
        //Assert.assertTrue(res == 10);
        //if (res != 10) Assert.fail();
    }

    @Test
    public void testMult() {
        double res = a.mult(3.0, 7.0);
        Assert.assertTrue(res == 21.0);
    }

    @Ignore
    @Test
    public void testDeduct() {
        double res = a.deduct(3.0, 7.0);
        Assert.assertTrue(res == -4.0);
    }

    @Test
    public void testDiv() {
        double res = a.div(6.0, 3.0);
        Assert.assertTrue(res == 2.0);
//        try {
//            a.div(6.0, 0.0);
//            Assert.fail();
//        }
//        catch (Exception e) { }

    }

    //@Test(expected = ArithmeticException.class)
    @Test
    public void testDivException(){
        exp.expect(ArithmeticException.class);
        a.div(6.0,0.0);
    }

    //@Test(timeout = 1000)
    @Test
    public void testTimeout(){
        while(true){ }
        //a.add(1.0, 2.5);
    }
}