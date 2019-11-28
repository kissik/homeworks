package ua.org.training.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by @kissik on 27 NOV 2019
 */
public class View {
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static ResourceBundle bundle = null;

    public View(Locale local){
        bundle = ResourceBundle.getBundle(
                MESSAGES_BUNDLE_NAME,
                local);
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
