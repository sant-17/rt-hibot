package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CommonPage extends PageObject {

    public static final Target BTN_GO_TO_CART = Target
            .the("Botón del Carrito")
            .locatedBy("//div[@id='shopping_cart_container']");
}
