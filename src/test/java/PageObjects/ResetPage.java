package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResetPage {
    public WebElement getInfoMessage() {
        return infoMessage;
    }

    @FindBy(how = How.CLASS_NAME, using = "info")
    WebElement infoMessage;
}
