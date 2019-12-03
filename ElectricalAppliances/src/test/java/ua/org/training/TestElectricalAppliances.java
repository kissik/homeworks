package ua.org.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.org.training.model.ElectricalAppliances;

public class TestElectricalAppliances {
    private static  ElectricalAppliances electricalAppliances;

    @BeforeClass
    public static void testInit(){
        electricalAppliances = new ElectricalAppliances();
    }

    @Test
    public void testIsPlugIn(){
        electricalAppliances.setPlugIn(true);
        Assert.assertTrue(electricalAppliances.isPlugIn());
    }

    @Test
    public void testIsPlugOut(){
        electricalAppliances.setPlugIn(false);
        Assert.assertFalse(electricalAppliances.isPlugIn());
    }


}
