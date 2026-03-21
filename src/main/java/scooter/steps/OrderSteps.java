package scooter.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import scooter.constants.Constants;
import static org.junit.Assert.*;
import scooter.objpage.OrderPage;

public class OrderSteps {
    private final WebDriver driver;
    protected OrderPage orderPage;


    public OrderSteps(WebDriver driver) {
        this.driver = driver;
        orderPage = new OrderPage(driver);
    }

    public void  fillFirstPageOrderForm (String n, String s, String a, String m, String num) {
        orderPage.setName(n);
        orderPage.setSurname(s);
        orderPage.setAddress(a);
        orderPage.setMetro(m);
        orderPage.setNumber(num);
        orderPage.clickNextButton();
    }

    public void checkErrorMessagesForOrderForm ( String [] expectedMessages ) {
        for (int i = 0; i < expectedMessages.length; i++) {
            assertEquals("Неверное сообщение об ошибке", expectedMessages[i], orderPage.getErrorMessage(i));
        }
        assertEquals("Неверное сообщение об ошибке", Constants.METRO_ERROR_MESSAGE, orderPage.getErrorMessageForMetro());
    }

    public void  fillOrderForm (String n, String s, String a, String m, String num, String d) {
        fillFirstPageOrderForm (n,s, a,m, num);
        orderPage.setDate(d);
        orderPage.selectRent(2);
        orderPage.clickOrderButton();
    }

    public void confirmOrder () {
       orderPage.clickYesForConformation();
    }

    public void checkThatOrderIsCompleted () {
        String orderM = orderPage.getInfoMessage();
        assertTrue ( "Ошибка оформления заказа", orderM.contains("Заказ оформлен"));
    }
}
