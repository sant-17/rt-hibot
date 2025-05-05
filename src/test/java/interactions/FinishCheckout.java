package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userInterfaces.CheckoutOverviewPage.BTN_FINISH_CHECKOUT;

public class FinishCheckout implements Interaction {

    public FinishCheckout() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_FINISH_CHECKOUT)
        );
    }

    public static FinishCheckout now() {
        return Tasks.instrumented(FinishCheckout.class);
    }
}
