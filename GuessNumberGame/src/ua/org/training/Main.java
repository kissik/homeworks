package ua.org.training;

/**
 * Created by @kissik on 21 NOV 2019
 */

public class Main {
    public static void main(String[] args) {
        Model model = new Model(View.LEFT_BORDER, View.RIGHT_BORDER);
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.runGame();
    }
}
