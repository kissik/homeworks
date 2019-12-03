package ua.org.training.model;

/**
 * ElectricalAppliances is the basic class for
 * a mobile and stationary electrical appliance
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/3/2019
 */

public class ElectricalAppliance {

    protected boolean plugIn;
    protected int capacity;

    /**
     * ElectricalAppliance default constructor
     * with default values:
     * the plugIn field is false,
     * the capacity field is 0
     */
    public ElectricalAppliance(){
        plugIn = false;
        capacity = 0;
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
     * @return  capacity field in kilowatt hour
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * The capacity field setter method
     * @param capacity  integer value of the kilowatt hour unit
     * @return reference to the current ElectricalAppliance object
     */
    public ElectricalAppliance setCapacity(int capacity){
        this.capacity = capacity;
        return this;
    }
}
