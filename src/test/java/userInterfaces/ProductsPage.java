package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage extends PageObject {

    public static final Target BTN_ADD_PRODUCT_TO_CART = Target
            .the("Botón para agregar el producto '{0}' al carrito")
            .locatedBy("//div[contains(@class, 'inventory_item')][.//div[contains(@class, 'inventory_item_name') and text()='{0}']]//button[contains(@class, 'btn_inventory')]");
}
