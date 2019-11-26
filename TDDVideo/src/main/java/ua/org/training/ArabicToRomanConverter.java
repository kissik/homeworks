package ua.org.training;

import javafx.util.Pair;

import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

public class ArabicToRomanConverter {
    public static String DEFAULT_ROMAN_NUMBER = "";

    private ArrayList<Pair<Integer, String>> map;

    public ArabicToRomanConverter(){
        map = new ArrayList<>();
        map.add(new Pair<Integer, String>(5, "V"));
        map.add(new Pair<Integer, String>(1, "I"));
    }

    public String Convert(int arabicNumber) {
        boolean noNumber = arabicNumber == 0;
        String romanNumber;

        if (noNumber) return DEFAULT_ROMAN_NUMBER;

        romanNumber = getRepeatingRomanNumber(arabicNumber);

        romanNumber = checkRepeatRomanSymbol(romanNumber);

        return romanNumber;
    }

    private String checkRepeatRomanSymbol(String romanNumber) {
        for(int i = 3; i < romanNumber.length(); i++){
            if ((romanNumber.charAt(i - 3) == romanNumber.charAt(i - 2)) &&
                    (romanNumber.charAt(i - 2) == romanNumber.charAt(i - 1)) &&
                    (romanNumber.charAt(i - 1) == romanNumber.charAt(i)))
                romanNumber = romanNumber.substring(0, i - 2) + nextRomanNumber(romanNumber.charAt(i)) + romanNumber.substring(i + 1);

        }
        return romanNumber;
    }

    private String nextRomanNumber(char charAt) {
        return "V";
    }

    private String getRepeatingRomanNumber(int arabicNumber) {
        String romanNumber = "";

        for (Pair<Integer, String> digit : map) {
            while (arabicNumber >= digit.getKey()) {
                romanNumber += digit.getValue();
                arabicNumber -= digit.getKey();
            }
        }
        return romanNumber;
    }
}