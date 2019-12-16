package ua.org.training.spring.service;

import javafx.util.Pair;

import java.util.List;

/**
 * interface ElectricalApplianceService
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/16/2019
 */
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
