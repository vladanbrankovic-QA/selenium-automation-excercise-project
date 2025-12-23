package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    JavascriptExecutor js;

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://automationexercise.com/");
        homePage = new HomePage();
        loginPage = new LoginPage();
        signupPage = new SignupPage();

        js = (JavascriptExecutor) driver;
    }

    @Test (priority = 1)
    public void userCanSignUpAndIsLoggedIn() {

            homePage.clickOnLoginButton();
            loginPage.inputSignupNameField("Vladan");
            loginPage.inputSignupEmail("vladan" + Math.random() +"@gmail.com");
            loginPage.clickOnSignupButton();
            signupPage.clickOnMrRadioButton();
            signupPage.inputPassword("PeterCrouch123");
            signupPage.inputDayOfBirth("28");
            signupPage.inputMonthOfBirth("January");
            signupPage.inputYearOfBirth("1995");
            js.executeScript("arguments[0].scrollIntoView();", signupPage.newsletterCheckBox);
            signupPage.clickOnNewsletterCheckBox();
            signupPage.clickOnOfferCheckBox();
            signupPage.inputFirstName("Vladan");
            signupPage.inputLastName("Brankovic");
            signupPage.inputCompany("Blueberries");
            signupPage.inputAddress("53rd Mohawk");
            signupPage.chooseACountry("United States");
            js.executeScript("arguments[0].scrollIntoView();", signupPage.stateField);
            signupPage.inputState("Texas");
            signupPage.inputCity("Austin");
            signupPage.inputZipcode("5287");
            signupPage.inputMobileNumber("+15550256");
            signupPage.clickOnCreateAccountButton();

            String expectedURL = "https://automationexercise.com/account_created";
            String actualURL = driver.getCurrentUrl();
            Assert.assertEquals(actualURL, expectedURL);

            WebElement accountCreated = driver.findElement(By.cssSelector("h2[data-qa='account-created']"));
            String accountCreatedText = "ACCOUNT CREATED!";
            Assert.assertEquals(accountCreated.getText(), accountCreatedText);

            signupPage.clickOnContinueButton();

            //Assert that user is logged in after clicking on continue button

            WebElement logoutButton = driver.findElement(By.cssSelector("a[href='/logout']"));
            Assert.assertTrue(logoutButton.isDisplayed());

            WebElement deleteAccountButton = driver.findElement(By.cssSelector("a[href='/delete_account']"));
            Assert.assertTrue(deleteAccountButton.isDisplayed());

    }

    @Test
    public void userCannotSignUpWithExistingEmail() {
        homePage.clickOnLoginButton();
        loginPage.inputSignupNameField("Vladan");
        loginPage.inputSignupEmail("vladanbrankovic@gmail.com"); //vec postojeci email u bazi
        loginPage.clickOnSignupButton();

        String expectedURL = "https://automationexercise.com/signup";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        Assert.assertTrue(loginPage.signUpErrorMessage.isDisplayed());
    }

}
