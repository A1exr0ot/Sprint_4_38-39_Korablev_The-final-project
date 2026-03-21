package scooter.tests;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scooter.BaseTest;
import scooter.constants.Constants;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class HeaderTests extends BaseTest {

    @Test
    public void checkRedirectToYandex () {
        mainPage.clickYandexLogo();
        new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfWindowsToBe(2));
        var tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String link = driver.getCurrentUrl();
        assertEquals ("Открыта не главная страница Яндекса", link, Constants.YANDEX_PAGE_URL);
    }
}
