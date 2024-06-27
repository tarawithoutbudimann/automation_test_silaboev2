package StepDefinitions;

import Utils.DriverLibrary;
import Pages.LoginPage;
import Utils.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    public static WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public static void init() {
        driver = Hooks.getDriver();
    }
    @Given("User opens Silabo application")
    public void user_opens_silabo_application() {
        init();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:8000/landingpage");
    }

    @And("User clicks on the initial login button")
    public void user_clicks_on_the_initial_login_button() {
        loginPage = new LoginPage(driver);
        loginPage.loginButtonPageClick();
    }

    @When("User enters {string} and {string}")
    public void user_enters_credintials(String email, String pass) {
        loginPage.fillCredentials(email, pass);
    }

    @And("User clicks on the submit button")
    public void user_clicks_on_the_submit_button() {
        loginPage.pressSubmitButton();
    }

    @Then("Application displays successful login message")
    public void application_displays_successful_login_message(){
        loginPage.checkSuccessMessage("Sukses masuk");
    }
}
