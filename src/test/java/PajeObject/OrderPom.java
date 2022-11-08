package PajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPom {


    private WebDriver driver;

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //верхняя и нижняя кнопки заказа
    private By orderButtonTop = By.className("Button_Button__ra12g");
    public static By orderButtonBotom = By.className("Button_Middle__1CSJM");

    //1 этап ввода данных для заказа самоката: Имя, фамилия, адрес доставки, станция метро, телефон

    private By inputFirstName = By.xpath(".//div/input[@placeholder ='* Имя']");
    private By inputSecondName = By.xpath(".//div/input[@placeholder ='* Фамилия']");
    private By inputAdressOfOrder = By.xpath(".//div/input[@placeholder ='* Адрес: куда привезти заказ']");
    private By inputMetroStation = By.xpath(".//div/input[@placeholder='* Станция метро']");
    private By inputMetroStationBulvar = By.xpath(".//div[@class='Order_Text__2broi']");
    private By inputTelephoneNumber = By.xpath(".//div/input[@placeholder ='* Телефон: на него позвонит курьер']");


    //2 этап ввода данных для заказа самоката:когда привезти самокат, срок аренды, цвет самоката, комментарий для курьера

    private By dateOfTheDilivering = By.xpath(".//div/input[@placeholder ='* Когда привезти самокат']");
    private By dateOfTheDiliveringCalendar = By.xpath(".//div[@aria-label='Choose четверг, 17-е ноября 2022 г.']");
    private By rentalPeriod = By.className("Dropdown-placeholder");
    private By rentalPeriod3Days = By.xpath(".//div[text()='трое суток']");
    private By blackColourOfScooter = By.id("black");
    private By greyColourOfScooter = By.id("grey");
    private By commentForCourier = By.xpath(".//div/input[@placeholder ='Комментарий для курьера']");

    //общее для оформления заказа:кнопка далее, кнопка да при вопросе "Хотите оформить заказ?"
    private By buttonNext = By.xpath(".//button[text()='Далее']");
    private By buttonYes = By.xpath(".//button[text()='Да']");
    private By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Заказать')]");
    private By orderDoneHeader = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");
    public static By cookieButton = By.className("App_CookieButton__3cvqF");


    public OrderPom(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPom open() {
        driver.get(url);
        return this;
    }

    //Методы кликов верхней и ниженй кнопок заказов

    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButtonBotom() {
        driver.findElement(orderButtonBotom).click();
    }


    //метлды ввода данных на 1 этапе ввода данных для заказа самоката: Имя, фамилия, адрес доставки, станция метро, телефон
    public void setInputFirstName(String firstName) {
        driver.findElement(inputFirstName).sendKeys(firstName);
    }

    public void setInputSecondName(String secondName) {
        driver.findElement(inputSecondName).sendKeys(secondName);
    }

    public void setInputAdressOfOrder(String adressOfOrder) {
        driver.findElement(inputAdressOfOrder).sendKeys(adressOfOrder);
    }

    public void clickInputMetroStation() {
        driver.findElement(inputMetroStation).click();
    }

    public void setinputMetroStationBulvar() {
        driver.findElement(inputMetroStationBulvar).click();
    }

    public void setInputTelephoneNumber(String telephoneNumber) {
        driver.findElement(inputTelephoneNumber).sendKeys(telephoneNumber);
    }

    //методы ввода данных на 2 этапе  заказа самоката:когда привезти самокат, срок аренды, цвет самоката, комментарий для курьера
    public void clickDateOfTheDilivering() {
        driver.findElement(dateOfTheDilivering).click();
    }

    public void setDateOfTheDiliveringCalendar() {
        driver.findElement(dateOfTheDiliveringCalendar).click();
    }

    public void clickRentalPeriod() {
        driver.findElement(rentalPeriod).click();
    }

    public void setRentalPeriod3Days() {
        driver.findElement(rentalPeriod3Days).click();
    }

    public void setBlackColourOfScooter() {
        driver.findElement(blackColourOfScooter).click();
    }

    public void setCommentForCourier(String commentForCour) {
        driver.findElement(commentForCourier).sendKeys(commentForCour);
    }

    //методы для общих кнопок при оформлении заказа
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    public String checkOrderIsDone() {
        return driver.findElement(orderDoneHeader).getText();
    }

    //Соединение всех методов
    public void fillFirstPage(String firstName, String secondName, String adressOfOrder, String telephoneNumber) {
        setInputFirstName(firstName);
        setInputSecondName(secondName);
        setInputAdressOfOrder(adressOfOrder);
        clickInputMetroStation();
        setinputMetroStationBulvar();
        setInputTelephoneNumber(telephoneNumber);
        clickButtonNext();
    }


    public void fillSecondPage(String commentForCour) {
        clickDateOfTheDilivering();
        setDateOfTheDiliveringCalendar();
        clickRentalPeriod();
        setRentalPeriod3Days();
        setBlackColourOfScooter();
        setCommentForCourier(commentForCour);
        clickButtonOrder();
    }


}
