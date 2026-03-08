import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.OrderMakeSteps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderMakeTest extends BaseTest {
    public String name;
    public String lastName;
    public String address;
    public int station;
    public String phone;
    public String date;
    public int period;
    public String option;

    public OrderMakeTest(String browser,
                         String name,
                         String lastName,
                         String address,
                         int station,
                         String phone,
                         String date,
                         int period,
                         String option) {
        super(browser);
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.option = option;
    }

    @Parameterized.Parameters(name = "{0}: {1} {2} {3} {4} {5} {6} {7} {8}")
    public static Object[][] getBrowserSelection() {
        return new Object[][]{
                {"chrome", "Александр", "Кораблев", "Лазурная 13", 3, "+79174971297", "18.12.1982", 3, "серая безысходность"},
                {"chrome", "Анатолий", "Иванов", "Менделеева 4", 5, "+78008009988", "06.01.1995", 2, "чёрный жемчуг"},
                {"firefox", "Александр", "Кораблев", "Лазурная 13", 3, "+79174971297", "18.12.1982", 3, "серая безысходность"},
                {"firefox", "Анатолий", "Иванов", "Менделеева 4", 5, "+78008009988", "06.01.1995", 2, "чёрный жемчуг"}
        };
    }

    @Test
    public void successfulOrderUp() {
        OrderMakeSteps orderSteps = new OrderMakeSteps(orderMakePage);
        openPage();

        // нажать кнопку "Заказ"
        mainPage.clickUpOrderButton();
        orderSteps.firstStepForWhom(name, lastName, address, station, phone);
        orderSteps.secondaryStepAboutRental(date, period, option);

        //проверка перехода на модальное окно путем поиска специфического элемента
        assertFalse("Переход на страницу подтверждения не выполнен", orderMakePage.getList().isEmpty());
    }

    @Test
    public void successfulOrderDown() {
        //Создаём экземпляр OrderMakeSteps с передачей orderMakePage
        OrderMakeSteps orderSteps = new OrderMakeSteps(orderMakePage);
        openPage();

        // нажать кнопку "Заказ"
        mainPage.clickDownOrderButton();
        orderSteps.firstStepForWhom(name, lastName, address, station, phone);
        orderSteps.secondaryStepAboutRental(date, period, option);

        //проверка перехода на модальное окно путем поиска специфического элемента
        assertFalse("Переход на страницу подтверждения не выполнен", orderMakePage.getList().isEmpty());
    }
}