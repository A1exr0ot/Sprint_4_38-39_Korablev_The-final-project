package scooter.objpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver driver;
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By numberField = By.xpath (".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath ("//button[text()=\"Далее\"]");
    private final By dataField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodField = By.xpath("//div[@class=\"Dropdown-control\"]");
    private final By orderButton = By.xpath ("//div[@class=\"Order_Buttons__1xGrp\"]/button[text()=\"Заказать\"]");
    private final By infoMessage = By.xpath ("//div[@class=\"Order_ModalHeader__3FDaJ\"]");
    private final By yesButton = By.xpath ("//button[text()=\"Да\"]");
    private final By oneDayRent = By.xpath ("//div[text()=\"сутки\"]");
    private final By errorMessages = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");
    private final By errorMessagesForMetro = By.xpath("//div[@class=\"Order_UnderError__1VSDB\"]");


    public OrderPage (WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }

    public void setName(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetro (String metro) {
        driver.findElement(metroField).clear();
        driver.findElement(metroField).sendKeys(metro);
        By locator = By.className("select-search__select");
        driver.findElement(locator).click();
    }

    public void setNumber (String number) {
        driver.findElement(numberField).clear();
        driver.findElement(numberField).sendKeys(number);
    }

    public void clickNextButton () {
        driver.findElement(nextButton).click();
    }

    public void setDate (String date) {
        driver.findElement(dataField).sendKeys(date);
        driver.findElement(dataField).sendKeys(Keys.ENTER);
    }

    public void selectRent (int index) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(oneDayRent).click();
    }

    public void clickOrderButton () {
        driver.findElement(orderButton).click();
    }

    public String getInfoMessage () {
        return driver.findElement(infoMessage).getText();
    }

    public void clickYesForConformation () {
        driver.findElement(yesButton).click();
    }

    public String getErrorMessage (int i) {
        return driver.findElements(errorMessages).get(i).getText();
    }

    public String getErrorMessageForMetro () {
        return driver.findElement(errorMessagesForMetro).getText();
    }

}
