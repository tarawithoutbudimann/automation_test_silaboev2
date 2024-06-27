package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DriverLibrary extends WebDriverFactory {


    public DriverLibrary() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits for the visibility of the WebElement, focuses on it, and performs a click using JavascriptExecutor. This method is used to ensure a
     * reliable click operation, especially when dealing with elements that might not respond consistently to traditional WebDriver clicks.
     *
     * @param element The WebElement to be clicked.
     */
    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Sends keys to a WebElement after ensuring its visibility.
     *
     * @param element    The WebElement to send keys to.
     * @param keysToSend The keys to be sent.
     */
    public void sendKeysToElement(WebElement element, CharSequence keysToSend) {
        WebElement clickableElement = wait.until(ExpectedConditions.visibilityOf(element));
        clickableElement.sendKeys(keysToSend);
    }

}

