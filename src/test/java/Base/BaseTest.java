package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public static WebDriverWait wait;

    public ExcelReader excelReader;

    public HomePage homePage;

    public LoginPage loginPage;

    public SignupPage signupPage;

    public CartPage cartPage;

    public ProductsPage productsPage;

    public CheckoutPage checkoutPage;

    public PaymentPage paymentPage;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        excelReader = new ExcelReader("WebTablesData.xlsx");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }



}
