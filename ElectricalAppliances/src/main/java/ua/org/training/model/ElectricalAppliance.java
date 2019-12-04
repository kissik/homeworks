package ua.org.training.model;

import ua.org.training.view.GlobalConstants;

/**
 * ElectricalAppliances is the basic class for
 * a portable and stationary electrical appliance
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/3/2019
 */

public class ElectricalAppliance {

    protected boolean plugIn;
    protected int capacity;
    protected String title;

    private void init(){
        plugIn = GlobalConstants.ELECTRICAL_APPLIANCE_PLUG_IN_DEFAULT_VALUE;
        capacity = GlobalConstants.ELECTRICAL_APPLIANCE_CAPACITY_DEFAULT_VALUE;
        title = null;
    }
    /**
     * ElectricalAppliance default constructor
     * with default values:
     * the plugIn field is ELECTRICAL_APPLIANCE_PLUG_IN_DEFAULT_VALUE
     * the capacity field is ELECTRICAL_APPLIANCE_CAPACITY_DEFAULT_VALUE
     * Please see the {@link ua.org.training.view.GlobalConstants} interface for values
     */
    public ElectricalAppliance(){
        init();
    }

    /**
     * ElectricalAppliance constructor with parameters
     * Please see the default constructor for default values of parameters
     * @param title String value of the title of the electrical appliance
     */
    public ElectricalAppliance(String title){
        init();
        this.title = title;
    }

    /**
     * The plugIn field getter method
     * @return  plugIn  is the ElectricalAppliance plugged in or not
     */
    public boolean isPlugIn() {
        return plugIn;
    }

    /**
     * The plugIn field setter method
     * @param   plugIn  the true value stands for plugged in, the false - plugged out state
     * @return  reference to the current ElectricalAppliance object
     */
    public ElectricalAppliance setPlugIn(boolean plugIn) {
        this.plugIn = plugIn;
        return this;
    }

    /**
     * The capacity field getter method
     * @return  capacity field in kilowatt hour unit
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * The capacity field setter method
     * @param capacity  integer value of the capacity in kilowatt hour unit
     * @return reference to the current ElectricalAppliance object
     */
    public ElectricalAppliance setCapacity(int capacity){
        this.capacity = capacity;
        return this;
    }

    /**
     * The title field getter method
     * @return  title of the electrical appliance
     */
    public String getTitle() {
        return title;
    }

    /**
     * The title field setter method
     * @param   title   String value of the title of the electrical appliance
     * @return  reference to the current ElectricalAppliance object
     */
    public ElectricalAppliance setTitle(String title) {
        this.title = title;
        return this;
    }

     /**
     * The overridden method of hash code computation.
     * The formula for computation is:
     * capacity * PRIME_NUMBER + title.hashCode(),
     * where:
     * <ul>
     *      <li>capacity is the field of the current object</li>
     *      <li>PRIME_NUMBER is constant. Please see the
     *      {@link ua.org.training.view.GlobalConstants} interface for value</li>
     * </ul>
     * @return          integer value of hash code;
     */
    @Override
    public int hashCode(){
        return capacity * GlobalConstants.PRIME_NUMBER + ((title == null) ? 0 : title.hashCode());
    }
}
