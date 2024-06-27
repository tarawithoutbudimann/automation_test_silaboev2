package StepDefinitions;

import StepDefinitions.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest loginTest;
    public static ExtentTest createLaboratoriumTest;
    public static ExtentTest deleteLaboratoriumTest;
    public static ExtentTest updateLaboratoriumTest;

    @BeforeAll
    public static void setUp() {
        extent = ExtentReportManager.getInstance();
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        createLaboratoriumTest = extent.createTest("Create Laboratorium Test");
        deleteLaboratoriumTest = extent.createTest("Delete Laboratorium Test");
        updateLaboratoriumTest = extent.createTest("Update Laboratorium Test");
        loginTest = extent.createTest("Login test");

        createLaboratoriumTest.log(Status.INFO, "Start Create Laboratorium Test");
        deleteLaboratoriumTest.log(Status.INFO, "Start Delete Laboratorium Test");
        updateLaboratoriumTest.log(Status.INFO, "Start Update Laboratorium Test");
        loginTest.log(Status.INFO, "Start Login Admin Test");

    }
    public static WebDriver getDriver() {
        if (driver == null) new Hooks().setUp();
        return driver;
    }
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

        createLaboratoriumTest.log(Status.INFO, "Close Create Laboratorium");
        deleteLaboratoriumTest.log(Status.INFO, "Close Delete Laboratorium");
        updateLaboratoriumTest.log(Status.INFO, "Close Update Laboratorium");
        loginTest.log(Status.INFO, "Close Login Admin");

        extent.flush();
    }


}