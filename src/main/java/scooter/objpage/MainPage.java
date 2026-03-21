package scooter.objpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static scooter.constants.Constants.*;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    // тут название локаторов
    private final By accordionHeading = By.xpath(".//div[@class='accordion__button']");
    private final By accordionText = By.xpath(" .//div[@class='accordion__panel']");
    private final By cookiesButton = By.xpath("//*[@id=\"rcc-confirm-button\"]");
    private final By orderHeaderButton = By.xpath("//div[@class=\"Header_Nav__AGCXC\"]/button[text()=\"Заказать\"]");
    private final By orderDownButton = By.xpath("//div[@class=\"Home_FinishButton__1_cWm\"]/button[text()=\"Заказать\"]");
    private final By orderStatusButton = By.xpath( "//button[text()=\"Статус заказа\"]");
    private final By orderStatusField = By.xpath ("//div[@class=\"Input_InputContainer__3NykH\"]/input");
    private final By getOrderStatusButton = By.xpath ("//button[text()=\"Go!\"]");
    private final By yandexLogo = By.xpath ("//img[@alt=\"Yandex\"]");



    public MainPage (WebDriver driver) {
        this.driver = driver;
        wait= new WebDriverWait(driver, 10);// Инициализировали в нём поле driver
    }

    public void clickAccordionHeadByIndex (int index) {
        driver.findElements(accordionHeading).get(index).click();
    }
    public String getAccordionHeadingTextByIndex (int index) {
        return driver.findElements(accordionHeading).get(index).getText();
    }

    public String getAccordionTextByIndex (int index) {
         return driver.findElements(accordionText).get(index).getText();
    }

    public void closeCookiesWindow () {
        driver.findElement (cookiesButton).click();
    }

    public void openMainPage () {
        driver.get(MAIN_PAGE_URL);
    }

    public void clickHeaderOrderButton () {
        driver.findElement (orderHeaderButton).click();
    }

    public void clickDownOrderButton () {
        driver.findElement (orderDownButton).click();
    }

    public void clickOrderStatusButton () {
        driver.findElement (orderStatusButton).click();
    }

    public  void setOrderStatus (String orderNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderStatusField));
        driver.findElement(orderStatusField).sendKeys(orderNumber);
    }

    public void checkOrderStatus () {
        driver.findElement (getOrderStatusButton).click();
    }

    public void clickYandexLogo () {
        driver.findElement(yandexLogo).click();
    }
}
