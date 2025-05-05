package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutOverviewPage extends PageObject {

    public static final Target LBL_PRICES = Target
            .the("Precio de un producto")
            .locatedBy("//div[@class='inventory_item_price']");

    public static final Target LBL_SUBTOTAL = Target
            .the("Subtotal de la compra")
            .locatedBy("//div[@class='summary_subtotal_label']");

    public static final Target BTN_FINISH_CHECKOUT = Target
            .the("Botón para finalizar la compra")
            .locatedBy("//a[@class='btn_action cart_button']");
}
