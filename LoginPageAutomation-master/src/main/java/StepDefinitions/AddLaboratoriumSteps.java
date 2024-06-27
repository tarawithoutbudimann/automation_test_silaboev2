package StepDefinitions;

import Pages.AddFormLaboratoriumPage;
import Pages.LaboratoriumPage;
import Pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.Hook;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class AddLaboratoriumSteps {
    public static WebDriver driver;
    LoginPage loginPage;
    LaboratoriumPage laboratoriumPage;
    AddFormLaboratoriumPage addFormLaboratoriumPage;
    ExtentReports extent;
    private LoginSteps loginSteps = new LoginSteps();

    @BeforeClass
    public static void init() {
        driver = Hooks.getDriver();
    }
    @Given("User signed as admin")
    public void user_signed_as_admin(){
        try{
            init();
            extent = ExtentReportManager.getInstance();
            driver.manage().window().maximize();
            driver.get("http://127.0.0.1:8000/landingpage");
            loginPage = new LoginPage(driver);
            loginPage.loginButtonPageClick();
            loginPage.fillCredentials("admin@silaboe.com", "admin123");
            loginPage.pressSubmitButton();
            loginPage.checkSuccessMessage("Sukses masuk");
            Hooks.createLaboratoriumTest.pass("Successfully signed as admin");
        }
        catch (Exception e){
            Hooks.createLaboratoriumTest.fail("Failed signing as admin");
        }
    }

    @And("User navigates to the dashboard")
    public void user_navigates_to_the_dashboard(){
        try{
            loginPage.navigateToDashboard();
            Hooks.createLaboratoriumTest.pass("Successfully navigate to dashboard");
        } catch (Exception e) {
            Hooks.createLaboratoriumTest.fail("Failed navigate to dashboard");
        }
    }

    @And("User goes to the laboratory page")
    public void user_goes_to_the_laboratory_page(){
        try{
            laboratoriumPage = new LaboratoriumPage(driver);
            laboratoriumPage.laboratoriumPageClick();
            Hooks.createLaboratoriumTest.pass("Successfully navigate to laboratory page");
        }
        catch (Exception e){
            Hooks.createLaboratoriumTest.fail("Failed navigate to laboratory page");
        }

    }

    @And("User opens the add laboratory form")
    public void user_opens_the_add_laboratory_form(){
        try{
            laboratoriumPage.addLaboratoriumClick();
            Hooks.createLaboratoriumTest.pass("Successfully navigate to laboratory form");
        }
        catch (Exception e){
            Hooks.createLaboratoriumTest.fail("Failed navigate to laboratory form");
        }
    }

    @And("User enters laboratory name {string}, description {string}, and selects type {string}")
    public void user_enters_fields(String name, String description, String type){
        try{
            addFormLaboratoriumPage = new AddFormLaboratoriumPage(driver);
            addFormLaboratoriumPage.fillField(name, description, type);
            Hooks.createLaboratoriumTest.pass("Successfully input the fields");
        }
        catch (Exception e){
            Hooks.createLaboratoriumTest.fail("Failed input the fields");
        }

    }

    @And("User clicks on the Submit button")
    public void user_clicks_on_the_submit(){
        try{
            addFormLaboratoriumPage.clickSubmit();
            Hooks.createLaboratoriumTest.pass("Successfully submitted");
        }
        catch (Exception e){
            Hooks.createLaboratoriumTest.fail("Failed to submit");
        }
    }

    @Then("User should see a success message and the new laboratory in the list")
    public void user_should_see_a_success_message(){
        try{
            loginPage.checkSuccessMessage("Berhasil menambahkan data");
            Hooks.createLaboratoriumTest.pass("Successfully create laboratory");
        }
        catch (Exception e){
            Hooks.createLaboratoriumTest.fail("Failed to create laboratory");
        }
    }
}
