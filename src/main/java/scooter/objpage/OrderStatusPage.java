package scooter.objpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderStatusPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By notFoundImg = By.xpath("//div[@class=\"Track_NotFound__6oaoY\"]/img");
    private final By seeButton =  By.xpath ("//button[text()=\"Посмотреть\"]");

    public OrderStatusPage (WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
        wait= new WebDriverWait(driver, 10);
    }

    public void waitUntilUploadStatusForm () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(seeButton));
    }

    public  boolean isOrderStatusDisplay () {
        return !(driver.findElement(notFoundImg).isDisplayed());
    }
}
