package ua.org.training.model;

public class StationaryElectricalAppliance extends ElectricalAppliance {
    public Dimensions dimensions;

    public StationaryElectricalAppliance(){
        dimensions = new Dimensions();
    }

    public StationaryElectricalAppliance(int width, int height, int depth){
        dimensions = new Dimensions(width, height, depth);
    }
}
