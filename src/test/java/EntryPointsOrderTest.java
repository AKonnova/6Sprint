import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.OrderPage;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static page.MainPage.MAIN_PAGE_URL;
import static page.OrderPage.orderIsProcessed;

public class EntryPointsOrderTest {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(MAIN_PAGE_URL);
    }
    @ParameterizedTest
    @MethodSource("orderParam")
    void firstEntryPointPositiveOrder(String username, String surname, String address, String metro, String telephone, String date, String comment) {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickSignInTopButton();
        orderPage.setUsername(username);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.setMetroStation();
        orderPage.setMetroStationAction(metro);
        orderPage.secondClickMetroStation();
        orderPage.setTelephone(telephone);
        orderPage.clickNextButton();
        orderPage.setDate(date);
        orderPage.setLeaseTerm();
        orderPage.setLeaseTermClick();
        orderPage.clickButtonBlackColor();
        orderPage.setComment(comment);
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        String getRent = driver.findElement(orderIsProcessed).getText();
        assertEquals("Заказ оформлен\n" +
                "Номер заказа: .  Запишите его:\n" +
                "пригодится, чтобы отслеживать статус", getRent);
    }
    static Stream<Arguments> orderParam() {
        return Stream.of(
                Arguments.of("Иванов", "Иван", "Москва, Арбат, д.1", "Черкизовская", "89998887766", "13.08.2025", "Тест"),
                Arguments.of("Сидоров", "Олег", "Московская, д.1", "Черкизовская", "89876543210", "18.08.2025", "Комментарий")
        );
    }
    @ParameterizedTest
    @MethodSource("orderParam")
    void secondEntryPointPositiveOrder(String username, String surname, String address, String metro, String telephone, String date, String comment) {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickAppCookieButton();
        orderPage.clickSignInButtonBottom();
        orderPage.setUsername(username);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.setMetroStation();
        orderPage.setMetroStationAction(metro);
        orderPage.secondClickMetroStation();
        orderPage.setTelephone(telephone);
        orderPage.clickNextButton();
        orderPage.setDate(date);
        orderPage.setLeaseTerm();
        orderPage.setLeaseTermClick();
        orderPage.clickButtonBlackColor();
        orderPage.setComment(comment);
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        String getRent = driver.findElement(orderIsProcessed).getText();
        assertEquals("Заказ оформлен\n" +
                "Номер заказа: .  Запишите его:\n" +
                "пригодится, чтобы отслеживать статус", getRent);
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}