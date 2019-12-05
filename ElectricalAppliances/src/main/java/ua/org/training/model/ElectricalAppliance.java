package ua.org.training.model;

import javafx.util.Pair;
import ua.org.training.view.GlobalConstants;

import java.util.ArrayList;

/**
 * <p>ElectricalAppliances is the basic class for
 * a portable {@link ua.org.training.model.PortableElectricalAppliances}
 * and stationary {@link ua.org.training.model.StationaryElectricalAppliance} electrical appliance</p>
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/3/2019
 */

public class ElectricalAppliance implements Comparable<ElectricalAppliance> {

    protected boolean plugIn;
    protected int capacity;
    protected String title;
    protected ArrayList<Pair<String, String>> map;

    public ElectricalAppliance setViewTitle(String viewTitle){
        map.add(new Pair("title",viewTitle));
        return this;
    }

    public ElectricalAppliance setViewCapacity(String viewCapacity, String viewCapacityUnit){
        map.add(new Pair("capacity",viewCapacity));
        map.add(new Pair("capacityUnit",viewCapacityUnit));
        return this;
    }

    public ElectricalAppliance setViewPlug(String viewPlugIn, String viewPlugOut){
        map.add(new Pair("plugIn",viewPlugIn));
        map.add(new Pair("plugOut",viewPlugOut));
        return this;
    }

    private void init(){
        plugIn = GlobalConstants.ELECTRICAL_APPLIANCE_PLUG_IN_DEFAULT_VALUE;
        capacity = GlobalConstants.ELECTRICAL_APPLIANCE_CAPACITY_DEFAULT_VALUE;
        title = null;
        map = new ArrayList<>();
    }
    /**
     * <p>ElectricalAppliance default constructor with default values
     * <ul>
     * <li>the plugIn field is ELECTRICAL_APPLIANCE_PLUG_IN_DEFAULT_VALUE</li>
     * <li>the capacity field is ELECTRICAL_APPLIANCE_CAPACITY_DEFAULT_VALUE</li>
     * </ul>
     * Please see the {@link ua.org.training.view.GlobalConstants} interface for values</p>
     */
    public ElectricalAppliance(){
        init();
    }

    /**
     * <p>ElectricalAppliance constructor with parameters.
     * Please see the default constructor for default values of parameters</p>
     * @param title String value of the title of the electrical appliance
     */
    public ElectricalAppliance(String title){
        init();
        this.title = title;
    }

    /**
     * <p>The plugIn field getter method</p>
     * @return  plugIn  is the ElectricalAppliance plugged in or not
     */
    public boolean isPlugIn() {
        return plugIn;
    }

    /**
     * <p>The plugIn field setter method</p>
     * @param   plugIn  the true value stands for plugged in, the false - plugged out state
     * @return  reference to the current ElectricalAppliance object
     */
    public ElectricalAppliance setPlugIn(boolean plugIn) {
        this.plugIn = plugIn;
        return this;
    }

    /**
     * <p>The capacity field getter method</p>
     * @return  capacity field in kilowatt hour unit
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * <p>The capacity field setter method</p>
     * @param capacity  integer value of the capacity in kilowatt hour unit
     * @return reference to the current ElectricalAppliance object
     */
    public ElectricalAppliance setCapacity(int capacity){
        this.capacity = capacity;
        return this;
    }

    /**
     * <p>The title field getter method</p>
     * @return  title of the electrical appliance
     */
    public String getTitle() {
        return title;
    }

    /**
     * <p>The title field setter method</p>
     * @param   title   String value of the title of the electrical appliance
     * @return  reference to the current ElectricalAppliance object
     */
    public ElectricalAppliance setTitle(String title) {
        this.title = title;
        return this;
    }

     /**
     * <p>The overridden method of hash code computation.
     * The formula for computation is:</p>
     * <code>capacity * PRIME_NUMBER + title.hashCode(),</code>
     * <p>where:</p>
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

    /**
     * <p>The overridden method for representing a electrical appliance information as a string</p>
     * @return          String value of a electrical appliance information in human readable format
     */
    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer(GlobalConstants.STRING_BUFFER_SIZE);
        return stringBuffer
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append(getViewString("title"))
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append(title)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append(getViewString("capacity"))
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append(capacity)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append(getViewString("capacityUnit"))
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append(EnergyLabel.getLabel(capacity))
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION)
                .append((plugIn) ? getViewString("plugIn") : getViewString("plugOut"))
                .toString();
    }

    protected String getViewString(String key){
        for(Pair<String, String> pair : map){
            if (pair.getKey()==key) return pair.getValue();
        }
        return GlobalConstants.DEFAULT_STRING;
    }

    /**
     * <p>The method for implementing comparable interface</p>
     * @return          integer value of a electrical appliance information in human readable format
     */
    public int compareTo(ElectricalAppliance electricalAppliance) {
        return this.capacity > electricalAppliance.capacity
                ? 1
                : (this.capacity < electricalAppliance.capacity ? -1 : 0);
    }

    /**
     * <p>The method for checking if object is satisfy the condition</p>
     * @return          true if object is satisfy the condition, otherwise - false
     */
    public boolean findByParameters(ArrayList<Pair<String, String>> parameters){

        for(Pair<String, String> parameter : parameters) {
            if ((parameter.getKey() == GlobalConstants.SEARCH_ELECTRICAL_APPLIANCE_TITLE)
                    && (!parameter.getValue().equals(title))) return false;
            if ((parameter.getKey() == GlobalConstants.SEARCH_ELECTRICAL_APPLIANCE_CAPACITY)
                    && (Integer.valueOf(parameter.getValue()) != capacity)) return false;
            if ((parameter.getKey() == GlobalConstants.SEARCH_ELECTRICAL_APPLIANCE_PLUG_IN)
                    && (Boolean.valueOf(parameter.getValue()) != plugIn)) return false;
        }
        return true;
    }
}
