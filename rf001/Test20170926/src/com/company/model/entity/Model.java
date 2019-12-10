package com.company.model.entity;

/**
 * Created by student on 26.09.2017.
 */
public class Model {
    private String firstName;
    private String login;

    public Model(String firstName, String login) {
        this.firstName = firstName;
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
