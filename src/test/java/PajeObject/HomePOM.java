package PajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePOM {


    private WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";


    //локаторы для каждой строчки выпадающего списка в разделе «Вопросы о важном».
    public static By questionButton1 = By.id("accordion__heading-0");
    public static By questionButton2 = By.id("accordion__heading-1");
    public static By questionButton3 = By.id("accordion__heading-2");
    public static By questionButton4 = By.id("accordion__heading-3");
    public static By questionButton5 = By.id("accordion__heading-4");
    public static By questionButton6 = By.id("accordion__heading-5");
    public static By questionButton7 = By.id("accordion__heading-6");
    public static By questionButton8 = By.id("accordion__heading-7");

    //локаторы для текста в каждой строчке выпадающего списка в разделе «Вопросы о важном».
    public static By textQuestionButton1 = By.id("accordion__panel-0");
    public static By textQuestionButton2 = By.id("accordion__panel-1");
    public static By textQuestionButton3 = By.id("accordion__panel-2");
    public static By textQuestionButton4 = By.id("accordion__panel-3");
    public static By textQuestionButton5 = By.id("accordion__panel-4");
    public static By textQuestionButton6 = By.id("accordion__panel-5");
    public static By textQuestionButton7 = By.id("accordion__panel-6");
    public static By textQuestionButton8 = By.id("accordion__panel-7");

    public HomePOM(WebDriver driver) {
        this.driver = driver;

    }

    public HomePOM open() {
        driver.get(url);
        return this;
    }


    //метод для прокрутки страницы вниз к списку вопросов.
    public void scrollHomePageDown() {
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }


}
