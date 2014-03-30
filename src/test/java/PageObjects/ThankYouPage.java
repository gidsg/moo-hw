package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ThankYouPage {
    public WebElement getThankYouHeadingElement() {
        return thankYouHeadingElement;
    }

    @FindBy(how = How.TAG_NAME, using = "H1")
    WebElement thankYouHeadingElement;

    public String getThankYouHeading() {
        return thankYouHeading;
    }

    private String thankYouHeading="Thank your for your details!";

    public String getThankYouText() {
        return thankYouText;
    }

    private String thankYouText="You have signed up with email";
}
