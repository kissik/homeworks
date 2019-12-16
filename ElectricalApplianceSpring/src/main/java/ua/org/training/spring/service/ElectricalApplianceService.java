package ua.org.training.spring.service;

import javafx.util.Pair;

import java.util.List;

public interface ElectricalApplianceService {

    /**
     * <p>The plugIn field getter method</p>
     * @return  plugIn  is the ElectricalAppliance plugged in or not
     */
    boolean isPlugIn();

    /**
     * <p>The capacity field getter method</p>
     * @return  capacity field in kilowatt hour unit
     */
    int capacity();

    /**
     * <p>The title of the electrical appliance</p>
     * @return  title of the electrical appliance
     */
    String getTitle();

    /**
     * <p>The overridden method for representing a electrical appliance information as a string</p>
     * @return          String value of a electrical appliance information in human readable format
     */
    String toString();

    /**
     * <p>The method for checking if object is satisfy the condition</p>
     * @return          true if object is satisfy the condition, otherwise - false
     */
    boolean findByParameters(List<Pair<String, String>> parameters);

    static int compareTo(ElectricalApplianceService a, ElectricalApplianceService b) {
        return Integer.compare(a.capacity(), b.capacity());
    }
}
