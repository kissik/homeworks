package ua.org.training.model;

import ua.org.training.GlobalConstants;

public class Address {
    private String index, city, street, house, apartment;

    public Address(){
        apartment = null;
    }

    public String getApartment() {
        if (apartment == null) return GlobalConstants.DEFAULT_STRING;
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString(){
        StringBuffer form = new StringBuffer();
        form.append(GlobalConstants.DELIMITER_SYMBOL).append(getIndex())
                .append(GlobalConstants.DELIMITER_SYMBOL).append(getCity())
                .append(GlobalConstants.DELIMITER_SYMBOL).append(getStreet())
                .append(GlobalConstants.DELIMITER_SYMBOL).append(getHouse())
                .append(GlobalConstants.DELIMITER_SYMBOL).append(getApartment());

        return form.toString();
    }
}
