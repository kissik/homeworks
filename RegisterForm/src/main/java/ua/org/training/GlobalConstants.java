package ua.org.training;

/**
 * Created by @kissik on 27 NOV 2019
 */
public interface GlobalConstants {

    String STRING_HELLO_STRING = "Hey! This is a Registration Form";
    String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please!";

    String STRING_INPUT_LAST_NAME = "Input Last Name:";
    String PATTERN_INPUT_LAST_NAME = "[A-Z]{1}[a-z]*";
    String VIEW_LAST_NAME = "Last Name: ";

    String STRING_INPUT_NAME = "Input Name:";
    String PATTERN_INPUT_NAME = "[A-Z]{1}[a-z]*";
    String VIEW_NAME = "Name: ";

    String STRING_INPUT_MIDDLE_NAME = "Input Middle Name:";
    String PATTERN_INPUT_MIDDLE_NAME = "[A-Z]{1}[a-z]*";
    String VIEW_MIDDLE_NAME = "Middle Name: ";

    String STRING_INPUT_NICK_NAME = "Input Nick Name:";
    String PATTERN_INPUT_NICK_NAME = "[a-z]*";
    String VIEW_NICK_NAME = "Nick Name: ";

    String STRING_INPUT_COMMENT = "Input Comment:";
    String PATTERN_INPUT_ANY = ".*|[ ]?$";
    String VIEW_COMMENT = "Comment: ";

    String STRING_INPUT_HOME_PHONE = "Input Home Phone:";
    String VIEW_HOME_PHONE = "Home Phone: ";
    String STRING_INPUT_CELLULAR_PHONE = "Input Cellular Phone:";
    String VIEW_CELLULAR_PHONE = "Cellular Phone: ";
    String STRING_INPUT_CELLULAR_PHONE_TWO = "Input Cellular Phone (second):";
    String STRING_INPUT_CELLULAR_PHONE_TWO_QUESTION = "Do you want to enter second cellular phone number? (y/Y - yes):";
    String VIEW_CELLULAR_PHONE_TWO = "Cellular Phone (second): ";
    String PATTERN_INPUT_PHONE = "\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}";

    String STRING_INPUT_EMAIL = "Input E-mail:";
    String PATTERN_INPUT_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    String VIEW_EMAIL = "E-mail";

    String STRING_INPUT_GROUP = "Input Number of Group: \n" +
            "1. FAMILY\n" +
            "2. FRIENDS\n"  +
            "3. WORK\n" +
            "4. TRAINING\n" +
            "5. FRIDAY\n" +
            "6. UNIVERSITY\n";
    String PATTERN_INPUT_GROUP = "[1-6]{1}";
    String VIEW_GROUP = "Group: ";

    String FULL_NAME = "Hi! ";

    String THANK_YOU_STRING = "Thank you for choosing our service! \nBest wishes!";
    String BREAK_LINE = "\n";
    String TAB_SYMBOLS = "\t";
    String DEFAULT_STRING = "none";

    enum GroupName {
        FAMILY, FRIENDS, WORK, TRAINING, FRIDAY, UNIVERSITY
    }

}
