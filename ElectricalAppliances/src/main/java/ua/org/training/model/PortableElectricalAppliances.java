package ua.org.training.model;

import ua.org.training.view.GlobalConstants;

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

    /**
     * The overridden method of hash code computation.
     * The formula for computation is:
     * super.hashCode() * PRIME_NUMBER + chargeLevel,
     * where:
     * <ul>
     *      <li>super is basic class of the current object.Please see the
     *      {@link ua.org.training.model.ElectricalAppliance} for details</li>
     *      <li>chargeLevel is field of the current object</li>
     *      <li>PRIME_NUMBER is constant. Please see the
     *      {@link ua.org.training.view.GlobalConstants} interface for value</li>
     * </ul>
     * @return          integer value of hash code;
     */
    @Override
    public int hashCode(){
        return super.hashCode()* GlobalConstants.PRIME_NUMBER + chargeLevel;
    }
}
