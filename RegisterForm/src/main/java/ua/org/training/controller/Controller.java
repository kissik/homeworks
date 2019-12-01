package ua.org.training.controller;

import ua.org.training.model.Address;
import ua.org.training.model.Group;
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

        view.printMessage(view.getString(STRING_HELLO_STRING) + BREAK_LINE);
        model.setLastName(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_LAST_NAME),
                view.getString(PATTERN_INPUT_NAME)));
        model.setViewLastName(view.getString(VIEW_LAST_NAME));
        model.setName(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_NAME),
                view.getString(PATTERN_INPUT_NAME)));
        model.setViewName(view.getString(VIEW_NAME));
        model.setMiddleName(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_MIDDLE_NAME),
                view.getString(PATTERN_INPUT_NAME)));
        model.setViewMiddleName(view.getString(VIEW_MIDDLE_NAME));
        model.setNickName(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_NICK_NAME),
                        view.getString(PATTERN_INPUT_NICK_NAME)));
        model.setViewNickName(view.getString(VIEW_NICK_NAME));
        model.setComment(inputLineWithScanner(sc,
                view.getString(STRING_INPUT_COMMENT)));
        model.setViewComment(view.getString(VIEW_COMMENT));
        model.setGroup(mapGroup(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_GROUP),
                view.getString(PATTERN_INPUT_GROUP))));
        model.setViewGroup(view.getString(VIEW_GROUP));
        model.setHomePhone(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_HOME_PHONE) + view.getString(STRING_PHONE_SAMPLE),
                view.getString(PATTERN_INPUT_PHONE)));
        model.setViewHomePhone(view.getString(VIEW_HOME_PHONE));
        model.setCellularPhone(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_CELLULAR_PHONE) + view.getString(STRING_PHONE_SAMPLE),
                view.getString(PATTERN_INPUT_PHONE)));
        model.setViewCellularPhone(view.getString(VIEW_CELLULAR_PHONE));
        if (isEnterCellularPhoneTwo(sc))
            model.setCellularPhoneTwo(inputStringValueWithScanner(sc,
                    view.getString(STRING_INPUT_CELLULAR_PHONE_TWO) + view.getString(STRING_PHONE_SAMPLE),
                    view.getString(PATTERN_INPUT_PHONE)));
        model.setViewCellularPhoneTwo(view.getString(VIEW_CELLULAR_PHONE_TWO));
        model.setEmail(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_EMAIL),
                view.getString(PATTERN_INPUT_EMAIL)));
        model.setViewEmail(view.getString(VIEW_EMAIL));
        model.setAddress(readAddress(sc));
        model.setViewAddress(view.getString(VIEW_ADDRESS));
        model.setViewCreateDate(view.getString(VIEW_CREATE_DATE));
        model.setViewUpdateDate(view.getString(VIEW_UPDATE_DATE));
        model.setUpdateDate();
        view.printMessage(view.getString(FULL_NAME) + model.getFullName() + BREAK_LINE);
        view.printMessage(model.toString());
        view.printMessage(BREAK_LINE + view.getString(THANK_YOU_STRING) + BREAK_LINE);
    }

    public Address readAddress(Scanner sc){
        Address address = new Address();
        address.setIndex(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_ADDRESS_INDEX),
                view.getString(PATTERN_INPUT_ADDRESS_INDEX)));
        address.setCity(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_ADDRESS_CITY),
                view.getString(PATTERN_INPUT_ADDRESS_CITY)));
        address.setStreet(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_ADDRESS_STREET),
                view.getString(PATTERN_INPUT_ADDRESS_STREET)));
        address.setHouse(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_ADDRESS_HOUSE),
                view.getString(PATTERN_INPUT_ADDRESS_HOUSE)));
        address.setApartment(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_ADDRESS_APARTMENT),
                view.getString(PATTERN_INPUT_ADDRESS_APARTMENT)));
        return address;
    }

    private boolean isEnterCellularPhoneTwo(Scanner sc) {
        switch(inputStringValueWithScanner(sc,
                view.getString(STRING_INPUT_CELLULAR_PHONE_TWO_QUESTION),
                view.getString(PATTERN_INPUT_ANY))){
            case "Y":
            case "y": return true;
        }
        return false;
    }

    private Group mapGroup(String inputStringValueWithScanner) {
        for(Group g : Group.values()){
            if (g.number() == Integer.decode(inputStringValueWithScanner)) return g;
        }
        return Group.UNIVERSITY;
    }

    public String inputStringValueWithScanner(Scanner sc, String msg, String pattern) {
        view.printMessage(msg);
        while( ! sc.hasNext(pattern)) {
            view.printMessage(view.getString(WRONG_INPUT_INT_DATA) + BREAK_LINE + msg);
            sc.next();
        }
        return sc.next();
    }

    public String inputLineWithScanner(Scanner sc, String msg) {
        view.printMessage(msg);
        while(!sc.hasNext()) {
            view.printMessage(view.getString(WRONG_INPUT_INT_DATA) + BREAK_LINE + msg);
        }
        return sc.next()+sc.nextLine();
    }

}
