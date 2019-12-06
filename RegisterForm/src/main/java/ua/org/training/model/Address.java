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

    public Address setApartment(String apartment) {
        this.apartment = apartment;
        return this;
    }

    public String getIndex() {
        return index;
    }

    public Address setIndex(String index) {
        this.index = index;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getHouse() {
        return house;
    }

    public Address setHouse(String house) {
        this.house = house;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    @Override
    public String toString(){
        StringBuffer form = new StringBuffer(GlobalConstants.BUFFER_SIZE);
        form.append(GlobalConstants.DELIMITER_SYMBOL).append(getIndex())
                .append(GlobalConstants.DELIMITER_SYMBOL).append(getCity())
                .append(GlobalConstants.DELIMITER_SYMBOL).append(getStreet())
                .append(GlobalConstants.DELIMITER_SYMBOL).append(getHouse())
                .append(GlobalConstants.DELIMITER_SYMBOL).append(getApartment());

        return form.toString();
    }
}
