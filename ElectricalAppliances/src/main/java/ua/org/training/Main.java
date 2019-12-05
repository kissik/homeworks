package ua.org.training;

import ua.org.training.controller.Controller;
import ua.org.training.view.View;

import java.util.Locale;
import java.util.Scanner;

/**
 * class Main
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Для введення даних українською натисніть 1");
        View view = null;

        switch(sc.next()){
            case "1": view = new View(new Locale("uk"));
                break;
            default:  view = new View(new Locale("en"));
        }
        Controller controller =
                new Controller(view);
        controller.processUser();
    }
}
