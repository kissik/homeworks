package ua.org.training.spring.web;
import ua.org.training.spring.domain.entity.ElectricalAppliance;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
public class ElectricalApplianceView {

        /**
         * <p>Output the message string</p>
         * @param message   String value that will be displayed
         */
        public static ResourceBundle bundle = null;

        public ElectricalApplianceView(Locale local){
            bundle = ResourceBundle.getBundle(
                    GlobalConstants.MESSAGES_BUNDLE_NAME,
                    local);
        }

        public String getString(String bundleProperty) {
            return new String(
                    bundle.getString(bundleProperty).getBytes(StandardCharsets.ISO_8859_1),
                    StandardCharsets.UTF_8);
        }

        public void printMessage(String message){
            System.out.println(message);
        }

}
