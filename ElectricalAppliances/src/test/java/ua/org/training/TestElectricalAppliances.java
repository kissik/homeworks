package ua.org.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.org.training.model.ElectricalAppliance;

public class TestElectricalAppliances {
    private static  ElectricalAppliance electricalAppliance;

    @BeforeClass
    public static void testInit(){
        electricalAppliance = new ElectricalAppliance();
    }

    @Test
    public void testIsPlugIn(){
        electricalAppliance.setPlugIn(true);
        Assert.assertTrue(electricalAppliance.isPlugIn());
    }

    @Test
    public void testIsPlugOut(){
        electricalAppliance.setPlugIn(false);
        Assert.assertFalse(electricalAppliance.isPlugIn());
    }

    @Test
    public void testCapacity(){
        electricalAppliance.setCapacity(15);
        Assert.assertTrue(electricalAppliance.getCapacity() == 15);
    }

    @Test
    public void testHashCode(){
        Assert.assertTrue(electricalAppliance.setCapacity(15).hashCode() == 31 * 15);
    }

}
