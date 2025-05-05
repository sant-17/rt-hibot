package stepDefinitions;

import interactions.FinishCheckout;
import interactions.OpenNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ValidateOrder;
import questions.ValidatePrices;
import tasks.AddProductToCartTask;
import tasks.FillCheckoutFormTask;
import tasks.LoginTask;

import static constants.Constants.ACTOR;
import static constants.Constants.WEB_URL;

public class SuccessfulPurchaseStep {
    @Given("a user is on the homepage and logged in with username {string} and password {string}")
    public void aUserIsOnTheHomepageAndLoggedInWithUsernameAndPassword(String username, String password) {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                OpenNav.withUrl(WEB_URL),
                LoginTask.withCredentials(username, password)
        );
    }

    @When("add {string} and {string} to the cart")
    public void addToTheCart(String product1, String product2) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductToCartTask.withProducts(product1, product2)
        );
    }

    @And("proceed to checkout with their name {string}, {string} and postal code {string}")
    public void proceedToCheckoutWithTheirNameAndPostalCode(String firstName, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillCheckoutFormTask.withData(firstName, lastName, postalCode)
        );
    }

    @Then("the displayed subtotal should equal the sum of the selected products")
    public void theDisplayedSubtotalShouldEqualTheSumOfTheSelectedProducts() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidatePrices.value())
        );
    }

    @And("the message {string} confirming the purchase should be displayed")
    public void theMessageConfirmingThePurchaseShouldBeDisplayed(String message) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FinishCheckout.now()
        );

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateOrder.value(message))
        );
    }
}
