package scooter.tests;

import org.junit.Test;
import scooter.BaseTest;
import scooter.constants.Constants;

import java.util.Random;

import static scooter.constants.Constants.*;

public class OrderTests extends BaseTest  {

    @Test
    public void orderByHeaderOrderButton () {
        mainPage.clickHeaderOrderButton();
        orderSteps.fillOrderForm("Иван", "Иванов", "ННовгород", "Парк культуры", "89605045656","23.11.2024");
        orderSteps.confirmOrder();
        orderSteps.checkThatOrderIsCompleted();
    }

    @Test
    public void orderByDownOrderButton() {
        mainPage.clickDownOrderButton();
        orderSteps.fillOrderForm("Петр", "Петров", "Москва", "Парк культуры", "89605045444","25.11.2024");
        orderSteps.confirmOrder();
        orderSteps.checkThatOrderIsCompleted();
    }

    @Test
    public void validateErrorMessages () {
        String [] extMessagesExpectMetro = {NAME_ERROR_MESSAGE, SURNAME_ERROR_MESSAGE, ADDRESS_ERROR_MESSAGE, NUMBER_ERROR_MESSAGE};
        mainPage.clickHeaderOrderButton();
        orderSteps.fillFirstPageOrderForm("tt", "rr", "tttt", "tt", "7777");
        orderSteps.checkErrorMessagesForOrderForm(extMessagesExpectMetro);
        }
    }

