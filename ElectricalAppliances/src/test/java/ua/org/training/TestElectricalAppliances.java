package ua.org.training;

import org.junit.Assert;
import org.junit.Test;
import ua.org.training.model.ElectricalAppliances;

public class TestElectricalAppliances {
    @Test
    public void testIsPlugIn(){
        ElectricalAppliances electricalAppliances = new ElectricalAppliances();
        Assert.assertTrue(electricalAppliances.isPlugIn());
    }


}
