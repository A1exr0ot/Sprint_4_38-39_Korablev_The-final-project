import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.FaqPage;
import steps.FaqSteps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class FaqTest extends BaseTest {

    @Parameterized.Parameters(name = "{0}: Вопрос: {1}")
    public static Object[][] getBrowserSelection() {
        List<String> browsers = List.of("chrome", "firefox");
        List<String[]> questionAndAnswerPairs = List.of(
                new String[]{"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                new String[]{"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                new String[]{"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                // Другие вопросы...
        );

        List<String[]> result = new ArrayList<>();
        for (String browser : browsers) {
            for (String[] questionAndAnswer : questionAndAnswerPairs) {
                result.add(new String[]{browser, Arrays.toString(questionAndAnswer), Arrays.toString(questionAndAnswer)});
            }
        }
        return result.toArray(String[][]::new);
    }

    private FaqSteps faqSteps;
    private FaqPage faqPage;
    private final String question;
    private final String expectedAnswer;

    public FaqTest(String browser, String question, String expectedAnswer) {
        super(browser);
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    @Before
    public void setUp() {
        WebDriver driver = null;
        WebDriverWait wait;
        wait = new WebDriverWait(null, getAnInt());
        faqPage = new FaqPage(null, wait);
        faqSteps = new FaqSteps(faqPage);
    }

    private static int getAnInt() {
        return 10;
    }

    @Test
    public void testQuestionAnswerMatching() {
        openPage();
        assertTrue("Вопрос не найден на странице или не виден: " + question, faqPage.isQuestionVisible(question));
        faqSteps.clickQuestion(question);
        String actualAnswer = faqSteps.getAnswer(question);
        assertEquals("Ответ на вопрос '" + question + "' не совпадает.", expectedAnswer, actualAnswer);
    }

    @Test
    public void testAnswersPanelLoading() {
        openPage();
        List<WebElement> answersPanels = faqPage.waitForAnswersPanel();
        assertNotNull("Панели с ответами не загружены", answersPanels);
        assertTrue("Не найдено ни одной панели с ответами", answersPanels.size() > 0);
    }
}
