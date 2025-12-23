package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    JavascriptExecutor js;

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://automationexercise.com/");
        homePage = new HomePage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void userCanAddThreeItemsToCart_FromHome_MenTshirts_AndSearch() {

        js.executeScript("arguments[0].scrollIntoView();", homePage.featuresItemsText);

        homePage.addFirstItemToCartFromHomePage();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.continueShoppingButton));
        homePage.clickOnContinueShoppingButtonHomepage();

        homePage.clickOnMenButton();
        homePage.clickOnMenTshirtsButton();

        productsPage.addMenTshirtToCart();
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.continueShoppingButton));
        productsPage.clickOnContinueShoppingButtonProducts();

        homePage.clickOnProductsButton();
        productsPage.searchForJeans("jeans");
        productsPage.addFirstItemFromJeansListToCart();
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.continueShoppingButton));
        productsPage.clickOnContinueShoppingButtonProducts();

        homePage.clickOnViewCartButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        Assert.assertEquals(cartPage.numberOfItemsInCart(), 3);
    }

    @Test
    public void userCanRemoveItemFromCart() {

        js.executeScript("arguments[0].scrollIntoView();", homePage.featuresItemsText);

        homePage.addFirstItemToCartFromHomePage();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.continueShoppingButton));
        homePage.clickOnContinueShoppingButtonHomepage();

        homePage.clickOnViewCartButton();

        int itemsBefore = cartPage.numberOfCartRows();

        cartPage.removeFirstItem();

        wait.until(d -> cartPage.numberOfCartRows() < itemsBefore);

        Assert.assertEquals(cartPage.numberOfCartRows(), itemsBefore - 1);
    }

    @Test
    public void userCantCheckoutWithoutLogin() {

        js.executeScript("arguments[0].scrollIntoView();", homePage.featuresItemsText);

        homePage.addFirstItemToCartFromHomePage();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.continueShoppingButton));
        homePage.clickOnContinueShoppingButtonHomepage();

        homePage.clickOnViewCartButton();

        cartPage.clickOnProceedToCheckoutButton();

        Assert.assertTrue(cartPage.registerLoginLink.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
    }
}