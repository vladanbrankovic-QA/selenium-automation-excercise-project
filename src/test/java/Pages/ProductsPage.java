package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsPage extends BaseTest {

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_product")
    WebElement searchField;

    @FindBy(id = "submit_search")
    WebElement searchButton;

    @FindBy(css = ".btn.btn-success.close-modal.btn-block")
    public WebElement continueShoppingButton;

    @FindBy(css = "a[data-product-id='33']")
    public WebElement firstJeans;

    @FindBy(css = "a[data-product-id='2']")
    public WebElement menTshirtAddToCart;

    //----------------------------------

    public void searchForProduct(String text) {
        searchField.clear();
        searchField.sendKeys(text);
        searchButton.click();
    }



    public void addFirstItemFromJeansListToCart() {

        wait.until(ExpectedConditions.elementToBeClickable(firstJeans));
        firstJeans.click();
    }

    public void addMenTshirtToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(menTshirtAddToCart));
        menTshirtAddToCart.click();
    }



    public void searchForJeans(String text) {
        searchForProduct(text);
    }

    public void clickOnContinueShoppingButtonProducts() {
        continueShoppingButton.click();
    }
}