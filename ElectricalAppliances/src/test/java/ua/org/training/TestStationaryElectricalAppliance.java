package ua.org.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.org.training.model.StationaryElectricalAppliance;

public class TestStationaryElectricalAppliance {
    public static StationaryElectricalAppliance stationaryElectricalAppliance;

    @BeforeClass
    public static void testInit(){
        stationaryElectricalAppliance = new StationaryElectricalAppliance();
    }
    @Test
    public void testIsPlugIn(){
        Assert.assertTrue(stationaryElectricalAppliance.setPlugIn(true).isPlugIn());
    }
    @Test
    public void testDimensionsHashCode(){
        Assert.assertTrue(stationaryElectricalAppliance.dimensions.setHeight(1).setDepth(1).hashCode() == 32);
    }
}
