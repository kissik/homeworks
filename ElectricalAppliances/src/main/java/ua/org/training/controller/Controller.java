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
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.exit;

public class Controller {
    private View view;
    private ArrayList<ElectricalAppliance> electricalAppliancesArrayList;
    private ArrayList<Pair<String, String>> parameters;

    public Controller(View view) {
        this.view = view;
        electricalAppliancesArrayList = new ArrayList<>();
        parameters = new ArrayList<>();
    }

    public void processUser() {
        readElectricalAppliances();
        printCollection(GlobalConstants.SORTING_MESSAGES_BEFORE);
        Collections.sort(electricalAppliancesArrayList);
        printCollection(GlobalConstants.SORTING_MESSAGES_AFTER);
        countTotalCapacity();
        findElectricityAppliance();
    }

    private void readElectricalAppliances(){
        readElectricalAppliancesFromFile(GlobalConstants.SOURCE_ELECTRICAL_APPLIANCE_FILE_NAME);
        readPortableElectricalAppliancesFromFile(GlobalConstants.SOURCE_PORTABLE_ELECTRICAL_APPLIANCE_FILE_NAME);
        readStationaryElectricalAppliancesFromFile(GlobalConstants.SOURCE_STATIONARY_ELECTRICAL_APPLIANCE_FILE_NAME);
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
                GlobalConstants.SEARCH_FILTER);
        for(Pair<String, String> parameter : parameters)
            view.printMessage(parameter.getKey() + ": " + parameter.getValue());
        view.printMessage(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER +
                GlobalConstants.SEARCH_RESULTS);
    }

    private void countTotalCapacity() {
        int totalCapacity = 0;
        for (ElectricalAppliance electricalAppliance : electricalAppliancesArrayList)
            if (electricalAppliance.isPlugIn()) totalCapacity += electricalAppliance.getCapacity();

        view.printMessage(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER +
                GlobalConstants.VIEW_TOTAL_CAPACITY +
                totalCapacity +
                GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION +
                GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_CAPACITY_UNIT);
    }

    private void readStationaryElectricalAppliancesFromFile(String fileName) {
        UtilityController utilityController = new UtilityController();
        ArrayList<String> array = utilityController
                .getLines(fileName);
        for(String string : array){
            electricalAppliancesArrayList.add(getStationaryElectricalAppliance(string));
        }
    }

    private void readPortableElectricalAppliancesFromFile(String fileName) {
        UtilityController utilityController = new UtilityController();
        ArrayList<String> array = utilityController
                .getLines(fileName);
        for(String string : array){
            electricalAppliancesArrayList.add(getPortableElectricalAppliance(string));
        }
    }

    private void readElectricalAppliancesFromFile(String fileName) {
        UtilityController utilityController = new UtilityController();
        ArrayList<String> array = utilityController
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

    private ElectricalAppliance getElectricalAppliance(String stringFromFile){
        ElectricalAppliance electricalAppliance = new ElectricalAppliance();
        if (stringFromFile.split(";").length != 3) exit(1);
        electricalAppliance.setTitle(stringFromFile.split(";")[0])
                .setCapacity(Integer.decode(stringFromFile.split(";")[1]))
                .setPlugIn(Boolean.valueOf(stringFromFile.split(";")[2]));
        return electricalAppliance;
    }

    private PortableElectricalAppliances getPortableElectricalAppliance(String stringFromFile){
        PortableElectricalAppliances portableElectricalAppliance = new PortableElectricalAppliances();
        if (stringFromFile.split(";").length != 4) exit(1);
        portableElectricalAppliance.setTitle(stringFromFile.split(";")[0])
                .setCapacity(Integer.decode(stringFromFile.split(";")[1]))
                .setPlugIn(Boolean.valueOf(stringFromFile.split(";")[2]));
        portableElectricalAppliance.setChargeLevel(Integer.decode(stringFromFile.split(";")[3]));

        return portableElectricalAppliance;
    }

    private StationaryElectricalAppliance getStationaryElectricalAppliance(String stringFromFile){
        StationaryElectricalAppliance stationaryElectricalAppliance = new StationaryElectricalAppliance();
        if (stringFromFile.split(";").length != 6) exit(1);
        stationaryElectricalAppliance.setTitle(stringFromFile.split(";")[0])
                .setCapacity(Integer.decode(stringFromFile.split(";")[1]))
                .setPlugIn(Boolean.valueOf(stringFromFile.split(";")[2]));
        Dimensions dimensions = new Dimensions(
                Integer.decode(stringFromFile.split(";")[3]),
                Integer.decode(stringFromFile.split(";")[4]),
                Integer.decode(stringFromFile.split(";")[5]));
        stationaryElectricalAppliance.setDimensions(dimensions);

        return stationaryElectricalAppliance;
    }
}
