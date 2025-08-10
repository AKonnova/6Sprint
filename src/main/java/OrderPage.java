package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends page.MainPage {

    public WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор поля ввода "Имя"
    static By nameField = By.xpath(".//input[@placeholder='* Имя']");

    //Локатор поля ввода "Фамилия"
    static By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    //Локатор поля ввода "Адрес: куда привезти заказ"
    static By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Локатор поля "Станция метро"
    static By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");

    //Локатор проверки "Станция метро"
    static By secondClickMetroStationField = By.xpath(".//div[text()='Черкизовская']");

    //Локатор поля ввода "Телефон"
    static By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Локатор кнопки "Далее"
    static By nextButton = By.xpath(".//button[text()='Далее']");

    //Локатор поля ввода даты "Когда привезти самокат"
    static By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Локатор поля "Срок аренды"
    static By leaseTerm = By.className("Dropdown-arrow");

    //Локатор выбора "Срок аренды"
    static By leaseTermAction = By.xpath(".//div[@class='Dropdown-menu']/div[text()='двое суток']");

    //Локатор поля "Цвет самоката" - чёрный жемчуг
    static By blackColor = By.id("black");

    //Локатор поля "Цвет самоката" - серая безысходность
    static By greyColor = By.id("grey");

    //Локатор поля ввода "Комментарий для курьера"
    static By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Локатор кнопки "Заказать" на форме Про аренду
    static By orderButton = By.xpath(".//div[starts-with(@class, 'Order_Buttons')]/button[text()='Заказать']");

    //Локатор кнопки "Да" окна "Подтверждения"
    static By yesButton = By.xpath(".//button[text()='Да']");

    //Локатор формы "Заказ оформлен"
    public static By orderIsProcessed = By.xpath(".//div[starts-with(@class, 'Order_ModalHeader')]");

    //Метод клика по кнопке "Заказать" сверху страницы
    public void clickSignInTopButton() {
        driver.findElement(signInTopButton).click();
    }

    //Метод клика по кнопке "Заказать" внизу страницы
    public void clickSignInButtonBottom() {
        driver.findElement(signInBottomButton).click();
    }

    //Метод по закрытию сообщения о куках.
    public void clickAppCookieButton() {
        driver.findElement(appCookieButton).click();
    }

    //Метод заполнения поля ввода "Имя"
    public void setUsername(String username) {
        driver.findElement(nameField).sendKeys(username);
    }

    //Метод заполнения поля ввода "Фамилия"
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    //Метод заполнения поля ввода "Адрес"
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //Метод клика по полю "Станция метро"
    public void setMetroStation() {
        driver.findElement(metroStationField).click();
    }

    //Метод подтверждение выбора станции метро
    public void secondClickMetroStation() {
        driver.findElement(secondClickMetroStationField).click();
    }

    //Метод заполнения поля "Станция метро"
    public void setMetroStationAction(String metro) {
        driver.findElement(metroStationField).sendKeys(metro);
    }

    //Метод заполнения поля ввода "Телефон"
    public void setTelephone(String telephone) {
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    //Метод клика по кнопке "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    //Метод заполнения поля ввода "Даты"
    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    //Метод клика по полю "Срок аренды"
    public void setLeaseTerm() {
        driver.findElement(leaseTerm).click();
    }

    //Метод выбора поля "Срок аренды"
    public void setLeaseTermClick() {
        driver.findElement(leaseTermAction).click();
    }

    //Метод клика по "чёрный жемчуг"
    public void clickButtonBlackColor() {
        driver.findElement(blackColor).click();
    }

    //Метод клика по "серая безысходность"
    public void clickButtonGreyColor() {
        driver.findElement(greyColor).click();
    }

    //Метод заполнения поля ввода "Комментарий"
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //Метод клика по кнопке "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //Метод клика по кнопке "Да" окна "Подтверждения"
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    //Проверить, что заказ создался
    public void checkOrderOpenAndHasOrderNumber() {
        driver.findElement(orderIsProcessed);
    }

    //Метод клика по аккордеону
    public void clickImportantQuestionsItem() {
        driver.findElement(importantQuestionsItem).click();
    }

    //Локаторы для вопросов
    private static final By[] QUESTION_LOCATORS = {
            By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7")
    };

    private static final By[] ANSWER_LOCATORS = {
            By.id("accordion__panel-0"),
            By.id("accordion__panel-1"),
            By.id("accordion__panel-2"),
            By.id("accordion__panel-3"),
            By.id("accordion__panel-4"),
            By.id("accordion__panel-5"),
            By.id("accordion__panel-6"),
            By.id("accordion__panel-7")
    };

    // Методы для работы с вопросами
    public void clickQuestion(int index) {
        driver.findElement(QUESTION_LOCATORS[index]).click();
    }

    public String getQuestionText(int index) {
        return driver.findElement(QUESTION_LOCATORS[index]).getText();
    }

    public String getAnswerText(int index) {
        return driver.findElement(ANSWER_LOCATORS[index]).getText();
    }
}
