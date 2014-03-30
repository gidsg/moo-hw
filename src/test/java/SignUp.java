import PageObjects.SignUpPage;
import PageObjects.ThankYouPage;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import common.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignUp {
    protected WebDriver driver;
    protected Config conf;
    protected String emailAddress=("gids-"+ UUID.randomUUID()+"@example.org");


    public SignUp() {
        conf = ConfigFactory.load();
    }

    @Before
    public void tearUp() {
        driver = DriverFactory.createDriver(conf.getString("moo-hw.driver"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("^I am on the email sign up page$")
    public void iAmOnTheEmailSignUpPage() {
        driver.get(conf.getString("moo-hw.host")+"signup");

    }


    @When("^I enter a valid email address$")
    public void iEnterAValidEmailAddress() throws Throwable {
        SignUpPage page = PageFactory.initElements(driver, SignUpPage.class);
        page.SignUp(emailAddress);
    }

    @Then("^I see a thank you confirmation message$")
    public void iSeeAThankYouConfirmationMessage() throws Throwable {
        ThankYouPage page = PageFactory.initElements(driver, ThankYouPage.class);
        assertThat(page.getThankYouHeadingElement().getText(), is(page.getThankYouHeading()));
    }





}
