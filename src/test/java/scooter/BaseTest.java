package scooter;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import scooter.objpage.*;
import scooter.steps.OrderSteps;


public class BaseTest {
    protected WebDriver driver;
    String browser = "firefox";
    protected  MainPage mainPage;
    protected  OrderSteps orderSteps;
    protected  OrderStatusPage orderStatusPage;


    @Before
    public  void startUp() {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe"); // Setting system properties of FirefoxDriver
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
        }
        mainPage = new MainPage(driver);
        orderSteps = new OrderSteps(driver);
        orderStatusPage = new OrderStatusPage(driver);
        mainPage.openMainPage();
        driver.manage().window().maximize();
        mainPage.closeCookiesWindow();
    }



    @After
    public void tearDown () {
           driver.quit();
    }
}
