package ua.kpi.tef;

/**
 * Created by User on 17.03.2016.
 */
public class View {
    // Text's constants
    public static final String INPUT_HELLO = "Input \"Hello\":";
    public static final String INPUT_JAVA = "Input \"Java!\":";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String OUTPUT_STRING = "Result:";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printResult(String message, String value){
        System.out.println(message + " " + value);
    }

}
