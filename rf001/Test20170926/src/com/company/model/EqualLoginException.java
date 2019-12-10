package com.company.model;

public class EqualLoginException extends Exception {

    public EqualLoginException(String message, String login) {
        super(message, new Throwable(login));
    }

    public String toString() {
        return super.getMessage() + " " + super.getCause();
    }
}
