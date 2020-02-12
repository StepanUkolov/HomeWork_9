package company.steps;

import company.util.TestProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Сценарий :
 * 1.  Перейти по ссылке - https://rencredit.ru
 * 2.  Перейти в меню – Вклады
 * 3.  Выбрать – Рубли
 * 4.  Заполнить сумму вклада
 * 5.  Срок – 6 месяцев
 * 6.  Заполнить  ежемесячное пополнение
 * 7.  Отметить – Ежемесячная капитализация, Ежемесячное пополнение  (при необходимости)
 * 8.  Проверить расчеты по вкладу (см. скриншоты)
 */

public class BaseSteps {

    private static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() throws MalformedURLException {

        switch (properties.getProperty("browser")){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }
        baseUrl = properties.getProperty("app.url");
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    @After
    public static void tearDown() {
        driver.quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    public static void scrollDown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor jse = (JavascriptExecutor)BaseSteps.getDriver();
        jse.executeScript("window.scrollBy(0,1000)");
    }

}
