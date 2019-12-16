package ua.org.training.spring.domain.entity;

import javafx.util.Pair;
import ua.org.training.spring.web.GlobalConstants;

import java.util.List;

/**
 * StationaryElectricalAppliance is the class for
 * a stationary electrical appliance,
 * extends ElectricalAppliance, for details read more
 * in {@link ElectricalAppliance} link
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
public class StationaryElectricalAppliance extends ElectricalAppliance {

    private Dimensions dimensions;

    /**
     * <p>StationaryElectricalAppliance default constructor</p>
     */
    public StationaryElectricalAppliance(){
        dimensions = new Dimensions();
    }

    /**
     * <p>StationaryElectricalAppliance constructor with parameters</p>
     * @param title     String value of the title
     * @param width     integer value of the width in the centimeters
     * @param height    integer value of the height in the centimeters
     * @param depth     integer value of the depth in the centimeters
     */
    public StationaryElectricalAppliance(String title, boolean plugIn, int capacity, int width, int height, int depth){
        super(plugIn, capacity, title);
        dimensions = new Dimensions(width, height, depth);
    }

    public StationaryElectricalAppliance(boolean plugIn, int capacity, String title, Dimensions dimensions) {
        super(plugIn, capacity, title);
        this.dimensions = dimensions;
    }

    /**
     * <p>The dimensions field getter method</p>
     * @return              reference to the Dimensions ({@link Dimensions})
     * object of the current StationaryElectricalAppliance object
     */
    public Dimensions getDimensions() {
        return dimensions;
    }

    /**
     * <p>The dimensions field setter method</p>
     * @param dimensions    Dimension ({@link Dimensions}) value of the current object
     * @return              reference of the current StationaryElectricalAppliance object
     */
    public StationaryElectricalAppliance setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    /**
     * <p>The overridden method of hash code computation.
     * The formula for computation is:</p>
     * <code>super.hashCode() * PRIME_NUMBER + dimensions.hashCode(),</code>
     * <p>where:</p>
     * <ul>
     *      <li>super is basic class of the current object.Please see the
     *      {@link ElectricalAppliance} for details</li>
     *      <li>dimensions is field of the current object. Please see the
     *      {@link Dimensions} for details</li>
     *      <li>PRIME_NUMBER is constant. Please see the
     *      {@link GlobalConstants} interface for value</li>
     * </ul>
     * @return          integer value of hash code;
     */
    @Override
    public int hashCode(){
        return super.hashCode() * GlobalConstants.PRIME_NUMBER + dimensions.hashCode();
    }

    /**
     * <p>The overridden method for representing a stationary electrical appliance information as a string</p>
     * @return          String value of a stationary electrical appliance information in human readable format
     */
    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer(GlobalConstants.STRING_BUFFER_SIZE);
        return stringBuffer
                .append(super.toString())
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append("Dimensions:")
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append(dimensions.toString())
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER)
                .toString();
    }

    /**
     * <p>The method for checking if object is satisfy the condition</p>
     * @return          true if object is satisfy the condition, otherwise - false
     */
    @Override
    public boolean findByParameters(List<Pair<String, String>> parameters){
        for(Pair<String, String> parameter : parameters) {
            if (parameter.getKey().equals(GlobalConstants.SEARCH_STATIONARY_ELECTRICAL_APPLIANCE_WIDTH))
                if (Integer.parseInt(parameter.getValue()) != dimensions.getWidth()) return false;
            if (parameter.getKey().equals(GlobalConstants.SEARCH_STATIONARY_ELECTRICAL_APPLIANCE_HEIGHT))
                if (Integer.parseInt(parameter.getValue()) != dimensions.getHeight()) return false;
            if (parameter.getKey().equals(GlobalConstants.SEARCH_STATIONARY_ELECTRICAL_APPLIANCE_DEPTH))
                if (Integer.parseInt(parameter.getValue()) != dimensions.getDepth()) return false;
        }
        return super.findByParameters(parameters);
    }

}