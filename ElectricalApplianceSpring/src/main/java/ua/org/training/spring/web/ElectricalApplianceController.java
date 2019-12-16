package ua.org.training.spring.web;

import org.springframework.stereotype.Controller;
import ua.org.training.spring.domain.ElectricalApplianceModel;

/**
 * class ElectricalApplianceController
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/16/2019
 */
@Controller
public class ElectricalApplianceController {

    private ElectricalApplianceView view;
    private ElectricalApplianceModel model;

    public ElectricalApplianceController(ElectricalApplianceView view, ElectricalApplianceModel model) {
        this.view = view;
        this.model = model;
    }

    public void processUser() {
        printCollection(view.getString(GlobalConstants.SORTING_MESSAGES_BEFORE));
        model.sort();
        printCollection(view.getString(GlobalConstants.SORTING_MESSAGES_AFTER));
        view.printMessage(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER +
                view.getString(GlobalConstants.VIEW_TOTAL_CAPACITY) +
                model.countTotalCapacity() +
                GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION +
                view.getString(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_CAPACITY_UNIT));
        view.printMessage(model.findElectricityAppliance(view.getString(GlobalConstants.SEARCH_FILTER),
                view.getString(GlobalConstants.SEARCH_RESULTS)));
    }

    private void printCollection(String message) {
        view.printMessage(message);
        view.printMessage(model.printCollection());
    }

}
