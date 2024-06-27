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
    }

    @And("User opens laboratorium details")
    public void user_opens_laboratorium_details(){
        laboratoriumPage.detailsPage();
    }

    @And("User clicks on the Edit button")
    public void user_clicks_on_the_edit_button(){
        laboratoriumDetailsPage = new LaboratoriumDetailsPage(driver);
        laboratoriumDetailsPage.editPageClick();
    }

    @And("User enters input edit laboratory name {string}, description {string}, and selects type {string}")
    public void user_enters_edit_fields(String name, String description, String type){
        editLaboratoriumPage = new EditLaboratoriumPage(driver);
        editLaboratoriumPage.fillFieldEdit(name, description, type);
    }

    @And("User clicks on the Edit Submit button")
    public void user_clicks_on_the_edit_submit_button(){
        editLaboratoriumPage = new EditLaboratoriumPage(driver);
        editLaboratoriumPage.editFormSubmit();
    }

    @And("User should see a success on editing message and the edited laboratory in the list")
    public void user_should_see_success_edit(){
        loginPage.checkSuccessMessage("Berhasil mengedit data");
    }



}
