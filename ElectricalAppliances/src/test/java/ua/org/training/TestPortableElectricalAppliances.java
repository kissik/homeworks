package ua.org.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.org.training.model.PortableElectricalAppliances;

public class TestPortableElectricalAppliances {
    private static PortableElectricalAppliances portableElectricalAppliances;
    @BeforeClass
    public static void testInit(){
        portableElectricalAppliances = new PortableElectricalAppliances();
    }

    @Test
    public void testIsPlugIn(){
        Assert.assertTrue(portableElectricalAppliances.setPlugIn(true).isPlugIn());
    }
    @Test
    public void testChargeLevel(){
        Assert.assertTrue(portableElectricalAppliances.setChargeLevel(50).getChargeLevel()==50);
    }
}
