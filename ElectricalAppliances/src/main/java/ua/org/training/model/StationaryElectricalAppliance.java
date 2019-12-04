package ua.org.training.model;

public class StationaryElectricalAppliance extends ElectricalAppliance {
    public Dimensions dimensions;

    public StationaryElectricalAppliance(){
        dimensions = new Dimensions();
    }

    public StationaryElectricalAppliance(String title, int width, int height, int depth){
        super(title);
        dimensions = new Dimensions(width, height, depth);
    }

    @Override
    public int hashCode(){
        return super.hashCode() * PRIME_NUMBER + dimensions.hashCode();
    }
}
