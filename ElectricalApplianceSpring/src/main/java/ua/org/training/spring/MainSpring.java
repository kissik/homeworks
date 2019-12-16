package ua.org.training.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.org.training.spring.domain.ElectricalApplianceModel;
import ua.org.training.spring.web.ElectricalApplianceController;
import ua.org.training.spring.web.ElectricalApplianceView;

import java.util.Locale;
import java.util.Scanner;

/**
 * class Main
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/16/2019
 */
public class MainSpring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Для введення даних українською натисніть 1");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        ElectricalApplianceView view = null;

        switch(sc.next()){
            case "1": view = new ElectricalApplianceView(new Locale("uk"));
                break;
            default:  view = new ElectricalApplianceView(new Locale("en"));
        }
        ElectricalApplianceModel model = new ElectricalApplianceModel(context);

        ElectricalApplianceController controller =
                new ElectricalApplianceController(view, model);
        controller.processUser();

    }
}
