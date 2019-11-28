package ua.org.training;

import ua.org.training.controller.Controller;
import ua.org.training.model.Model;
import ua.org.training.view.View;

import java.util.Locale;
import java.util.Scanner;

import static ua.org.training.GlobalConstants.BREAK_LINE;
import static ua.org.training.GlobalConstants.WRONG_INPUT_INT_DATA;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        String ch = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Для введення даних українською натисніть 1");
        ch = sc.next();
        View view = null;
        switch(ch){
            case "1": view = new View(new Locale("uk"));
                        break;
            default:  view = new View(new Locale("en"));
        }
        Controller controller = new Controller(model, view);
        controller.processUser(sc);
    }
}
