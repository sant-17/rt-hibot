package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userInterfaces.CheckoutCompletePage.LBL_ORDER_CONFIRMATION;

public class ValidateOrder implements Question<Boolean> {
    protected String message;

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateOrder.class);

    public ValidateOrder(String message) {
        this.message = message;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean elementIsPresent = LBL_ORDER_CONFIRMATION.resolveFor(actor).isPresent();
        Boolean elementContainsMessage = LBL_ORDER_CONFIRMATION.resolveFor(actor).getText().equalsIgnoreCase(message);

        if (elementContainsMessage) {
            LOGGER.info(
                    "{} verificó que el mensaje '{}' se encuentra en el elemento '{}'",
                    actor.getName(),
                    message,
                    LBL_ORDER_CONFIRMATION.getName()
            );
        } else {
            LOGGER.warn(
                    "{} no encontró el mensaje '{}' en el elemento '{}'",
                    actor.getName(),
                    message,
                    LBL_ORDER_CONFIRMATION.getName()
            );
        }

        return elementContainsMessage && elementIsPresent;
    }

    public static Question<Boolean> value(String message) {
        return new ValidateOrder(message);
    }
}
