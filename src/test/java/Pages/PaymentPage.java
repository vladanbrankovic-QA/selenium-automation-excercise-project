package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseTest {

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "input[data-qa='name-on-card']")
    WebElement nameOnCardField;

    @FindBy (css = "input[data-qa='card-number']")
    WebElement cardNumberField;

    @FindBy (css = "input[data-qa='cvc']")
    WebElement cvcNumberField;

    @FindBy (css = "input[data-qa='expiry-month']")
    WebElement expiryMonthField;

    @FindBy (css = "input[data-qa='expiry-year']")
    WebElement expiryYearField;

    @FindBy (id = "submit")
    WebElement confirmOrderButton;

    //---------------------------------------------

    public void inputNameOnCard(String nameOnCard) {
        nameOnCardField.clear();
        nameOnCardField.sendKeys(nameOnCard);
    }

    public void inputCardNumber(String cardNumber) {
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNumber);
    }

    public void inputCvcNumber(String cvcNumber) {
        cvcNumberField.clear();
        cvcNumberField.sendKeys(cvcNumber);
    }

    public void inputExpiryMonth(String expiryMonth) {
        expiryMonthField.clear();
        expiryMonthField.sendKeys(expiryMonth);
    }

    public void inputExpiryYear(String expiryYear) {
        expiryYearField.clear();
        expiryYearField.sendKeys(expiryYear);
    }

    public void clickOnConfirmOrderButton() {
        confirmOrderButton.click();
    }

}
