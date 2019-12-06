package ua.org.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.org.training.model.PortableElectricalAppliances;

public class TestPortableElectricalAppliances {
    private static PortableElectricalAppliances portableElectricalAppliances;
    private static final int CHARGE_LEVEL = 50;
    @BeforeClass
    public static void testInit(){
        portableElectricalAppliances = new PortableElectricalAppliances();
        portableElectricalAppliances.setChargeLevel(CHARGE_LEVEL);
    }

    @Test
    public void testIsPlugIn(){
        Assert.assertTrue(portableElectricalAppliances.setPlugIn(true).isPlugIn());
    }
    @Test
    public void testChargeLevel(){
        Assert.assertEquals(portableElectricalAppliances.getChargeLevel(), CHARGE_LEVEL);
    }
    @Test
    public void testHashCode(){
        Assert.assertEquals(portableElectricalAppliances.hashCode(), CHARGE_LEVEL);
    }
}
