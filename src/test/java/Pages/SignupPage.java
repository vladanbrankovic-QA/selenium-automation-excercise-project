package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BaseTest {

    public SignupPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "id_gender1")
    WebElement genderRadioButton;

    @FindBy (id = "password")
    WebElement passwordField;

    @FindBy (id = "days")
    WebElement dayOfBirth;

    @FindBy (id = "months")
    WebElement monthOfBirth;

    @FindBy (id = "years")
    WebElement yearOfBirth;

    @FindBy (id = "newsletter")
    public WebElement newsletterCheckBox;

    @FindBy (id = "optin")
    WebElement offerCheckBox;

    @FindBy (id = "first_name")
    WebElement firstNameField;

    @FindBy (id = "last_name")
    WebElement lastNameField;

    @FindBy (id = "company")
    WebElement companyField;

    @FindBy (id = "address1")
    WebElement addressField;

    @FindBy (id = "country")
    WebElement countryDropDown;

    @FindBy (id = "state")
    public WebElement stateField;

    @FindBy (id = "city")
    WebElement cityField;

    @FindBy (id = "zipcode")
    WebElement zipcodeField;

    @FindBy (id = "mobile_number")
    WebElement mobileNumberField;

    @FindBy (css = "button[data-qa='create-account']")
    WebElement createAccountButton;

    @FindBy (linkText = "Continue")
    WebElement continueButton;

    //--------------------------------

    public void clickOnMrRadioButton() {
        genderRadioButton.click();
    }

    public void inputPassword (String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void inputDayOfBirth(String dayBirth) {
        Select day = new Select(dayOfBirth);
        day.selectByContainsVisibleText(dayBirth);
    }

    public void inputMonthOfBirth(String monthBirth) {
        Select month = new Select(monthOfBirth);
        month.selectByContainsVisibleText(monthBirth);
    }

    public void inputYearOfBirth(String yearBirth) {
        Select year = new Select(yearOfBirth);
        year.selectByContainsVisibleText(yearBirth);
    }

    public void clickOnNewsletterCheckBox() {
        newsletterCheckBox.click();
    }

    public void clickOnOfferCheckBox() {
        offerCheckBox.click();
    }

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputCompany (String company) {
        companyField.clear();
        companyField.sendKeys(company);
    }

    public void inputAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void chooseACountry(String country1) {
        Select country = new Select(countryDropDown);
        country.selectByContainsVisibleText(country1);
    }

    public void inputState(String state) {
        stateField.clear();
        stateField.sendKeys(state);
    }

    public void inputCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void inputZipcode(String zipcode) {
        zipcodeField.clear();
        zipcodeField.sendKeys(zipcode);
    }

    public void inputMobileNumber(String mobileNumber) {
        mobileNumberField.clear();
        mobileNumberField.sendKeys(mobileNumber);
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }

}
