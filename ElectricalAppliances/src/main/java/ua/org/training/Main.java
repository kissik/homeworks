package ua.org.training;

import ua.org.training.controller.Controller;
import ua.org.training.view.View;

/**
 * class Main
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
public class Main {
    public static void main(String[] args) {
        Controller controller =
                new Controller(new View());
        controller.processUser();
    }
}
