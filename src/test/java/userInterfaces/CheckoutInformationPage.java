package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutInformationPage extends PageObject {

    public static final Target INPUT_FIRST_NAME = Target
            .the("Input de nombre")
            .locatedBy("//input[@id='first-name']");

    public static final Target INPUT_LAST_NAME = Target
            .the("Input de apellido")
            .locatedBy("//input[@id='last-name']");

    public static final Target INPUT_POSTAL_CODE = Target
            .the("Input de código postal")
            .locatedBy("//input[@id='postal-code']");

    public static final Target BTN_CONTINUE_TO_OVERVIEW = Target
            .the("Botón para continuar en Checkout")
            .locatedBy("//input[@class='btn_primary cart_button']");
}
