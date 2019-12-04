package ua.org.training.controller;

import ua.org.training.model.PortableElectricalAppliances;
import ua.org.training.view.GlobalConstants;
import ua.org.training.view.View;
import ua.org.training.model.ElectricalAppliance;

/**
 * class Controller
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.exit;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser() {
        ArrayList<ElectricalAppliance> electricalAppliancesArrayList = new ArrayList<>();
        readElectricalAppliancesFromFile(
                electricalAppliancesArrayList,
                GlobalConstants.SOURCE_ELECTRICAL_APPLIANCE_FILE_NAME);
        readPortableElectricalAppliancesFromFile(
                electricalAppliancesArrayList,
                GlobalConstants.SOURCE_PORTABLE_ELECTRICAL_APPLIANCE_FILE_NAME);
        printCollection(
                electricalAppliancesArrayList,
                GlobalConstants.SORTING_MESSAGES_BEFORE);
        Collections.sort(electricalAppliancesArrayList);
        printCollection(
                electricalAppliancesArrayList,
                GlobalConstants.SORTING_MESSAGES_AFTER);
    }

    private void readPortableElectricalAppliancesFromFile(ArrayList<ElectricalAppliance> electricalAppliancesArrayList, String fileName) {
        UtilityController utilityController = new UtilityController();
        ArrayList<String> array = utilityController
                .getLines(fileName);
        for(String string : array){
            electricalAppliancesArrayList.add(getPortableElectricalAppliance(string));
        }
    }

    private void readElectricalAppliancesFromFile(ArrayList<ElectricalAppliance> electricalAppliancesArrayList, String fileName) {
        UtilityController utilityController = new UtilityController();
        ArrayList<String> array = utilityController
                .getLines(fileName);
        for(String string : array){
            electricalAppliancesArrayList.add(getElectricalAppliance(string));
        }
    }

    private void printCollection(ArrayList<ElectricalAppliance> electricalAppliancesArrayList, String sortingMessagesBefore) {
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
}
