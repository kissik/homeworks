package ua.org.training.view;

/**
 * <p>interface GlobalConstants see messages.properties for constants values</p>
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
public interface GlobalConstants {
    String ELECTRICAL_APPLIANCE_CLASS_NAME = "Electrical Appliance";
    String PORTABLE_ELECTRICAL_APPLIANCE_CLASS_NAME = "Portable Electrical Appliance";
    String STATIONARY_ELECTRICAL_APPLIANCE_CLASS_NAME = "Stationary Electrical Appliance";

    boolean ELECTRICAL_APPLIANCE_PLUG_IN_DEFAULT_VALUE = false;
    int ELECTRICAL_APPLIANCE_CAPACITY_DEFAULT_VALUE = 0;
    int DIMENSION_SIZE_DEFAULT_VALUE = 0;
    String DIMENSION_STRING_DELIMITER = " * ";

    String VIEW_ELECTRICAL_APPLIANCE_TITLE = "Title:";
    String VIEW_ELECTRICAL_APPLIANCE_CAPACITY = "Capacity, kilowatt/hour:";
    String VIEW_ELECTRICAL_APPLIANCE_PLUG_IN = "Plug in";
    String VIEW_ELECTRICAL_APPLIANCE_PLUG_OUT = "Plug out";

    String VIEW_ELECTRICAL_APPLIANCE_TABULATION = "\t";
    String VIEW_ELECTRICAL_APPLIANCE_STRING_DELIMITER = "\n";

    String VIEW_STATIONARY_ELECTRICAL_APPLIANCE_DIMENSIONS = "Dimensions:";
    String VIEW_PORTABLE_ELECTRICAL_APPLIANCE_CHARGE_LEVEL = "Charge Level:";
    String VIEW_PORTABLE_ELECTRICAL_APPLIANCE_CHARGE_UNIT = "%";

    String VIEW_TOTAL_CAPACITY = "Total Capacity = ";

    String SORTING_MESSAGES_BEFORE = "---------------> Before Sorting: <---------------";
    String SORTING_MESSAGES_AFTER = "---------------> After Sorting: <---------------";
    String SOURCE_ELECTRICAL_APPLIANCE_FILE_NAME =
            "/home/irochka/project/temp/java/homeworks/ElectricalAppliances/target/classes/ElectricalAppliances.txt";
    String SOURCE_PORTABLE_ELECTRICAL_APPLIANCE_FILE_NAME =
            "/home/irochka/project/temp/java/homeworks/ElectricalAppliances/target/classes/PortableElectricalAppliances.txt";
    String SOURCE_STATIONARY_ELECTRICAL_APPLIANCE_FILE_NAME =
            "/home/irochka/project/temp/java/homeworks/ElectricalAppliances/target/classes/StationaryElectricalAppliances.txt";
    int PRIME_NUMBER = 31;
    int STRING_BUFFER_SIZE = 200;
}
