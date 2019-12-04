package ua.org.training;

import ua.org.training.controller.Controller;
import ua.org.training.view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller =
                new Controller(new View());
        controller.processUser();
    }
}
