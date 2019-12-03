package ua.org.training.model;

public class ElectricalAppliance {

    protected boolean plugIn;
    protected int capacity;

    public ElectricalAppliance(){
        plugIn = false;
        capacity = 0;
    }

    public boolean isPlugIn() {
        return plugIn;
    }

    public ElectricalAppliance setPlugIn(boolean plugIn) {
        this.plugIn = plugIn;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public ElectricalAppliance setCapacity(int capacity){
        this.capacity = capacity;
        return this;
    }
}
