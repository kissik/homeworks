package ua.org.training.model;

public class ElectricalAppliances {

    protected boolean plugIn;
    protected int capacity;

    public ElectricalAppliances(){
        plugIn = false;
        capacity = 0;
    }

    public boolean isPlugIn() {
        return plugIn;
    }

    public ElectricalAppliances setPlugIn(boolean plugIn) {
        this.plugIn = plugIn;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public ElectricalAppliances setCapacity(int capacity){
        this.capacity = capacity;
        return this;
    }
}
