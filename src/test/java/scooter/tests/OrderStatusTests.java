package scooter.tests;

import org.junit.*;
import scooter.BaseTest;
import scooter.constants.Constants;

import static org.junit.Assert.*;

public class OrderStatusTests extends BaseTest {

    @Test
    public void orderStatusForInvalidNUmber () {
        mainPage.clickOrderStatusButton();
        mainPage.setOrderStatus(Constants.INVALID_ORDER_NUMBER);
        mainPage.checkOrderStatus();
        orderStatusPage.waitUntilUploadStatusForm();
        assertFalse ("Заказ найден", orderStatusPage.isOrderStatusDisplay()) ;
    }
}
