package PageObjects;

import org.openqa.selenium.WebElement;

public class SignUpPage {
    private WebElement email;

    public void SignUp(String emailAddress) {
        email.sendKeys(emailAddress);
        email.submit();
    }

}
