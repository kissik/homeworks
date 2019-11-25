package ua.org.training;

import java.util.Scanner;

/**
 * Created by @kissik on 21 NOV 2019
 */

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void runGame(){
        Scanner sc = new Scanner(System.in);

        view.printMessage(View.HELLO_STRING + View.RULES);
        while(!model.isWin()){
            try {
                model.guessNumber(inputIntValueWithScanner(sc));
                view.printMessage(model.getStatistics(View.STATISTICS_INFO));
            }catch(IndexOutOfBoundsException ex){
                view.printMessage(View.WRONG_INPUT_INT_DATA + View.RULES);
            }
        }

        view.printMessage(View.CONGRATULATION_STRING);
    }

    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(model.getHelp(View.HELP_INFO, View.HELP_DELIMITER));
        int res = 0;
        do{
            while( ! sc.hasNextInt()) {
                view.printMessage(View.WRONG_INPUT_INT_DATA + model.getHelp(View.HELP_INFO, View.HELP_DELIMITER));
                sc.next();
            }
            if (((res = sc.nextInt()) <= model.getLeftBorder()) || (res >= model.getRightBorder())){
                view.printMessage(View.WRONG_INPUT_INT_DATA + model.getHelp(View.HELP_INFO, View.HELP_DELIMITER));
                continue;
            }
            break;
        }while(true);
        return res;
    }
}
