package Pages;

import Utils.DriverLibrary;
import Utils.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends WebDriverFactory {

    WebDriver driver;
    private By loginPageButton = new By.ById("loginPageButton");
    private By emailInput = new By.ByName("email");
    private By passwordInput = new By.ByName("password");
    private By submitBtn = new By.ById("loginButton");
    private By swalText = new By.ByClassName("swal-text");
    private By okButton = By.xpath("//div[@class='swal-modal' and @role='dialog']//button[@class='swal-button swal-button--confirm']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginButtonPageClick(){
        driver.findElement(loginPageButton).click();
    }

    public void fillCredentials(String username, String pass) {
        driver.findElement(emailInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(pass);
    }

    public void pressSubmitButton() {
        driver.findElement(submitBtn).submit();
    }

    public void checkSuccessMessage(String text){
        String swalTextValue =  driver.findElement(swalText).getText();
        Assert.assertTrue(swalTextValue.equals(text));
    }

    public void navigateToDashboard(){
        driver.findElement(okButton).click();
    }

}
