package ua.org.training;

import java.util.Scanner;

import static ua.org.training.GlobalConstants.*;

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
        view.printMessage(STRING_HELLO_STRING + BREAK_LINE);
        model.setLastName(inputStringValueWithScanner(sc,
                STRING_INPUT_LAST_NAME,
                PATTERN_INPUT_LAST_NAME));
        model.setName(inputStringValueWithScanner(sc,
                STRING_INPUT_NAME,
                PATTERN_INPUT_NAME));
        model.setMiddleName(inputStringValueWithScanner(sc,
                STRING_INPUT_MIDDLE_NAME,
                PATTERN_INPUT_MIDDLE_NAME));

        model.setNickName(inputStringValueWithScanner(sc,
                STRING_INPUT_NICK_NAME,
                PATTERN_INPUT_NICK_NAME));

        model.setComment(inputLineWithScanner(sc,
                STRING_INPUT_COMMENT));

        model.setGroupName(mapGroupName(inputStringValueWithScanner(sc,
                STRING_INPUT_GROUP,
                PATTERN_INPUT_GROUP)));

        model.setHomePhone(inputStringValueWithScanner(sc,
                STRING_INPUT_HOME_PHONE + STRING_PHONE_SAMPLE,
                PATTERN_INPUT_PHONE));

        model.setCellularPhone(inputStringValueWithScanner(sc,
                STRING_INPUT_CELLULAR_PHONE + STRING_PHONE_SAMPLE,
                PATTERN_INPUT_PHONE));

        if (isEnterCellularPhoneTwo(sc))
        model.setCellularPhoneTwo(inputStringValueWithScanner(sc,
                STRING_INPUT_CELLULAR_PHONE_TWO + STRING_PHONE_SAMPLE,
                PATTERN_INPUT_PHONE));

        view.printMessage(FULL_NAME + model.getFullName() + BREAK_LINE);
        view.printMessage(BREAK_LINE + THANK_YOU_STRING + BREAK_LINE);
        view.printMessage(model.toString());

    }

    private boolean isEnterCellularPhoneTwo(Scanner sc) {
        switch(inputStringValueWithScanner(sc,
                STRING_INPUT_CELLULAR_PHONE_TWO_QUESTION,
                PATTERN_INPUT_ANY)){
            case "Y":
            case "y": return true;
        }
        return false;
    }

    private GroupName mapGroupName(String inputStringValueWithScanner) {
        switch(inputStringValueWithScanner){
            case "1": return GroupName.FAMILY;
            case "2": return GroupName.FRIENDS;
            case "3": return GroupName.WORK;
            case "4": return GroupName.TRAINING;
            case "5": return GroupName.FRIDAY;
        }
        return GroupName.UNIVERSITY;
    }

    public String inputStringValueWithScanner(Scanner sc, String msg, String pattern) {
        view.printMessage(msg);
        while( ! sc.hasNext(pattern)) {
            view.printMessage(WRONG_INPUT_INT_DATA + BREAK_LINE + msg);
            sc.next();
        }
        return sc.next();
    }

    public String inputLineWithScanner(Scanner sc, String msg) {
        view.printMessage(msg);
        while(!sc.hasNext()) {
            view.printMessage(WRONG_INPUT_INT_DATA + BREAK_LINE + msg);
        }
        return sc.next()+sc.nextLine();
    }

}
