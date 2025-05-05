package userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutCompletePage {

    public static final Target LBL_ORDER_CONFIRMATION = Target
            .the("Mensaje de confirmación de la compra")
            .locatedBy("//h2[@class='complete-header']");
}
