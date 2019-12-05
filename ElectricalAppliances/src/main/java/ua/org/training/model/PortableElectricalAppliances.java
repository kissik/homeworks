package ua.org.training.model;

import javafx.util.Pair;
import ua.org.training.view.GlobalConstants;

import java.util.ArrayList;

/**
 * <p>PortableElectricalAppliances is the class for
 * a portable electrical appliance</p>
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
public class PortableElectricalAppliances extends ElectricalAppliance {

    private int chargeLevel;
    /**
     * <p>PortableElectricalAppliance default constructor
     * with default values:</p>
     * <ul>
     * <li>the chargeLevel is 100 percent</li>
     * </ul>
     */
    public PortableElectricalAppliances(){
        chargeLevel = 100;
    }

    /**
     * <p>The chargeLevel field getter</p>
     * @return a charge level in percentage
     */
    public int getChargeLevel() {
        return chargeLevel;
    }

    /**
     * <p>The chargeLevel field setter method</p>
     * @param chargeLevel integer value of the charge level in percentage
     * @return reference to the current PortableElectricalAppliances object
     */
    public PortableElectricalAppliances setChargeLevel(int chargeLevel) {
        this.chargeLevel = chargeLevel;
        return this;
    }

    /**
     * <p>The overridden method of hash code computation.
     * The formula for computation is:</p>
     * <code>super.hashCode() * PRIME_NUMBER + chargeLevel,</code>
     * <p>where:</p>
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

    /**
     * <p>The overridden method for representing a portable electrical appliance information as a string</p>
     * @return          String value of a portable electrical appliance information in human readable format
     */
    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer(GlobalConstants.STRING_BUFFER_SIZE);
        return stringBuffer
                .append(super.toString())
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append(GlobalConstants.VIEW_PORTABLE_ELECTRICAL_APPLIANCE_CHARGE_LEVEL)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append(chargeLevel)
                .append(GlobalConstants.VIEW_PORTABLE_ELECTRICAL_APPLIANCE_CHARGE_UNIT)
                .toString();
    }

    /**
     * <p>The method for checking if object is satisfy the condition</p>
     * @return          true if object is satisfy the condition, otherwise - false
     */
    @Override
    public boolean findByParameters(ArrayList<Pair<String, String>> parameters){
        for(Pair<String, String> parameter : parameters) {
            if (parameter.getKey() == GlobalConstants.SEARCH_PORTABLE_ELECTRICAL_APPLIANCE_CHARGE_LEVEL)
                if (Integer.valueOf(parameter.getValue()) != chargeLevel) return false;
        }
        return super.findByParameters(parameters) && true;
    }
}
