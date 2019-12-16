package ua.org.training.spring.web;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import ua.org.training.spring.domain.ElectricalApplianceModel;
import ua.org.training.spring.domain.entity.ElectricalAppliance;

@Controller
public class ElectricalApplianceController {

    private ElectricalApplianceView view;
    private ElectricalApplianceModel model;

    public ElectricalApplianceController(ElectricalApplianceView view, ElectricalApplianceModel model) {
        this.view = view;
        this.model = model;
    }

    public void processUser() {
        printCollection(
                view.getString(GlobalConstants.SORTING_MESSAGES_BEFORE),
                model);
        model.sort();
        printCollection(
                view.getString(GlobalConstants.SORTING_MESSAGES_AFTER),
                model);
        view.printMessage(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER +
                view.getString(GlobalConstants.VIEW_TOTAL_CAPACITY) +
                model.countTotalCapacity() +
                GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_TABULATION +
                view.getString(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_CAPACITY_UNIT));
        view.printMessage(model.findElectricityAppliance(view.getString(GlobalConstants.SEARCH_FILTER),
                view.getString(GlobalConstants.SEARCH_RESULTS)));
    }

    private void printCollection(String sortingMessagesBefore, ElectricalApplianceModel model) {
        view.printMessage(sortingMessagesBefore);
        view.printMessage(model.printCollection());
    }

}
