package Tests;

import PajeObject.OrderPom;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static PajeObject.OrderPom.orderButtonBotom;
import static org.hamcrest.CoreMatchers.containsString;

public class OrderTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void createOrderOne() {
        // ждём загрузку страницы


        OrderPom objOrderElements = new OrderPom(driver);
        objOrderElements.open();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(OrderPom.cookieButton));
        objOrderElements.clickOrderButtonTop();
        //заполняем первую страницу
        objOrderElements.fillFirstPage(
                "Игорь",
                "Степаненко",
                "ул.Волоха, д.5",
                "+78005553535");
        //заполняем вторую страницу
        objOrderElements.fillSecondPage(
                "Позвоните как подойдёте");

        //проверяем
        objOrderElements.clickButtonYes();
        String actualOrderText = objOrderElements.checkOrderIsDone();
        String exceptedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(actualOrderText, containsString(exceptedOrderText));
    }

    @Test

    public void createOrderTwo() {
        OrderPom objOrderElements = new OrderPom(driver);
        objOrderElements.open();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButtonBotom));

// Скролл вниз
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
// Оформление заказа через нижнюю кнопку --------------------------
        objOrderElements.clickOrderButtonBotom();
        objOrderElements.fillFirstPage(
                "Игорь",
                "Степаненко",
                "ул.Волоха, д.5",
                "+78005553535");
        objOrderElements.fillSecondPage(
                "n32jio45nb234ou5###");
        objOrderElements.clickButtonYes();
        String actualOrderText = objOrderElements.checkOrderIsDone();
        String exceptedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(actualOrderText, containsString(exceptedOrderText));
    }

    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }
    }
