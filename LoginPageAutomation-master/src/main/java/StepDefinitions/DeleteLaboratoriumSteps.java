package StepDefinitions;

import Pages.EditLaboratoriumPage;
import Pages.LaboratoriumDetailsPage;
import Pages.LaboratoriumPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLaboratoriumSteps {
    public static WebDriver driver;
    LoginPage loginPage;
    LaboratoriumPage laboratoriumPage;
    LaboratoriumDetailsPage laboratoriumDetailsPage;
    private LoginSteps loginSteps = new LoginSteps();


    @BeforeClass
    public static void init() {
        driver = Hooks.getDriver();
    }
    @Given("User signed as admin and in the laboratorium details page")
    public void user_signed_as_admin_and_in_the_laboratorium_details_page(){
        try{
            init();
            driver.manage().window().maximize();
            driver.get("http://127.0.0.1:8000/landingpage");
            loginPage = new LoginPage(driver);
            loginPage.loginButtonPageClick();
            loginPage.fillCredentials("admin@silaboe.com", "admin123");
            loginPage.pressSubmitButton();
            loginPage.checkSuccessMessage("Sukses masuk");
            loginPage.navigateToDashboard();
            laboratoriumPage = new LaboratoriumPage(driver);
            laboratoriumPage.laboratoriumPageClick();
            laboratoriumPage.detailsPage();
            Hooks.deleteLaboratoriumTest.pass("Successfully sign in and get into laboratory details page");
        }
        catch (Exception e){
            Hooks.deleteLaboratoriumTest.fail("Failed to sign in and get into laboratory details page");
        }

    }

    @And("User clicks on the Delete button")
    public void user_clicks_on_the_edit_button(){
        try{
            laboratoriumDetailsPage = new LaboratoriumDetailsPage(driver);
            laboratoriumDetailsPage.deleteSubmit();
            Hooks.deleteLaboratoriumTest.pass("Successfully click edit button");
        }
        catch (Exception e){
            Hooks.deleteLaboratoriumTest.fail("Failed click edit button");
        }
    }

    @Then("User should see a success message and the laboratory is deleted")
    public void user_should_see_success_deleted(){
        try{
            loginPage.checkSuccessMessage("Berhasil menghapus data");
            Hooks.deleteLaboratoriumTest.pass("Successfully deleted laboratory data");
        }
        catch (Exception e){
            Hooks.deleteLaboratoriumTest.fail("Failed deleted laboratory data");
        }
    }
}
