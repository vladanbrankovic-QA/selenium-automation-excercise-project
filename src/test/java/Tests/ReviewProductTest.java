package Tests;

import Base.BaseTest;
import Pages.ProductDetailsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReviewProductTest extends BaseTest {

    private ProductDetailsPage productDetailsPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://automationexercise.com/");
        homePage = new Pages.HomePage();
        productDetailsPage = new ProductDetailsPage();
    }

    @Test
    public void userCanLeaveReviewOnBlueTop() {

        homePage.clickOnViewProductButton();

        wait.until(ExpectedConditions.urlContains("/product_details/1"));

        productDetailsPage.inputName("Vladan");
        productDetailsPage.inputEmail("vladanbrankovic@gmail.com");
        productDetailsPage.inputReview("Review test");
        productDetailsPage.clickSubmitReview();

        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.reviewSuccessMessage));
        Assert.assertTrue(productDetailsPage.reviewSuccessMessage.isDisplayed());
    }
}