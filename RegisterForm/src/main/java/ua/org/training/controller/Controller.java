package ua.org.training.controller;

import javafx.util.Pair;
import ua.org.training.model.Address;
import ua.org.training.model.Group;
import ua.org.training.view.View;
import ua.org.training.model.Model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

import static ua.org.training.GlobalConstants.*;

/**
 * Created by @kissik on 27 NOV 2019
 */

public class Controller {
    private Model model;
    private View view;

    private ArrayList<Pair<String, String>> map;

    private void initModel(){
        map = new ArrayList<>();
        map.add(new Pair(STRING_INPUT_LAST_NAME,PATTERN_INPUT_NAME));
        map.add(new Pair(STRING_INPUT_NAME, PATTERN_INPUT_NAME));
        map.add(new Pair(STRING_INPUT_MIDDLE_NAME, PATTERN_INPUT_NAME));
        map.add(new Pair(STRING_INPUT_NICK_NAME, PATTERN_INPUT_NICK_NAME));
        map.add(new Pair(STRING_INPUT_GROUP, PATTERN_INPUT_GROUP));
        map.add(new Pair(STRING_INPUT_HOME_PHONE, PATTERN_INPUT_PHONE));
        map.add(new Pair(STRING_INPUT_CELLULAR_PHONE, PATTERN_INPUT_PHONE));
        map.add(new Pair(STRING_INPUT_CELLULAR_PHONE_TWO, PATTERN_INPUT_PHONE));
        map.add(new Pair(STRING_INPUT_EMAIL, PATTERN_INPUT_EMAIL));
    }

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        initModel();
    }

    private Model setFormField(Scanner sc, String formFieldValue, Function<String, Model> func){
        String pattern = getPatternString(view.getString(formFieldValue));
        return model.setFormField(inputStringValueWithScanner(sc,
                view.getString(formFieldValue),
                view.getString(pattern)), func);
    }

    String getPatternString(String key){
        for(Pair<String, String> pair : map){
            if (pair.getKey()==key) return pair.getValue();
        }
        return DEFAULT_STRING;
    }

    public void processUser(Scanner sc){

        view.printMessage(view.getString(STRING_HELLO_STRING) + BREAK_LINE);

        model.setLastName(getValidStringValue(sc, STRING_INPUT_LAST_NAME))
                .setViewLastName(view.getString(VIEW_LAST_NAME));
        model.setName(getValidStringValue(sc, STRING_INPUT_NAME))
                .setViewName(view.getString(VIEW_NAME));
        model.setMiddleName(getValidStringValue(sc, STRING_INPUT_MIDDLE_NAME))
                .setViewMiddleName(view.getString(VIEW_MIDDLE_NAME));
        model.setNickName(getValidStringValue(sc, STRING_INPUT_NICK_NAME))
                .setViewNickName(view.getString(VIEW_NICK_NAME));
        model.setComment(inputLineWithScanner(sc, view.getString(STRING_INPUT_COMMENT)))
                .setViewComment(view.getString(VIEW_COMMENT));
        model.setGroup(mapGroup(getValidStringValue(sc, STRING_INPUT_GROUP)))
                .setViewGroup(view.getString(VIEW_GROUP));
        model.setHomePhone(getValidStringValue(sc, STRING_INPUT_HOME_PHONE))
                .setViewHomePhone(view.getString(VIEW_HOME_PHONE));
        model.setCellularPhone(getValidStringValue(sc, STRING_INPUT_CELLULAR_PHONE))
                .setViewCellularPhone(view.getString(VIEW_CELLULAR_PHONE));
        if (isEnterCellularPhoneTwo(sc))
            model.setCellularPhoneTwo(getValidStringValue(sc, STRING_INPUT_CELLULAR_PHONE_TWO));
        model.setViewCellularPhoneTwo(view.getString(VIEW_CELLULAR_PHONE_TWO));
        model.setEmail(getValidStringValue(sc, STRING_INPUT_EMAIL))
                .setViewEmail(view.getString(VIEW_EMAIL));
        model.setAddress(readAddress(sc)).setViewAddress(view.getString(VIEW_ADDRESS));
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

    public String getValidStringValue(Scanner sc, String property){
        String msg = view.getString(property);
        String pattern = view.getString(getPatternString(property));
        if (property.equals(STRING_INPUT_GROUP)) msg += Group.getString();
        return inputStringValueWithScanner(sc, msg, pattern);
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
