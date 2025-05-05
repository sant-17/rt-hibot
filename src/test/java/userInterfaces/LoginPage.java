package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target INPUT_USERNAME = Target
            .the("Input del nombre de usuario")
            .locatedBy("//input[@id='user-name']");

    public static final Target INPUT_PASSWORD = Target
            .the("Input de la contraseña")
            .locatedBy("//input[@id='password']");

    public static final Target BTN_LOG_IN = Target
            .the("Botón de inicio de sesión")
            .locatedBy("//input[@id='login-button']");

    public static final Target LBL_LOG_IN_ERROR = Target
            .the("Mensaje de inicio de sesión incorrecto")
            .locatedBy("//h3[@data-test='error']");
}
