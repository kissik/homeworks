package ua.org.training.controller;

import javafx.util.Pair;
import ua.org.training.model.Dimensions;
import ua.org.training.model.PortableElectricalAppliances;
import ua.org.training.model.StationaryElectricalAppliance;
import ua.org.training.view.GlobalConstants;
import ua.org.training.view.View;
import ua.org.training.model.ElectricalAppliance;

/**
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.exit;

public class Controller {
    private View view;
    private List<ElectricalAppliance> electricalAppliancesArrayList;
    private List<Pair<String, String>> parameters;

    public Controller(View view) {
        this.view = view;
        electricalAppliancesArrayList = new ArrayList<>();
        parameters = new ArrayList<>();
    }

    public void processUser() {
        readElectricalAppliances();
        printCollection(
                view.getString(GlobalConstants.SORTING_MESSAGES_BEFORE));
        Collections.sort(electricalAppliancesArrayList);
        printCollection(
                view.getString(GlobalConstants.SORTING_MESSAGES_AFTER));
        countTotalCapacity();
        findElectricityAppliance();
    }

    private void readElectricalAppliances(){ // --
        readElectricalAppliancesFromFile(
                view.getString(GlobalConstants.SOURCE_ELECTRICAL_APPLIANCE_FILE_NAME));
        readPortableElectricalAppliancesFromFile(
                view.getString(GlobalConstants.SOURCE_PORTABLE_ELECTRICAL_APPLIANCE_FILE_NAME));
        readStationaryElectricalAppliancesFromFile(
                view.getString(GlobalConstants.SOURCE_STATIONARY_ELECTRICAL_APPLIANCE_FILE_NAME));
    }

    private void findElectricityAppliance() {
        addFilterParameters();
        for (ElectricalAppliance electricalAppliance : electricalAppliancesArrayList)
            if (electricalAppliance.findByParameters(parameters)) view.printMessage(electricalAppliance.toString());
    }
    private void addFilterParameters(){
        //parameters.add(new Pair(GlobalConstants.SEARCH_ELECTRICAL_APPLIANCE_TITLE, "Washing Machine"));
        //parameters.add(new Pair(GlobalConstants.SEARCH_ELECTRICAL_APPLIANCE_CAPACITY, "15"));
        parameters.add(new Pair(GlobalConstants.SEARCH_ELECTRICAL_APPLIANCE_PLUG_IN, "false"));
        parameters.add(new Pair(GlobalConstants.SEARCH_STATIONARY_ELECTRICAL_APPLIANCE_WIDTH, "70"));
        parameters.add(new Pair(GlobalConstants.SEARCH_PORTABLE_ELECTRICAL_APPLIANCE_CHARGE_LEVEL, "75"));

        view.printMessage(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER +
                view.getString(GlobalConstants.SEARCH_FILTER));
        for(Pair<String, String> parameter : parameters)
            view.printMessage(parameter.getKey() + ": " + parameter.getValue());
        view.printMessage(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER +
                view.getString(GlobalConstants.SEARCH_RESULTS));
    }

    private void countTotalCapacity() {
        int totalCapacity = 0;
        for (ElectricalAppliance electricalAppliance : electricalAppliancesArrayList)
            if (electricalAppliance.isPlugIn()) totalCapacity += electricalAppliance.getCapacity();

        view.printMessage(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER +
                view.getString(GlobalConstants.VIEW_TOTAL_CAPACITY) +
                totalCapacity +
                GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION +
                view.getString(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_CAPACITY_UNIT));
    }

    private void readStationaryElectricalAppliancesFromFile(String fileName) {
        UtilityController utilityController = new UtilityController();
        List<String> array = utilityController
                .getLines(fileName);
        for(String string : array){
            electricalAppliancesArrayList.add(getStationaryElectricalAppliance(string));
        }
    }

    private void readPortableElectricalAppliancesFromFile(String fileName) {
        UtilityController utilityController = new UtilityController();
        List<String> array = utilityController
                .getLines(fileName);
        for(String string : array){
            electricalAppliancesArrayList.add(getPortableElectricalAppliance(string));
        }
    }

    private void readElectricalAppliancesFromFile(String fileName) {
        UtilityController utilityController = new UtilityController();
        List<String> array = utilityController
                .getLines(fileName);
        for(String string : array){
            electricalAppliancesArrayList.add(getElectricalAppliance(string));
        }
    }

    private void printCollection(String sortingMessagesBefore) {
        view.printMessage(sortingMessagesBefore);
        for (ElectricalAppliance electricalAppliance : electricalAppliancesArrayList)
            view.printMessage(electricalAppliance.toString());
    }

    private void initElectricalAppliance(ElectricalAppliance electricalAppliance, String stringFromFile){
        electricalAppliance
                .setViewCapacity(view.getString(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_CAPACITY),
                        view.getString(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_CAPACITY_UNIT))
                .setViewTitle(view.getString(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TITLE))
                .setViewPlug( view.getString(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_PLUG_IN),
                        view.getString(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_PLUG_OUT))
                .setTitle(stringFromFile.split(";")[0])
                .setCapacity(Integer.decode(stringFromFile.split(";")[1]))
                .setPlugIn(Boolean.valueOf(stringFromFile.split(";")[2]));
    }

    private ElectricalAppliance getElectricalAppliance(String stringFromFile){
        ElectricalAppliance electricalAppliance = new ElectricalAppliance();
        if (stringFromFile.split(";").length != 3) exit(1);

        initElectricalAppliance(electricalAppliance, stringFromFile);
        return electricalAppliance;
    }

    private PortableElectricalAppliances getPortableElectricalAppliance(String stringFromFile){
        PortableElectricalAppliances portableElectricalAppliance = new PortableElectricalAppliances();
        if (stringFromFile.split(";").length != 4) exit(2);

        initElectricalAppliance(portableElectricalAppliance, stringFromFile);

        portableElectricalAppliance
                .setViewChargeLevel(view.getString(
                        GlobalConstants.VIEW_PORTABLE_ELECTRICAL_APPLIANCE_CHARGE_LEVEL))
                .setChargeLevel(Integer.decode(stringFromFile.split(";")[3]));

        return portableElectricalAppliance;
    }

    private StationaryElectricalAppliance getStationaryElectricalAppliance(String stringFromFile){
        StationaryElectricalAppliance stationaryElectricalAppliance = new StationaryElectricalAppliance();
        if (stringFromFile.split(";").length != 6) exit(3);

        initElectricalAppliance(stationaryElectricalAppliance, stringFromFile);

        Dimensions dimensions = new Dimensions(
                Integer.decode(stringFromFile.split(";")[3]),
                Integer.decode(stringFromFile.split(";")[4]),
                Integer.decode(stringFromFile.split(";")[5]));

        stationaryElectricalAppliance
                .setViewDimensions(
                        view.getString(
                                GlobalConstants.VIEW_STATIONARY_ELECTRICAL_APPLIANCE_DIMENSIONS))
                .setDimensions(dimensions);

        return stationaryElectricalAppliance;
    }
}
