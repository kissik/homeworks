package ua.org.training;

/**
 * Created by @kissik on 21 NOV 2019
 */
public class View {
    public static final String HELLO_STRING = "Hello! This is the Guess Number Game!\n";
    public static final String STATISTICS_INFO = "Number of attempts: ";
    public static final String HELP_INFO = "Guess a number from the range from ";
    public static final String HELP_DELIMITER = " to ";
    public static final String CONGRATULATION_STRING = "YOU WIN!!! HURRAY!!!";
    public static final String RULES = "\n************************\n"+
            "*   some rules )))))   *\n" +
            "************************\n";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please!\n";

    public static final int LEFT_BORDER = 0;
    public static final int RIGHT_BORDER = 100;

    public void printMessage(String message){
        System.out.println(message);
    }

}
