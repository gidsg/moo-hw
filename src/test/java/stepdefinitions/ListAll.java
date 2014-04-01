package stepdefinitions;

import pages.SignUpPage;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import common.SharedDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListAll {
    private final WebDriver driver;
    protected Config conf;
    protected String emailAddress=("gids-"+ UUID.randomUUID()+"@example.org");
    SignUpPage page;


    public ListAll(SharedDriver driver) {
        this.driver = driver;
        conf = ConfigFactory.load();

    }
    @Given("^I have signed up to the email list$")
    public void iHaveSignedUpToTheEmailList() {
        driver.get(conf.getString("moo-hw.host")+"signup");
        page = PageFactory.initElements(driver, SignUpPage.class);
        page.SignUp(emailAddress);
    }

    @When("^I load the list subscribers page$")
    public void iLoadTheListSubscribersPage()  {
        driver.get(conf.getString("moo-hw.host")+"all");
    }

    @Then("^I should see my email address$")
    public void iShouldSeeMyEmailAddress() throws Throwable {
    assertThat(driver.findElement(By.tagName("body")).getText(), containsString(emailAddress));
    }
}
