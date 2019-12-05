package ua.org.training.view;

/**
 * <p>interface GlobalConstants see messages.properties for constants values</p>
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
public interface GlobalConstants {

    int PRIME_NUMBER = 31;
    int STRING_BUFFER_SIZE = 200;
    boolean ELECTRICAL_APPLIANCE_PLUG_IN_DEFAULT_VALUE = false;
    int ELECTRICAL_APPLIANCE_CAPACITY_DEFAULT_VALUE = 0;
    int DIMENSION_SIZE_DEFAULT_VALUE = 0;
    String DIMENSION_STRING_DELIMITER = " * ";
    String MESSAGES_BUNDLE_NAME = "messages";
    String DEFAULT_STRING = "";

    String VIEW_ELECTRICAL_APPLIANCE_TABULATION = "\t";
    String VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER = "\n";
    String VIEW_PORTABLE_ELECTRICAL_APPLIANCE_CHARGE_UNIT = "%";

    String VIEW_ELECTRICAL_APPLIANCE_TITLE = "view.electrical.appliance.title";
    String VIEW_ELECTRICAL_APPLIANCE_CAPACITY = "view.electrical.appliance.capacity";
    String VIEW_ELECTRICAL_APPLIANCE_CAPACITY_UNIT = "view.electrical.appliance.capacity.unit";
    String VIEW_ELECTRICAL_APPLIANCE_PLUG_IN = "view.electrical.appliance.plug.in";
    String VIEW_ELECTRICAL_APPLIANCE_PLUG_OUT = "view.electrical.appliance.plug.out";

    String VIEW_STATIONARY_ELECTRICAL_APPLIANCE_DIMENSIONS = "view.stationary.electrical.appliance.dimensions";
    String VIEW_PORTABLE_ELECTRICAL_APPLIANCE_CHARGE_LEVEL = "view.portable.electrical.appliance.charge.level";

    String VIEW_TOTAL_CAPACITY = "view.total.capacity";

    String SORTING_MESSAGES_BEFORE = "sorting.before.message";
    String SORTING_MESSAGES_AFTER = "sorting.after.message";
    String SOURCE_ELECTRICAL_APPLIANCE_FILE_NAME =
            "source.electrical.appliance";
    String SOURCE_PORTABLE_ELECTRICAL_APPLIANCE_FILE_NAME =
            "source.portable.electrical.appliance";
    String SOURCE_STATIONARY_ELECTRICAL_APPLIANCE_FILE_NAME =
            "source.stationary.electrical.appliance";

    String SEARCH_FILTER = "search.filter";
    String SEARCH_RESULTS = "search.results";

    String SEARCH_ELECTRICAL_APPLIANCE_CAPACITY = "capacity";
    String SEARCH_ELECTRICAL_APPLIANCE_PLUG_IN = "plugIn";
    String SEARCH_ELECTRICAL_APPLIANCE_TITLE = "title";
    String SEARCH_PORTABLE_ELECTRICAL_APPLIANCE_CHARGE_LEVEL = "chargeLevel";
    String SEARCH_STATIONARY_ELECTRICAL_APPLIANCE_WIDTH = "width";
    String SEARCH_STATIONARY_ELECTRICAL_APPLIANCE_HEIGHT = "height";
    String SEARCH_STATIONARY_ELECTRICAL_APPLIANCE_DEPTH = "depth";

}
