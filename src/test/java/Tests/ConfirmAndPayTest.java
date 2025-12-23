package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConfirmAndPayTest extends BaseTest {

    JavascriptExecutor js;

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://automationexercise.com/");
        loginPage = new LoginPage();
        homePage = new HomePage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        paymentPage = new PaymentPage();

        js = (JavascriptExecutor) driver;
    }

    @Test
    public void userCanAddConfirmAndPayForProduct() {
        homePage.clickOnLoginButton();
        String validEmail = excelReader.getStringData("AELogin", 1, 0);
        String validPassword = excelReader.getStringData("AELogin", 1, 1);
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();
        js.executeScript("arguments[0].scrollIntoView();", homePage.getMenSectionButton());
        homePage.addFirstItemToCartFromHomePage();
        homePage.clickOnContinueShoppingButtonHomepage();
        homePage.clickOnViewCartButton();
        cartPage.clickOnProceedToCheckoutButton();
        checkoutPage.clickOnPlaceOrderButton();
        paymentPage.inputNameOnCard("Vladan");
        paymentPage.inputCardNumber("2222 1111 3333 5555");
        paymentPage.inputCvcNumber("821");
        paymentPage.inputExpiryMonth("12");
        paymentPage.inputExpiryYear("2029");
        paymentPage.clickOnConfirmOrderButton();

        WebElement orderPlacedText = driver.findElement(By.cssSelector("h2[data-qa='order-placed']"));

        wait.until(ExpectedConditions.visibilityOf(orderPlacedText));

        Assert.assertEquals(orderPlacedText.getText(), "ORDER PLACED!");

        Assert.assertTrue(driver.getCurrentUrl().contains("payment_done"));
    }

}
