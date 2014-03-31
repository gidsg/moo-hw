package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage {
    private WebElement email;

    public WebElement getErrorMessageElement() {
        return errorMessageElement;
    }

    @FindBy(how = How.CLASS_NAME, using = "errors")
    WebElement errorMessageElement;

    public void SignUp(String emailAddress) {
        email.sendKeys(emailAddress);
        email.submit();
    }

}
