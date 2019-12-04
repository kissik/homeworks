package ua.org.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.org.training.model.ElectricalAppliance;

public class TestElectricalAppliances {
    private static ElectricalAppliance electricalAppliance;
    private final static int CAPACITY = 15;
    private final int PRIME_VALUE = 31;

    @BeforeClass
    public static void testInit(){
        electricalAppliance = new ElectricalAppliance();
        electricalAppliance.setCapacity(CAPACITY);
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
        Assert.assertTrue(electricalAppliance.getCapacity() == CAPACITY);
    }

    @Test
    public void testHashCode(){
        Assert.assertTrue(electricalAppliance.hashCode() == PRIME_VALUE * CAPACITY);
    }

}
