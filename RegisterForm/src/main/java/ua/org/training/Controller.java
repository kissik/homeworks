package ua.org.training;

import java.util.Scanner;

/**
 * Created by @kissik on 27 NOV 2019
 */

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);
        view.printMessage(GlobalConstants.STRING_HELLO_STRING + GlobalConstants.BREAK_LINE);
        model.setLastName(inputStringValueWithScanner(sc, GlobalConstants.STRING_INPUT_LAST_NAME, GlobalConstants.PATTERN_INPUT_LAST_NAME));
        model.setName(inputStringValueWithScanner(sc, GlobalConstants.STRING_INPUT_NAME, GlobalConstants.PATTERN_INPUT_NAME));
        model.setMiddleName(inputStringValueWithScanner(sc, GlobalConstants.STRING_INPUT_MIDDLE_NAME, GlobalConstants.PATTERN_INPUT_MIDDLE_NAME));
        
        view.printMessage(GlobalConstants.FULL_NAME + model.getFullName() + GlobalConstants.BREAK_LINE);
        view.printMessage(GlobalConstants.BREAK_LINE + GlobalConstants.THANK_YOU_STRING + GlobalConstants.BREAK_LINE);
        view.printMessage(getForm());

    }

    public String inputStringValueWithScanner(Scanner sc, String msg, String pattern) {
        view.printMessage(msg);
        while( ! sc.hasNext(pattern)) {
            view.printMessage(GlobalConstants.WRONG_INPUT_INT_DATA + msg);
            sc.next();
        }
        return sc.next();
    }

    public String getForm(){
        StringBuffer form = new StringBuffer();
        appendViewModelField(form, GlobalConstants.VIEW_LAST_NAME, model.getLastName());
        appendViewModelField(form, GlobalConstants.VIEW_NAME, model.getName());
        appendViewModelField(form, GlobalConstants.VIEW_MIDDLE_NAME, model.getMiddleName());

        return form.toString();
    }

    private void appendViewModelField(StringBuffer form, String viewLastName, String lastName) {
        form.append(viewLastName)
                .append(GlobalConstants.BREAK_LINE + GlobalConstants.TAB_SYMBOLS)
                .append(lastName)
                .append(GlobalConstants.BREAK_LINE);
    }

}
