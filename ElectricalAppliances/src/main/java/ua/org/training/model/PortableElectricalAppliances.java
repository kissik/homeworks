package ua.org.training.model;

public class PortableElectricalAppliances extends ElectricalAppliance {

    private int chargeLevel;

    public PortableElectricalAppliances(){
        chargeLevel = 100;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    public PortableElectricalAppliances setChargeLevel(int chargeLevel) {
        this.chargeLevel = chargeLevel;
        return this;
    }
}
