package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "input[data-qa='login-email']")
    WebElement loginEmailAddressField;

    @FindBy (css = "input[data-qa='login-password']")
    WebElement loginPasswordField;

    @FindBy (css = "input[data-qa='signup-name']")
    WebElement signUpNameField;

    @FindBy (css = "input[data-qa='signup-email']")
    WebElement signUpEmailAddressField;

    @FindBy (css = "button[data-qa='login-button']")
    WebElement loginButton;

    @FindBy (css = "button[data-qa='signup-button']")
    WebElement signUpButton;

    @FindBy(css = "form[action='/login'] p")
    public WebElement loginErrorMessage;

    @FindBy(css = "form[action='/signup'] p")
    public WebElement signUpErrorMessage;

    //-----------------------------------------------------

    public void inputLoginEmail(String email) {
        loginEmailAddressField.clear();
        loginEmailAddressField.sendKeys(email);
    }

    public void inputLoginPassword (String password) {
        loginPasswordField.clear();
        loginPasswordField.sendKeys(password);
    }

    public void inputSignupNameField (String name) {
        signUpNameField.clear();
        signUpNameField.sendKeys(name);
    }

    public void inputSignupEmail (String email) {
        signUpEmailAddressField.clear();
        signUpEmailAddressField.sendKeys(email);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clickOnSignupButton() {
        signUpButton.click();
    }

    public boolean loginErrorMessageIsDisplayed() {
        return loginErrorMessage.getText().contains("Your email or password is incorrect!");
    }

}
