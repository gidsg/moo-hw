package stepdefinitions;

import pages.ListAllPage;
import pages.ResetPage;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import common.SharedDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Reset {
    private final WebDriver driver;
    protected Config conf;
    ResetPage resetPage;
    ListAllPage listAllPage;

    public Reset(SharedDriver driver) {
        this.driver = driver;
        conf = ConfigFactory.load();

    }

    @When("^I go to the reset URL$")
    public void iGoToTheResetURL() {
        driver.get(conf.getString("moo-hw.host")+"reset");
    }

    @Then("^I will see a confirmation message$")
    public void iWillSeeAConfirmationMessage()  {
        resetPage = PageFactory.initElements(driver, ResetPage.class);
        assertThat(resetPage.getInfoMessageElement().getText(), is("List of emails has been reset"));
        driver.get(conf.getString("moo-hw.host")+"all");
    }

    @Then("^there will be no email addresses on the email list$")
    public void thereWillBeNoEmailAddressesOnTheEmailList()  {
        listAllPage = PageFactory.initElements(driver, ListAllPage.class);
        assertThat(listAllPage.getNoSignUpsMessageElement().getText(), is("No email signups so far"));
    }
}
