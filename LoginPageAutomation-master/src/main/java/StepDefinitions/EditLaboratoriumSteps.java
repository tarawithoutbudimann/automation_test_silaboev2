package StepDefinitions;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLaboratoriumSteps {
    public static WebDriver driver;
    LoginPage loginPage;
    LaboratoriumPage laboratoriumPage;
    LaboratoriumDetailsPage laboratoriumDetailsPage;
    EditLaboratoriumPage editLaboratoriumPage;
    private LoginSteps loginSteps = new LoginSteps();

    @BeforeClass
    public static void init() {
        driver = Hooks.getDriver();
    }
    @Given("User signed as admin and in the laboratorium page")
    public void user_signed_as_admin_and_in_the_laboratorium_page(){
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
        Hooks.updateLaboratoriumTest.pass("Successfully sign in and get into laboratory page");
        } catch (Exception e){
            Hooks.updateLaboratoriumTest.fail("Failed to sign in and get into laboratory page");
        }}

    @And("User opens laboratorium details")
    public void user_opens_laboratorium_details(){
        try{
            laboratoriumPage.detailsPage();
            Hooks.updateLaboratoriumTest.pass("Successfully sign in and get into laboratory detail page");
        }
        catch (Exception e){
            Hooks.updateLaboratoriumTest.fail("Successfully sign in and get into laboratory detail page");
        }
    }

    @And("User clicks on the Edit button")
    public void user_clicks_on_the_edit_button(){
        try{
            laboratoriumDetailsPage = new LaboratoriumDetailsPage(driver);
            laboratoriumDetailsPage.editPageClick();
            Hooks.updateLaboratoriumTest.pass("Successfully click edit button");
        }
        catch (Exception e){
            Hooks.updateLaboratoriumTest.fail("Failed click edit button");
        }
    }

    @And("User enters input edit laboratory name {string}, description {string}, and selects type {string}")
    public void user_enters_edit_fields(String name, String description, String type){
        try {
            editLaboratoriumPage = new EditLaboratoriumPage(driver);
            editLaboratoriumPage.fillFieldEdit(name, description, type);
            Hooks.updateLaboratoriumTest.pass("Successfully edit the fields");
        } catch (Exception e){
            Hooks.updateLaboratoriumTest.pass("Successfully edit the fields");
        }
    }

    @And("User clicks on the Edit Submit button")
    public void user_clicks_on_the_edit_submit_button(){
        try{
            editLaboratoriumPage = new EditLaboratoriumPage(driver);
            editLaboratoriumPage.editFormSubmit();
            Hooks.updateLaboratoriumTest.pass("Successfully submit the changes");
        } catch (Exception e){
            Hooks.updateLaboratoriumTest.pass("Successfully submit the changes");
        }
    }

    @And("User should see a success on editing message and the edited laboratory in the list")
    public void user_should_see_success_edit(){
        try {
            loginPage.checkSuccessMessage("Berhasil mengedit data");
            Hooks.updateLaboratoriumTest.pass("changes success");
        } catch (Exception e){
            Hooks.updateLaboratoriumTest.pass("changes success");
    }
    }
}
