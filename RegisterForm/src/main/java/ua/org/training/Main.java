package ua.org.training;

import ua.org.training.controller.Controller;
import ua.org.training.model.Model;
import ua.org.training.view.View;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Scanner sc = new Scanner(System.in);
        System.out.println("Для введення даних українською натисніть 1");
        View view = null;

        switch(sc.next()){
            case "1": view = new View(new Locale("uk"));
                        break;
            default:  view = new View(new Locale("en"));
        }
        Controller controller = new Controller(model, view);
        controller.processUser(sc);
    }
}
