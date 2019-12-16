package ua.org.training.spring.domain;

import javafx.util.Pair;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.org.training.spring.service.ElectricalApplianceService;
import ua.org.training.spring.web.GlobalConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElectricalApplianceModel {

    private List<ElectricalApplianceService> electricalAppliancesArrayList;
    private List<Pair<String, String>> parameters;

    public ElectricalApplianceModel(ClassPathXmlApplicationContext context) {
        electricalAppliancesArrayList = new ArrayList<>();
        parameters = new ArrayList<>();
        List<ElectricalApplianceService> list =
                (List<ElectricalApplianceService>) context.getBean("peaList", java.util.ArrayList.class);
        for(ElectricalApplianceService p : list) {
            this.add(p);
        }
        list =
                (List<ElectricalApplianceService>)
                        context.getBean("seaList", java.util.ArrayList.class);
        for(ElectricalApplianceService s : list) {
            this.add(s);
        }
    }

    private void add(ElectricalApplianceService electricalAppliance){
        electricalAppliancesArrayList.add(electricalAppliance);
    }

    public void sort(){

        electricalAppliancesArrayList = electricalAppliancesArrayList
                .stream()
                .sorted(ElectricalApplianceService::compareTo)
                .collect(Collectors.<ElectricalApplianceService>toList());

    }

    public int countTotalCapacity() {
        int totalCapacity = 0;
        for (ElectricalApplianceService electricalAppliance : electricalAppliancesArrayList)
            if (electricalAppliance.isPlugIn()) totalCapacity += electricalAppliance.capacity();
        return totalCapacity;
    }

    public String findElectricityAppliance(String filter, String results) {
        final StringBuffer buffer = new StringBuffer(GlobalConstants.STRING_BUFFER_SIZE);
         buffer.append(addFilterParameters(filter, results));
        electricalAppliancesArrayList
                .stream()
                .filter((x) ->  x.findByParameters(parameters))
                .forEach((electricalAppliance) ->
                        buffer
                                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER)
                                .append(electricalAppliance.toString()));

        return buffer.toString();
    }

    private String addFilterParameters(String filter, String results){
        StringBuffer buffer = new StringBuffer(GlobalConstants.STRING_BUFFER_SIZE);
        parameters.add(new Pair<>(GlobalConstants.SEARCH_ELECTRICAL_APPLIANCE_PLUG_IN, "false"));
        parameters.add(new Pair<>(GlobalConstants.SEARCH_STATIONARY_ELECTRICAL_APPLIANCE_WIDTH, "60"));
        parameters.add(new Pair<>(GlobalConstants.SEARCH_PORTABLE_ELECTRICAL_APPLIANCE_CHARGE_LEVEL, "75"));

        buffer
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER)
                .append(filter)
                .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER);
        for(Pair<String, String> parameter : parameters)
            buffer.append(parameter.getKey()).append(": ").append(parameter.getValue())
                    .append(GlobalConstants.VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER);
        buffer.append(results);
        return buffer.toString();
    }

    public String printCollection() {
        StringBuffer buffer = new StringBuffer(GlobalConstants.STRING_BUFFER_SIZE);
        for (ElectricalApplianceService electricalAppliance : electricalAppliancesArrayList)
            buffer.append(electricalAppliance.toString());
        return buffer.toString();
    }
}
