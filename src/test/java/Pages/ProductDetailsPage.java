package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BaseTest {

    public ProductDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "review")
    WebElement reviewTextArea;

    @FindBy(id = "button-review")
    WebElement submitReviewButton;

    @FindBy(css = ".alert-success.alert")
    public WebElement reviewSuccessMessage;

    //----------------------------------------------

    public void inputName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void inputEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void inputReview(String review) {
        reviewTextArea.clear();
        reviewTextArea.sendKeys(review);
    }

    public void clickSubmitReview() {
        submitReviewButton.click();
    }
}