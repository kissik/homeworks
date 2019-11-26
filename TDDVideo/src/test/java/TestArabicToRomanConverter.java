import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.org.training.ArabicToRomanConverter;

public class TestArabicToRomanConverter {

    public static ArabicToRomanConverter a;

    @BeforeClass
    public static void TestInit(){
        a = new ArabicToRomanConverter();
    }

    @Test
    public void ConvertZeroToEmptyString(){
        Assert.assertEquals("", a.Convert(0));
    }

    @Test
    public void ConvertOneToI(){
        Assert.assertEquals("I", a.Convert(1));
    }

    @Test
    public void ConvertTwoToII(){
        Assert.assertEquals("II", a.Convert(2));
    }

    @Test
    public void ConvertThreeToIII(){
        Assert.assertEquals("III", a.Convert(3));
    }

    @Test
    public void ConvertFourToIV(){
        Assert.assertEquals("IV", a.Convert(4));
    }

    @Test
    public void ConvertFiveToV(){
        Assert.assertEquals("V", a.Convert(5));
    }

    @Test
    public void ConvertSixToVI(){
        Assert.assertEquals("VI", a.Convert(6));
    }

    @Test
    public void ConvertEightToVIII(){
        Assert.assertEquals("VIII", a.Convert(8));
    }
}