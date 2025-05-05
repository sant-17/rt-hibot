package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userInterfaces.CommonPage.BTN_GO_TO_CART;

public class GoToCart implements Interaction {

    public GoToCart() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_GO_TO_CART)
        );
    }

    public static GoToCart now() {
        return Tasks.instrumented(GoToCart.class);
    }
}
