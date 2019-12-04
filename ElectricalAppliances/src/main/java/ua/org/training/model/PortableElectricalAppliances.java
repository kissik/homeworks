package ua.org.training.model;

/**
 * PortableElectricalAppliances is the class for
 * a portable electrical appliance
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
public class PortableElectricalAppliances extends ElectricalAppliance {

    private int chargeLevel;
    /**
     * PortableElectricalAppliance default constructor
     * with default values:
     * the chargeLevel is 100 percent
     */
    public PortableElectricalAppliances(){
        chargeLevel = 100;
    }

    /**
     * The chargeLevel field getter
     * @return a charge level in percentage
     */
    public int getChargeLevel() {
        return chargeLevel;
    }

    /**
     * The chargeLevel field setter method
     * @param chargeLevel integer value of the charge level in percentage
     * @return reference to the current PortableElectricalAppliances object
     */
    public PortableElectricalAppliances setChargeLevel(int chargeLevel) {
        this.chargeLevel = chargeLevel;
        return this;
    }

    @Override
    public int hashCode(){
        return super.hashCode()*PRIME_NUMBER + chargeLevel;
    }
}
