package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ShoppingCartPage extends PageObject {

    public static final Target BTN_GO_TO_CHECKOUT = Target
            .the("Botón para ir al checkout")
            .locatedBy("//a[@class='btn_action checkout_button']");
}
