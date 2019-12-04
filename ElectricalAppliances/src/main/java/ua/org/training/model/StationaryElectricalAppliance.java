package ua.org.training.model;

import ua.org.training.view.GlobalConstants;

/**
 * StationaryElectricalAppliance is the class for
 * a stationary electrical appliance,
 * extends ElectricalAppliance, for details read more
 * in {@link ua.org.training.model.ElectricalAppliance} link
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
public class StationaryElectricalAppliance extends ElectricalAppliance {

    private Dimensions dimensions;

    /**
     * StationaryElectricalAppliance default constructor
     */
    public StationaryElectricalAppliance(){
        dimensions = new Dimensions();
    }

    /**
     * StationaryElectricalAppliance constructor with parameters
     * @param title     String value of the title
     * @param width     integer value of the width in the centimeters
     * @param height    integer value of the height in the centimeters
     * @param depth     integer value of the depth in the centimeters
     */
    public StationaryElectricalAppliance(String title, int width, int height, int depth){
        super(title);
        dimensions = new Dimensions(width, height, depth);
    }

    /**
     * The dimensions field getter method
     * @return              reference to the Dimensions ({@link ua.org.training.model.Dimensions})
     * object of the current StationaryElectricalAppliance object
     */
    public Dimensions getDimensions() {
        return dimensions;
    }

    /**
     * The dimensions field setter method
     * @param dimensions    Dimension ({@link ua.org.training.model.Dimensions}) value of the current object
     * @return              reference of the current StationaryElectricalAppliance object
     */
    public StationaryElectricalAppliance setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    /**
     * The overridden method of hash code computation.
     * The formula for computation is:
     * super.hashCode() * PRIME_NUMBER + dimensions.hashCode(),
     * where:
     * <ul>
     *      <li>super is basic class of the current object.Please see the
     *      {@link ua.org.training.model.ElectricalAppliance} for details</li>
     *      <li>dimensions is field of the current object. Please see the
     *      {@link ua.org.training.model.Dimensions} for details</li>
     *      <li>PRIME_NUMBER is constant. Please see the
     *      {@link ua.org.training.view.GlobalConstants} interface for value</li>
     * </ul>
     * @return          integer value of hash code;
     */
    @Override
    public int hashCode(){
        return super.hashCode() * GlobalConstants.PRIME_NUMBER + dimensions.hashCode();
    }

    /**
     * The overridden method for representing a stationary electrical appliance information as a string.
     * @return          String value of a stationary electrical appliance information in human readable format
     */
    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer(GlobalConstants.STRING_BUFFER_SIZE);
        return stringBuffer
                .append(super.toString())
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER)
                .append(GlobalConstants.VIEW_STATIONARY_ELECTRICAL_APPLIANCE_DIMENTIONS)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append(dimensions.toString())
                .toString();
    }
}
