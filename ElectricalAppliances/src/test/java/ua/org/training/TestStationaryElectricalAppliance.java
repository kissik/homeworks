package ua.org.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.org.training.model.StationaryElectricalAppliance;

public class TestStationaryElectricalAppliance {
    private final int PRIME_NUMBER = 31;
    private static final int DIMENSION_WIDTH = 1;
    private static final int DIMENSION_HEIGHT = 2;
    private static final int DIMENSION_DEPTH = 3;

    public static StationaryElectricalAppliance stationaryElectricalAppliance;

    @BeforeClass
    public static void testInit(){
        stationaryElectricalAppliance = new StationaryElectricalAppliance();
        stationaryElectricalAppliance.dimensions.setWidth(DIMENSION_WIDTH)
                .setHeight(DIMENSION_HEIGHT)
                .setDepth(DIMENSION_DEPTH);
    }
    @Test
    public void testIsPlugIn(){
        Assert.assertTrue(stationaryElectricalAppliance.setPlugIn(true).isPlugIn());
    }
    @Test
    public void testDimensionsHashCode(){
        int hashCode = (DIMENSION_WIDTH * PRIME_NUMBER + DIMENSION_HEIGHT) * PRIME_NUMBER + DIMENSION_DEPTH;
        Assert.assertTrue(stationaryElectricalAppliance.dimensions
                .hashCode() == hashCode);
    }
    @Test
    public void testHashCode(){
        int hashCode = stationaryElectricalAppliance.dimensions.hashCode();
        Assert.assertTrue(stationaryElectricalAppliance.hashCode() == hashCode);
    }
}
