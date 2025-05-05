package tasks;

import interactions.GoToCart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userInterfaces.CheckoutInformationPage.BTN_CONTINUE_TO_OVERVIEW;
import static userInterfaces.CheckoutInformationPage.INPUT_FIRST_NAME;
import static userInterfaces.CheckoutInformationPage.INPUT_LAST_NAME;
import static userInterfaces.CheckoutInformationPage.INPUT_POSTAL_CODE;
import static userInterfaces.ShoppingCartPage.BTN_GO_TO_CHECKOUT;

public class FillCheckoutFormTask implements Task {
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    private static final Logger LOGGER = LoggerFactory.getLogger(FillCheckoutFormTask.class);

    public FillCheckoutFormTask(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info(
                "{} está llenando el formulario del checkout con los datos: '{}', '{}', '{}'",
                actor.getName(),
                firstName,
                lastName,
                postalCode
        );

        actor.attemptsTo(
                GoToCart.now(),
                Click.on(BTN_GO_TO_CHECKOUT),
                Enter.keyValues(firstName).into(INPUT_FIRST_NAME),
                Enter.keyValues(lastName).into(INPUT_LAST_NAME),
                Enter.keyValues(postalCode).into(INPUT_POSTAL_CODE),
                Click.on(BTN_CONTINUE_TO_OVERVIEW)
        );
    }

    public static FillCheckoutFormTask withData(String firstName, String lastName, String postalCode) {
        return Tasks.instrumented(FillCheckoutFormTask.class, firstName, lastName, postalCode);
    }
}
