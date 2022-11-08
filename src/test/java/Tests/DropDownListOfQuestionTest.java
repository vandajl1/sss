package Tests;

import PajeObject.HomePOM;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static PajeObject.HomePOM.*;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class DropDownListOfQuestionTest {
    private WebDriver driver;
    private final String checkedText;
    private final By locatorOfButton;
    private final By locatorOfTextInTheButton;

    public DropDownListOfQuestionTest(String checkedText, By locatorOfButton, By locatorOfTextInTheButton) {
        this.checkedText = checkedText;
        this.locatorOfButton = locatorOfButton;
        this.locatorOfTextInTheButton = locatorOfTextInTheButton;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", questionButton1, textQuestionButton1},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", questionButton2, textQuestionButton2},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", questionButton3, textQuestionButton3},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", questionButton4, textQuestionButton4},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", questionButton5, textQuestionButton5},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", questionButton6, textQuestionButton6},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", questionButton7, textQuestionButton7},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", questionButton8, textQuestionButton8},


        };
    }


    @Before
    public void setUp() {
        //выбор драйвера для браузера
        driver = new ChromeDriver();
    }

    @Test
    public void checkQuestions1() {
        HomePOM objHomePage = new HomePOM(driver);
        objHomePage.open();
        objHomePage.scrollHomePageDown();
        driver.findElement(locatorOfButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locatorOfTextInTheButton));
        String actualQuestionText = driver.findElement(locatorOfTextInTheButton).getText();

        MatcherAssert.assertThat(actualQuestionText, is(checkedText));

    }

    @After
    public void teardown() {
        // Закрытие браузер
        driver.quit();
    }
}