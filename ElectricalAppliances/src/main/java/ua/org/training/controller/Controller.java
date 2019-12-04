package ua.org.training.controller;

import ua.org.training.view.GlobalConstants;
import ua.org.training.view.View;

/**
 * class Controller
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
import java.util.ArrayList;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser() {
        UtilityController utilityController = new UtilityController();
        ArrayList<String> array = utilityController.getLines(GlobalConstants.SOURCE_ELECTRICAL_APPLIANCE_FILE_NAME);
        for(String string : array){
            view.printMessage(string);
        }
    }
}
