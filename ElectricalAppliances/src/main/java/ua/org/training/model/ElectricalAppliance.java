package ua.org.training.model;

/**
 * ElectricalAppliances is the basic class for
 * a portable and stationary electrical appliance
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/3/2019
 */

public class ElectricalAppliance {

    public static boolean ELECTRICAL_APPLIANCE_PLUG_IN_DEFAULT_VALUE = false;
    public static int ELECTRICAL_APPLIANCE_CAPACITY_DEFAULT_VALUE = 0;

    protected boolean plugIn;
    protected int capacity;
    protected String title;

    private void init(){
        plugIn = ELECTRICAL_APPLIANCE_PLUG_IN_DEFAULT_VALUE;
        capacity = ELECTRICAL_APPLIANCE_CAPACITY_DEFAULT_VALUE;
    }
    /**
     * ElectricalAppliance default constructor
     * with default values:
     * the plugIn field is false,
     * the capacity field is 0
     */
    public ElectricalAppliance(){
        init();
    }

    public ElectricalAppliance(String title){
        this.title = title;
        init();
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

}
