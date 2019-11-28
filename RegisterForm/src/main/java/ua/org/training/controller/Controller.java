package ua.org.training.controller;

import ua.org.training.model.Address;
import ua.org.training.view.View;
import ua.org.training.model.Model;

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

    public void processUser(Scanner sc){

        view.printMessage(view.bundle.getString(STRING_HELLO_STRING) + BREAK_LINE);
        model.setLastName(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_LAST_NAME),
                view.bundle.getString(PATTERN_INPUT_NAME)));
        model.setViewLastName(view.bundle.getString(VIEW_LAST_NAME));
        model.setName(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_NAME),
                view.bundle.getString(PATTERN_INPUT_NAME)));
        model.setViewName(view.bundle.getString(VIEW_NAME));
        model.setMiddleName(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_MIDDLE_NAME),
                view.bundle.getString(PATTERN_INPUT_NAME)));
        model.setViewMiddleName(view.bundle.getString(VIEW_MIDDLE_NAME));
        model.setNickName(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_NICK_NAME),
                        view.bundle.getString(PATTERN_INPUT_NICK_NAME)));
        model.setViewNickName(view.bundle.getString(VIEW_NICK_NAME));
        model.setComment(inputLineWithScanner(sc,
                view.bundle.getString(STRING_INPUT_COMMENT)));
        model.setViewComment(view.bundle.getString(VIEW_COMMENT));
        model.setGroupName(mapGroupName(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_GROUP),
                view.bundle.getString(PATTERN_INPUT_GROUP))));
        model.setViewGroup(view.bundle.getString(VIEW_GROUP));
        model.setHomePhone(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_HOME_PHONE) + view.bundle.getString(STRING_PHONE_SAMPLE),
                view.bundle.getString(PATTERN_INPUT_PHONE)));
        model.setViewHomePhone(view.bundle.getString(VIEW_HOME_PHONE));
        model.setCellularPhone(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_CELLULAR_PHONE) + view.bundle.getString(STRING_PHONE_SAMPLE),
                view.bundle.getString(PATTERN_INPUT_PHONE)));
        model.setViewCellularPhone(view.bundle.getString(VIEW_CELLULAR_PHONE));
        if (isEnterCellularPhoneTwo(sc))
            model.setCellularPhoneTwo(inputStringValueWithScanner(sc,
                    view.bundle.getString(STRING_INPUT_CELLULAR_PHONE_TWO) + view.bundle.getString(STRING_PHONE_SAMPLE),
                    view.bundle.getString(PATTERN_INPUT_PHONE)));
        model.setViewCellularPhoneTwo(view.bundle.getString(VIEW_CELLULAR_PHONE_TWO));
        model.setEmail(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_EMAIL),
                view.bundle.getString(PATTERN_INPUT_EMAIL)));
        model.setViewEmail(view.bundle.getString(VIEW_EMAIL));
        model.setAddress(readAddress(sc));
        model.setViewAddress(view.bundle.getString(VIEW_ADDRESS));
        view.printMessage(view.bundle.getString(FULL_NAME) + model.getFullName() + BREAK_LINE);
        view.printMessage(model.toString());
        view.printMessage(BREAK_LINE + view.bundle.getString(THANK_YOU_STRING) + BREAK_LINE);
    }

    public Address readAddress(Scanner sc){
        Address address = new Address();
        address.setIndex(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_ADDRESS_INDEX),
                view.bundle.getString(PATTERN_INPUT_ADDRESS_INDEX)));
        address.setCity(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_ADDRESS_CITY),
                view.bundle.getString(PATTERN_INPUT_ADDRESS_CITY)));
        address.setStreet(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_ADDRESS_STREET),
                view.bundle.getString(PATTERN_INPUT_ADDRESS_STREET)));
        address.setHouse(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_ADDRESS_HOUSE),
                view.bundle.getString(PATTERN_INPUT_ADDRESS_HOUSE)));
        address.setApartment(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_ADDRESS_APARTMENT),
                view.bundle.getString(PATTERN_INPUT_ADDRESS_APARTMENT)));
        return address;
    }

    private boolean isEnterCellularPhoneTwo(Scanner sc) {
        switch(inputStringValueWithScanner(sc,
                view.bundle.getString(STRING_INPUT_CELLULAR_PHONE_TWO_QUESTION),
                view.bundle.getString(PATTERN_INPUT_ANY))){
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
            view.printMessage(view.bundle.getString(WRONG_INPUT_INT_DATA) + BREAK_LINE + msg);
            sc.next();
        }
        return sc.next();
    }

    public String inputLineWithScanner(Scanner sc, String msg) {
        view.printMessage(msg);
        while(!sc.hasNext()) {
            view.printMessage(view.bundle.getString(WRONG_INPUT_INT_DATA) + BREAK_LINE + msg);
        }
        return sc.next()+sc.nextLine();
    }

}
