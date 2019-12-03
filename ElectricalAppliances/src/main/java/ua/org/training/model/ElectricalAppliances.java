package ua.org.training.model;

public class ElectricalAppliances {

    protected boolean plugIn;

    public ElectricalAppliances(){
        plugIn = false;
    }

    public boolean isPlugIn() {
        return plugIn;
    }

    public ElectricalAppliances setPlugIn(boolean plugIn) {
        this.plugIn = plugIn;
        return this;
    }
}
