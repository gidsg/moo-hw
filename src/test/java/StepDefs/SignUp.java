package StepDefs;

import PageObjects.SignUpPage;
import PageObjects.ThankYouPage;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import common.SharedDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import sun.security.util.PendingException;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignUp {
    private final WebDriver driver;
    protected Config conf;
    protected String emailAddress=("gids-"+ UUID.randomUUID()+"@example.org");
    SignUpPage page;

    public SignUp(SharedDriver driver) {
        this.driver = driver;
        conf = ConfigFactory.load();
        page = PageFactory.initElements(driver, SignUpPage.class);
    }


    @Given("^I am on the email sign up page$")
    public void iAmOnTheEmailSignUpPage() {
        driver.get(conf.getString("moo-hw.host")+"signup");

    }


    @When("^I enter a valid email address$")
    public void iEnterAValidEmailAddress() {
        page.SignUp(emailAddress);
    }

    @Then("^I see a thank you confirmation message$")
    public void iSeeAThankYouConfirmationMessage() {
        ThankYouPage page = PageFactory.initElements(driver, ThankYouPage.class);
        assertThat(page.getThankYouHeadingElement().getText(), is("Thank your for your details!"));
        assertThat(page.getThankYouBodyTextElement().getText(), containsString("You have signed up with email"+" "+emailAddress));
    }

    @When("^I leave the email field blank$")
    public void iLeaveTheEmailFieldBlank()  {
       page.SignUp("");

    }

    @Then("^I see an error message$")
    public void iSeeAnErrorMessage()  {
        assertThat(page.getErrorMessageElement().getText(), is("Please provide your email address"));
    }

    @Given("^I sign-up as \"(.*?)\"$")
    public void iSignUpAs(String emailAddress) throws Throwable {
        page.SignUp(emailAddress);
    }

    @When("^I sign-up again as \"(.*?)\"$")
    public void iSignUpAgainAs(String emailAddress) throws Throwable {
      // need to navigate away to let us reload the sign-up page
        driver.get("about:blank");
        driver.get(conf.getString("moo-hw.host")+"signup");
        page.SignUp(emailAddress);
    }

    @Then("^I see an error message saying the email address is already subscribed$")
    public void iSeeAnErrorMessageSayingTheEmailAddressIsAlreadySubscribed() {
        assertThat(page.getErrorMessageElement().getText(), is("This email has already been signed up"));
    }







}
