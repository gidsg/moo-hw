package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListAllPage {
    public WebElement getNoSignUpsMessageElement() {
        return noSignUpsMessageElement;
    }

    @FindBy(how = How.CLASS_NAME, using = "no-signups")
    WebElement noSignUpsMessageElement;

}
