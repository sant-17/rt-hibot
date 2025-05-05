package tasks;

import exceptions.LoginFailedException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userInterfaces.LoginPage.BTN_LOG_IN;
import static userInterfaces.LoginPage.INPUT_PASSWORD;
import static userInterfaces.LoginPage.INPUT_USERNAME;
import static userInterfaces.LoginPage.LBL_LOG_IN_ERROR;

public class LoginTask implements Task {

    private final String username;
    private final String password;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginTask.class);

    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info(
                "{} está iniciando sesión con el usuario '{}' y clave '{}'",
                actor.getName(),
                username,
                password
        );

        actor.attemptsTo(
                Enter.keyValues(username).into(INPUT_USERNAME),
                Enter.keyValues(password).into(INPUT_PASSWORD),
                Click.on(BTN_LOG_IN)
        );

        if (LBL_LOG_IN_ERROR.isVisibleFor(actor)) {
            throw new LoginFailedException(username, password);
        }
    }

    public static LoginTask withCredentials(String username, String password) {
        return Tasks.instrumented(LoginTask.class, username, password);
    }
}
