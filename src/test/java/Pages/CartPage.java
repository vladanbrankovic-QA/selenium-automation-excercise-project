package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "cart_product")
    List<WebElement> cartProducts;

    @FindBy(css = ".btn.btn-default.check_out")
    WebElement proceedToCheckoutButton;


    @FindBy(css = "tbody tr")
    List<WebElement> cartRows;

    // remove dugmad
    @FindBy(className = "cart_quantity_delete")
    List<WebElement> removeButtons;


    @FindBy(linkText = "Register / Login")
     public WebElement registerLoginLink;

    // ------------------------------

    public int numberOfItemsInCart() {
        return cartProducts.size();
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public int numberOfCartRows() {
        return cartRows.size();
    }

    public void removeFirstItem() {
        removeButtons.get(0).click();
    }


}