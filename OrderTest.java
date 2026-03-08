import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrderTest {
    WebDriver driver;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            startChromeBrowser();
        } else if (browser.equals("firefox")) {
            startFirefoxBrowser();
        }
    }

    public void startChromeBrowser() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
    }

    public void startFirefoxBrowser() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void errorOrderTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void closeChromeBrowser() {
        driver.quit();
    }
}
