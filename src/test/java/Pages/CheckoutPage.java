package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Place Order")
    WebElement placeOrderButton;

    //----------------------------------------

    public void clickOnPlaceOrderButton() {
        placeOrderButton.click();
    }

}
