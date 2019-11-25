package ua.kpi.tef;

/**
 * Created by User on 17.03.2016.
 */
public class Model {
    private String value;

    // The Program logic

    /**
     * in this method add value with this.value
     * @param valueString
     * @return sum
     */
    public String addValue(String valueString){
        return value += " " + valueString;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
