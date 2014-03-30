import PageObjects.SignUpPage;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import common.DriverFactory;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

public class SignUp {
    protected WebDriver driver;
    protected Config conf;


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
        page.SignUp("gids-"+ UUID.randomUUID()+"@example.org");
    }

    @Then("^I see a thank you confirmation message$")
    public void iSeeAThankYouConfirmationMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }





}
