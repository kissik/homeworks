package ua.org.training.model;

import ua.org.training.view.GlobalConstants;

public class StationaryElectricalAppliance extends ElectricalAppliance {

    private Dimensions dimensions;

    public StationaryElectricalAppliance(){
        dimensions = new Dimensions();
    }

    public StationaryElectricalAppliance(String title, int width, int height, int depth){
        super(title);
        dimensions = new Dimensions(width, height, depth);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public StationaryElectricalAppliance setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    @Override
    public int hashCode(){
        return super.hashCode() * GlobalConstants.PRIME_NUMBER + dimensions.hashCode();
    }
}
