package questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userInterfaces.CheckoutCompletePage.LBL_ORDER_CONFIRMATION;
import static userInterfaces.CheckoutOverviewPage.LBL_PRICES;
import static userInterfaces.CheckoutOverviewPage.LBL_SUBTOTAL;

public class ValidatePrices implements Question<Boolean> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatePrices.class);

    public ValidatePrices() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        double expectedValue = LBL_PRICES.resolveAllFor(actor)
                .stream()
                .map(WebElementFacade::getText)
                .map(text -> text.replaceAll("[^\\d.]", ""))
                .mapToDouble(Double::parseDouble)
                .sum();

        double actualValue = Double.parseDouble(
                LBL_SUBTOTAL.resolveFor(actor)
                .getText()
                .replaceAll("[^\\d.]", "")
        );

        if (expectedValue == actualValue) {
            LOGGER.info(
                    "{} verificó que la suma de los productos [${}] coincide con el subtotal mostrado [${}]",
                    actor.getName(),
                    expectedValue,
                    actualValue
            );
        } else {
            LOGGER.warn(
                    "{} encontró una diferencia: suma de productos [${}] no coincide con el subtotal mostrado [${}]",
                    actor.getName(),
                    expectedValue,
                    actualValue
            );
        }

        return expectedValue == actualValue;
    }

    public static Question<Boolean> value() {
        return new ValidatePrices();
    }
}
