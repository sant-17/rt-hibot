package stepDefinitions.hook;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hook {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }
}
