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

    public WebElement getThankYouBodyTextElement() {
        return thankYouBodyTextElement;
    }

    @FindBy(how = How.CLASS_NAME, using = "main")
    WebElement thankYouBodyTextElement;

}
