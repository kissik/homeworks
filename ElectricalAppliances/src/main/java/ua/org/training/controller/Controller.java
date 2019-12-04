package ua.org.training.controller;

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
        UtilityController utilityController = new UtilityController();
        ArrayList<ElectricalAppliance> electricalAppliancesArrayList = new ArrayList<>();
        readElectricalAppliancesFromFile(utilityController, electricalAppliancesArrayList);

        printCollection(electricalAppliancesArrayList, GlobalConstants.SORTING_MESSAGES_BEFORE);
        Collections.sort(electricalAppliancesArrayList);
        printCollection(electricalAppliancesArrayList, GlobalConstants.SORTING_MESSAGES_AFTER);
    }

    private void readElectricalAppliancesFromFile(UtilityController utilityController, ArrayList<ElectricalAppliance> electricalAppliancesArrayList) {
        ArrayList<String> array = utilityController
                .getLines(GlobalConstants.SOURCE_ELECTRICAL_APPLIANCE_FILE_NAME);
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
        electricalAppliance.setTitle(stringFromFile.split(";")[0]);
        electricalAppliance.setCapacity(Integer.decode(stringFromFile.split(";")[1]));
        electricalAppliance.setPlugIn(Boolean.valueOf(stringFromFile.split(";")[2]));
        return electricalAppliance;
    }
}
