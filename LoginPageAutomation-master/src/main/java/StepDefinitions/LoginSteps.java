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
        try {
            init();
            driver.manage().window().maximize();
            driver.get("http://127.0.0.1:8000/landingpage");
            Hooks.loginTest.pass("Successfully open SiLaboe landing page");
        } catch (Exception e) {
            Hooks.loginTest.fail("Failed open SiLaboe landing page");
        }
    }

    @And("User clicks on the initial login button")
    public void user_clicks_on_the_initial_login_button() {
        try {
            loginPage = new LoginPage(driver);
            loginPage.loginButtonPageClick();
            Hooks.loginTest.pass("Successfully clicked login button");
        } catch (Exception e) {
            Hooks.loginTest.fail("Failed clicked login button");
        }
    }

    @When("User enters {string} and {string}")
    public void user_enters_credintials(String email, String pass) {
        try{
            loginPage.fillCredentials(email, pass);
            Hooks.loginTest.pass("Successfully fill the login fields");
        } catch (Exception e) {
            Hooks.loginTest.fail("Failed fill the login fields");
        }
    }

    @And("User clicks on the submit button")
    public void user_clicks_on_the_submit_button() {
        try {
            loginPage.pressSubmitButton();
            Hooks.loginTest.pass("Successfully clicked the submit button");
        } catch (Exception e) {
            Hooks.loginTest.fail("Failed click the submit button");
        }
    }

    @Then("Application displays successful login message")
    public void application_displays_successful_login_message(){
        try {
            loginPage.checkSuccessMessage("Sukses masuk");
            Hooks.loginTest.pass("Successfully login");
        } catch (Exception e) {
            Hooks.loginTest.fail("Failed login");
        }
    }
}
