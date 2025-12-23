package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://automationexercise.com/");
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test
    public void userCanLogin() {
        homePage.clickOnLoginButton();
        String validEmail = excelReader.getStringData("AELogin", 1, 0);
        String validPassword = excelReader.getStringData("AELogin", 1, 1);
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();

        WebElement logoutButton = driver.findElement(By.cssSelector("a[href='/logout']"));
        Assert.assertTrue(logoutButton.isDisplayed());

        WebElement deleteAccountButton = driver.findElement(By.cssSelector("a[href='/delete_account']"));
        Assert.assertTrue(deleteAccountButton.isDisplayed());
    }

    @Test
    public void userCantLogInWithInvalidEmail() {
        homePage.clickOnLoginButton();
        String invalidEmail = excelReader.getStringData("AELogin", 1, 2);
        String validPassword = excelReader.getStringData("AELogin", 1, 1);
        loginPage.inputLoginEmail(invalidEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();

        wait.until(ExpectedConditions.visibilityOf(loginPage.loginErrorMessage));
        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed());

        String expectedURL = "https://automationexercise.com/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void userCantLogInWithInvalidPassword() {
        homePage.clickOnLoginButton();
        String validEmail = excelReader.getStringData("AELogin", 1, 0);
        String invalidPassword = excelReader.getStringData("AELogin", 1, 3);
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(invalidPassword);
        loginPage.clickOnLoginButton();

        wait.until(ExpectedConditions.visibilityOf(loginPage.loginErrorMessage));
        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed());

        String expectedURL = "https://automationexercise.com/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void userCanLogOut() {
        homePage.clickOnLoginButton();
        String validEmail = excelReader.getStringData("AELogin", 1, 0);
        String validPassword = excelReader.getStringData("AELogin", 1, 1);
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();

        Assert.assertTrue(homePage.logoutButton.isDisplayed());

        homePage.clickOnLogoutButton();

        String expectedURL = "https://automationexercise.com/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(homePage.loginButton.isDisplayed());
    }


    @AfterMethod
    public void logOut() {
        List<WebElement> logoutButtons = driver.findElements(By.linkText("Logout"));
        if (!logoutButtons.isEmpty()) {
            logoutButtons.get(0).click();
        }
    }




}
