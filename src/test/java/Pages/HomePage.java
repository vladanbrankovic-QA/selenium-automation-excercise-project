package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/products']")
    WebElement productsButton;

    @FindBy(css = "a[href='/view_cart']")
    WebElement viewCartButton;

    @FindBy(css = "a[href='/login']")
    public WebElement loginButton;

    @FindBy(css = "a[href='#Men']")
    WebElement menSectionButton;

    @FindBy(css = "a[href='/category_products/3']")
    WebElement menTshirtsButton;

    @FindBy(css = ".btn.btn-success.close-modal.btn-block")
    public WebElement continueShoppingButton;

    @FindBy(css = ".title.text-center")
    public WebElement featuresItemsText;

    @FindBy(css = "a[data-product-id='1']")
    public WebElement blueTopAddToCart;

    @FindBy(css = "a[href='/product_details/1']")
    WebElement viewProductButton;

    @FindBy(css = "a[href='/logout']")
    public WebElement logoutButton;


    //-----------------------------------------------

    public void clickOnProductsButton() {
        productsButton.click();
    }

    public void clickOnViewCartButton() {
        viewCartButton.click();
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clickOnMenButton() {
        menSectionButton.click();
    }

    public void clickOnMenTshirtsButton() {
        menTshirtsButton.click();
    }

    public void clickOnContinueShoppingButtonHomepage() {
        continueShoppingButton.click();
    }

    public void clickOnViewProductButton() { viewProductButton.click(); }

    public void clickOnLogoutButton() { logoutButton.click(); }

    //-----------------------------------------------

    public WebElement getMenSectionButton() {
        return menSectionButton;
    }

    //-----------------------------------------------

    public void addFirstItemToCartFromHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(blueTopAddToCart));
        blueTopAddToCart.click();
    }
}