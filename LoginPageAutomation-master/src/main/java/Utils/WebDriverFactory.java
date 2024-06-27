package Utils;

import Config.UiTestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;

    /**
     * Initializes and returns a WebDriver instance based on the specified browser. If the WebDriver instance is already created, it returns the
     * existing instance. Configures browser window settings and timeouts.
     */
    public static void initBrowser() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(UiTestConstants.IMPLICIT_WAIT));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UiTestConstants.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UiTestConstants.PAGE_LOAD_TIMEOUT));
    }
}
