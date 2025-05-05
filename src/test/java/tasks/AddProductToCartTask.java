package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userInterfaces.ProductsPage.BTN_ADD_PRODUCT_TO_CART;

public class AddProductToCartTask implements Task {

    private final String product1;
    private final String product2;

    private static final Logger LOGGER = LoggerFactory.getLogger(AddProductToCartTask.class);

    public AddProductToCartTask(String product1, String product2) {
        this.product1 = product1;
        this.product2 = product2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info(
                "{} está agregando productos  al carrito de compras",
                actor.getName()
        );

        actor.attemptsTo(
                Click.on(BTN_ADD_PRODUCT_TO_CART.of(product1)),
                Click.on(BTN_ADD_PRODUCT_TO_CART.of(product2))
        );
    }

    public static AddProductToCartTask withProducts(String product1, String product2) {
        return Tasks.instrumented(AddProductToCartTask.class, product1, product2);
    }
}
